package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Car;

import javax.ejb.Stateless;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UserCarBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCarBean.class);
    
    public List<Car> getUserCars(String token) {
        return null;
    }

    public Car addUserCar(Car car, String token) {
        return null;
    }

    public int deleteUserCar(String token) {
        return 0;
    }
}
