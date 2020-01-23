/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.t4.opendata.backend.beans;

import java.util.List;
import nu.t4.opendata.backend.entities.Car;

/**
 *
 * @author Olle
 */
public class UserCars {
    private int id;
    private List<Car>cars;
    private String  username;

    public UserCars(int id, List<Car> cars, String username) {
        this.id = id;
        this.cars = cars;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
}
