package safe.model;

public class WishList {
    protected int wishListID;
    protected User user;
    protected CityInformation cityProfile;
    protected StateProfile stateProfile;
    protected CountyProfile countyProfile;

    public WishList(int wishListID, User user, CityInformation cityProfile, StateProfile stateProfile, CountyProfile countyProfile) {
        this.wishListID = wishListID;
        this.user = user;
        this.cityProfile = cityProfile;
        this.stateProfile = stateProfile;
        this.countyProfile = countyProfile;
    }

    public WishList(User user, CityInformation cityProfile, StateProfile stateProfile, CountyProfile countyProfile) {
        this.user = user;
        this.cityProfile = cityProfile;
        this.stateProfile = stateProfile;
        this.countyProfile = countyProfile;
    }

    public WishList(int wishListID) {
        this.wishListID = wishListID;
    }

    public int getWishListID() {
        return wishListID;
    }

    public void setWishListID(int wishListID) {
        this.wishListID = wishListID;
    }

    public User getUser() {
        return user;
    }

    public void setUserName(User user) {
        this.user = user;
    }

    public CityInformation getCityProfile() {
        return cityProfile;
    }

    public void setCityProfile(CityInformation cityProfile) {
        this.cityProfile = cityProfile;
    }

    public StateProfile getStateProfile() {
        return stateProfile;
    }

    public void setStateProfile(StateProfile stateProfile) {
        this.stateProfile = this.stateProfile;
    }

    public CountyProfile getCountyProfile() {
        return countyProfile;
    }

    public void setCountyProfile(CountyProfile countyProfile) {
        this.countyProfile = countyProfile;
    }
}
