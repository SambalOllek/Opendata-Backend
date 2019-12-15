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
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class CarBean {
    
    static final Logger logger = LoggerFactory.getLogger(CarBean.class);
    
    /**
     *
     * @return
     */
    public List<Car> getCars(){
        
        List<Car> cars = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM item";
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
            logger.error(e.getMessage());
        }
        return cars;
    }

    /**
     *
     * @param item
     * @return
     */
    int addCar(Car car){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO item VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            return stmt.executeUpdate();
        } catch (Exception e) {
            //TODO: fixa logger
            System.out.println("Error in ItemBean.addItem: " + e.getMessage());
        }
        return 0;
    }

    /**
     *
     * @param itemId
     * @return
     */
    int removeCar(int carId){
        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM item WHERE id = ?");
            stmt.setInt(1, carId);
            return stmt.executeUpdate();
        } catch (Exception e) {
            //TODO: fixa logger
            System.out.println("Error in ItemBean.removeItem: " + e.getMessage());
        }
        return 0;
    }


}
