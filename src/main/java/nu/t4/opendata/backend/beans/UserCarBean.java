package nu.t4.opendata.backend.beans;

import nu.t4.opendata.backend.entities.Car;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserCarBean {

    public List<Car> getUserCars(int userId) {
        return null;
    }

    public Car addUserCar(Car item) {
        return null;
    }

    public int deleteUserCar() {
        return 0;
    }
}
