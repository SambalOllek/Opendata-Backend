package nu.t4.opendata.backend.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import nu.t4.opendata.backend.ConnectionFactory;
import nu.t4.opendata.backend.entities.Car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik
 */
@Stateless
public class CarBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarBean.class);

    /**
     * Selects all cars from database
     *
     * @return Returns a list of cars
     */
    public List<Car> getCars() {
        List<Car> cars = new ArrayList();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM car";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                Car car = new Car();
                car.setId(data.getInt("id"));
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
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return cars;
    }

    /**
     * Inserts car object to database
     *
     * @param car Car object to insert
     * @return Returns 0 if failed to insert and 1 if success
     */
    public int addCar(Car car) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO car VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, car.getLink());
            stmt.setString(2, car.getBrand());
            stmt.setString(3, car.getRegnum());
            stmt.setString(4, car.getAddress());
            stmt.setString(5, car.getModel());
            stmt.setString(6, car.getDrivewheel());
            stmt.setInt(7, car.getMilage());
            stmt.setInt(8, car.getPrice());
            stmt.setString(9, car.getGearbox());
            stmt.setInt(10, car.getYear());
            stmt.setString(11, car.getFuel());
            return stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

    /**
     * Deletes a car object from database
     *
     * @param carId Id of car to delete
     * @return Returns 0 if failed to insert and 1 if success
     */
    int removeCar(int carId) {
        try ( Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM car WHERE id = ?");
            stmt.setInt(1, carId);
            return stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}
