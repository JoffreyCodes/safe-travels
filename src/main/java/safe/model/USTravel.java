package safe.model;

public class USTravel {
    protected int travelID;
    protected int stateFIPS;
    protected long popStayingAtHome;
    protected long popNotStayingAtHome;
    protected double percentTakingTrips;
    protected String stateName;
    protected int profileID;

    public USTravel(int travelID, int stateFIPS, int profileID, long popStayingAtHome, long popNotStayingAtHome, double percentTakingTrips, String stateName) {
        this.travelID = travelID;
        this.stateFIPS = stateFIPS;
        this.profileID = profileID;
        this.popStayingAtHome = popStayingAtHome;
        this.popNotStayingAtHome = popNotStayingAtHome;
        this.percentTakingTrips = percentTakingTrips;
        this.stateName = stateName;
    }

    public int getTravelID() {
        return travelID;
    }

    public void setTravelID(int travelID) {
        this.travelID = travelID;
    }

    public int getStateFIPS() {
        return stateFIPS;
    }

    public void setStateFIPS(int stateFIPS) {
        this.stateFIPS = stateFIPS;
    }

    public int getStateProfileID() {
        return profileID;
    }

    public void setStateProfile(int stateProfileID) {
        this.profileID = stateProfileID;
    }

    public long getPopStayingAtHome() {
        return popStayingAtHome;
    }

    public void setPopStayingAtHome(long popStayingAtHome) {
        this.popStayingAtHome = popStayingAtHome;
    }

    public long getPopNotStayingAtHome() {
        return popNotStayingAtHome;
    }

    public void setPopNotStayingAtHome(long popNotStayingAtHome) {
        this.popNotStayingAtHome = popNotStayingAtHome;
    }

    public double getPercentTakingTrips() {
        return percentTakingTrips;
    }

    public void setPercentTakingTrips(double percentTakingTrips) {
        this.percentTakingTrips = percentTakingTrips;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
