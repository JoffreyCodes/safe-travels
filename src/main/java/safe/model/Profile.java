package safe.model;

import java.util.Date;

public class Profile {
  protected Integer profileId;
  protected Date date;
  protected Integer covidCases;
  protected Integer covidDeaths;

  public Profile(Integer profileId, Date date, Integer covidCases,
      Integer covidDeaths) {
    this.profileId = profileId;
    this.date = date;
    this.covidCases = covidCases;
    this.covidDeaths = covidDeaths;
  }

  public Integer getProfileId() {
    return profileId;
  }

  public void setProfileId(Integer profileId) {
    this.profileId = profileId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getCovidCases() {
    return covidCases;
  }

  public void setCovidCases(Integer covidCases) {
    this.covidCases = covidCases;
  }

  public Integer getCovidDeaths() {
    return covidDeaths;
  }

  public void setCovidDeaths(Integer covidDeaths) {
    this.covidDeaths = covidDeaths;
  }
}
