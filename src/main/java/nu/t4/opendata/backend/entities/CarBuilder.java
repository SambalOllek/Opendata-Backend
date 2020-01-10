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

    public void id(int mId) {
        this.mId = mId;
    }

    public void userId(int mUserId) {
        this.mUserId = mUserId;
    }

    public void username(String mUsername) {
        this.mUsername = mUsername;
    }

    public void link(String mLink) {
        this.mLink = mLink;
    }

    public void address(String mAddress) {
        this.mAddress = mAddress;
    }

    public void brand(String mBrand) {
        this.mBrand = mBrand;
    }

    public void model(String mModel) {
        this.mModel = mModel;
    }

    public void milage(int mMilage) {
        this.mMilage = mMilage;
    }

    public void fuel(String mFuel) {
        this.mFuel = mFuel;
    }

    public void gearbox(String mGearbox) {
        this.mGearbox = mGearbox;
    }

    public void drivewheel(String mDrivewheel) {
        this.mDrivewheel = mDrivewheel;
    }

    public void regnum(String mRegnum) {
        this.mRegnum = mRegnum;
    }

    public void price(int mPrice) {
        this.mPrice = mPrice;
    }

    public void year(int mYear) {
        this.mYear = mYear;
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
