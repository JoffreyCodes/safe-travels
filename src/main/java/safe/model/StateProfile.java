package safe.model;

import java.util.Date;

public class StateProfile extends Profile {
  protected Integer stateFIPS;
  protected String stateCode;
  protected String stateName;
  protected Integer numCounties;
  protected Double safetyRating;

  public StateProfile(Integer profileId, Date date, Integer covidCases, Integer covidDeaths,
      Integer stateFIPS, String stateCode, String stateName, Integer numCounties, Double safetyRating) {
    super(profileId, date, covidCases, covidDeaths);
    this.stateFIPS = stateFIPS;
    this.stateCode = stateCode;
    this.stateName = stateName;
    this.numCounties = numCounties;
    this.safetyRating = safetyRating;
  }

  public Integer getStateFIPS() {
    return stateFIPS;
  }

  public String getStateCode() {
    return stateCode;
  }

  public String getStateName() {
    return stateName;
  }

  public Integer getNumCounties() {
    return numCounties;
  }

  public Double getSafetyRating() {
    return safetyRating;
  }
}
