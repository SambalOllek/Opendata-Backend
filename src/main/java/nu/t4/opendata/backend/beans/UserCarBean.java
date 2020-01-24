package nu.t4.opendata.backend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nu.t4.opendata.backend.entities.Car;

import javax.ejb.Stateless;
import java.util.List;
import nu.t4.opendata.backend.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UserCarBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCarBean.class);

    public UserCars getUserCars(String token) {
        UserCars usercars = null;
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM user_car_full_info WHERE user_id IN (SELECT id FROM user WHERE token = ?)");
            stmt.setString(1, token);
            List<Car> cars = new ArrayList();
            String username = "";
            int user_id = 0;
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                Car car = new Car();
                car.setId(data.getInt("item_id"));
                username = data.getString("username");
                user_id = data.getInt("user_id");
                car.setAddress(data.getString("address"));
                car.setBrand(data.getString("brand"));
                car.setDrivewheel(data.getString("drivewheel"));
                car.setFuel(data.getString("fuel"));
                car.setMilage(data.getInt("milage"));
                car.setPrice(data.getInt("price"));
                car.setLink(data.getString("link"));
                car.setRegnum(data.getString("regnum"));
                car.setModel(data.getString("model"));
                car.setGearbox(data.getString("gearbox"));
                car.setYear(data.getInt("year"));
                cars.add(car);
            }
            usercars = new UserCars(user_id, cars, username);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return usercars;
    }

    public int addUserCar(Car car, String token) {
        int userId = 0;
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT id FROM user WHERE token = ?");
            stmt.setString(1, token);
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                userId = data.getInt("id");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        if (userId != 0) {
            try ( Connection connection = ConnectionFactory.getConnection()) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO user_car VALUES (?, ?)");
                stmt.setInt(1, userId);
                stmt.setInt(2, car.getId());
                return stmt.executeUpdate();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        return 0;
    }

    public int deleteUserCar(String token, int carId) {
        int userId = 0;
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT id FROM user WHERE token = ?");
            stmt.setString(1, token);
            ResultSet data = stmt.executeQuery();
            if (data.next()) {
                userId = data.getInt("id");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM user_car WHERE user_id = ? AND car_id = ?");
            stmt.setInt(1, userId);
            stmt.setInt(2, carId);
            stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return 0;
        }
        return 1;

    }
}
