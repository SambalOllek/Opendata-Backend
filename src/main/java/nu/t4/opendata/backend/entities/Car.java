package nu.t4.opendata.backend.entities;

/**
 * @author Erik
 */
public class Car {
    private int id;
    private int userId;
    private String username;
    private String link;
    private String address;
    private String brand;
    private String model;
    private int milage;
    private String fuel;
    private String gearbox;
    private String drivewheel;
    private String regnum;
    private int price;
    private int year;

    public Car(int id, int userId, String username, String link, String address, String brand, String model, int milage, String fuel, String gearbox, String drivewheel, String regnum, int price, int year) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.link = link;
        this.address = address;
        this.brand = brand;
        this.model = model;
        this.milage = milage;
        this.fuel = fuel;
        this.gearbox = gearbox;
        this.drivewheel = drivewheel;
        this.regnum = regnum;
        this.price = price;
        this.year = year;
    }

    public Car() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getDrivewheel() {
        return drivewheel;
    }

    public void setDrivewheel(String drivewheel) {
        this.drivewheel = drivewheel;
    }

    public String getRegnum() {
        return regnum;
    }

    public void setRegnum(String regnum) {
        this.regnum = regnum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", userId=" + userId + ", username=" + username + ", link=" + link + ", address=" + address + ", brand=" + brand + ", model=" + model + ", milage=" + milage + ", fuel=" + fuel + ", gearbox=" + gearbox + ", drivewheel=" + drivewheel + ", regnum=" + regnum + ", price=" + price + ", year=" + year + '}';
    }
}
