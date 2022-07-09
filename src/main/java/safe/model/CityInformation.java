package safe.model;

public class CityInformation {
  protected Integer CityId;
  protected String CityName;
  protected String CountyName;
  protected String StateName;
  protected String StateCode;
  protected Integer CountyProfiledId;
  protected Integer StateProfiledId;

  public CityInformation(Integer cityId, String cityName, String countyName, String stateName, String stateCode, Integer countyProfiledId, Integer stateProfiledId) {
    CityId = cityId;
    CityName = cityName;
    CountyName = countyName;
    StateName = stateName;
    StateCode = stateCode;
    CountyProfiledId = countyProfiledId;
    StateProfiledId = stateProfiledId;
  }

  public Integer getCityId() {
    return CityId;
  }

  public String getCityName() {
    return CityName;
  }

  public String getCountyName() {
    return CountyName;
  }

  public String getStateName() {
    return StateName;
  }

  public String getStateCode() {
    return StateCode;
  }

  public Integer getCountyProfiledId() {
    return CountyProfiledId;
  }

  public Integer getStateProfileId() {
    return StateProfiledId;
  }
}
