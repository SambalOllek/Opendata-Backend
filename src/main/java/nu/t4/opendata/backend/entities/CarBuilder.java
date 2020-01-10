package nu.t4.opendata.backend.entities;

/**
 *
 * @author Erik
 */
public class CarBuilder {

    private int mId;
    private int mUserId;
    private String mUsername;
    private String mLink;
    private String mAddress;
    private String mBrand;
    private String mModel;
    private int mMilage;
    private String mFuel;
    private String mGearbox;
    private String mDrivewheel;
    private String mRegnum;
    private int mPrice;
    private int mYear;

    /**
     * Builds a Car object from values set. If link or address is not set IllegalStateException will be thrown
     * @return Returns a Car object
     */
    public Car build() {
        if (link() == null) {
            throw new IllegalStateException("Car must have a link to destination site");
        }
        if (address() == null) {
            throw new IllegalStateException("Car must have a address to its location");
        }
        if (id() < 0) {
            id(0);
        }
        if (userId() < 0) {
            userId(0);
        }
        if (username() == null) {
            username("");
        }
        if (brand() == null) {
            brand("");
        }
        if (model() == null) {
            model("");
        }
        if (milage() < 0) {
            milage(0);
        }
        if (fuel() == null) {
            fuel("");
        }
        if (gearbox() == null) {
            gearbox("");
        }
        if (drivewheel() == null) {
            drivewheel("");
        }
        if (regnum() == null) {
            regnum("");
        }
        if (price() < 0) {
            price(0);
        }
        if (year() < 0) {
            year(0);
        }
        return new Car(this);
    }

    public CarBuilder() {
    }

    
    public CarBuilder id(int mId) {
        this.mId = mId;
        return this;
    }

    public CarBuilder userId(int mUserId) {
        this.mUserId = mUserId;
        return this;
    }

    public CarBuilder username(String mUsername) {
        this.mUsername = mUsername;
        return this;
    }

    public CarBuilder link(String mLink) {
        this.mLink = mLink;
        return this;
    }

    public CarBuilder address(String mAddress) {
        this.mAddress = mAddress;
        return this;
    }

    public CarBuilder brand(String mBrand) {
        this.mBrand = mBrand;
        return this;
    }

    public CarBuilder model(String mModel) {
        this.mModel = mModel;
        return this;
    }

    public CarBuilder milage(int mMilage) {
        this.mMilage = mMilage;
        return this;
    }

    public CarBuilder fuel(String mFuel) {
        this.mFuel = mFuel;
        return this;
    }

    public CarBuilder gearbox(String mGearbox) {
        this.mGearbox = mGearbox;
        return this;
    }

    public CarBuilder drivewheel(String mDrivewheel) {
        this.mDrivewheel = mDrivewheel;
        return this;
    }

    public CarBuilder regnum(String mRegnum) {
        this.mRegnum = mRegnum;
        return this;
    }

    public CarBuilder price(int mPrice) {
        this.mPrice = mPrice;
        return this;
    }

    public CarBuilder year(int mYear) {
        this.mYear = mYear;
        return this;
    }

    public int id() {
        return mId;
    }

    public int userId() {
        return mUserId;
    }

    public String username() {
        return mUsername;
    }

    public String link() {
        return mLink;
    }

    public String address() {
        return mAddress;
    }

    public String brand() {
        return mBrand;
    }

    public String model() {
        return mModel;
    }

    public int milage() {
        return mMilage;
    }

    public String fuel() {
        return mFuel;
    }

    public String gearbox() {
        return mGearbox;
    }

    public String drivewheel() {
        return mDrivewheel;
    }

    public String regnum() {
        return mRegnum;
    }

    public int price() {
        return mPrice;
    }

    public int year() {
        return mYear;
    }

}
