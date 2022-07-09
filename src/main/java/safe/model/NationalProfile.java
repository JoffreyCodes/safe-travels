package safe.model;

import java.util.Date;

public class NationalProfile extends Profile {
  protected String name;

  public NationalProfile(Integer profileId, Date date, Integer covidCases,
      Integer covidDeaths, String name) {
    super(profileId, date, covidCases, covidDeaths);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
