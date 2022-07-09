package safe.model;
import java.util.Date;

public class CountyProfile extends Profile {
  protected String CountyName;
  protected Integer CountyFIPS;
  protected Integer MaskUseId;
  protected Integer StateProfileId;
  protected Integer NationalProfileId;
  protected Integer VaccinationId;
  protected Integer PolicyId;

  public CountyProfile(Integer profileId, Date date, Integer covidCases,
      Integer covidDeaths, String countyName, Integer countyFIPS,
      Integer maskUseId, Integer stateProfileId, Integer nationalProfileId,
      Integer vaccinationId, Integer policyId) {
    super(profileId, date, covidCases, covidDeaths);
    CountyName = countyName;
    CountyFIPS = countyFIPS;
    MaskUseId = maskUseId;
    StateProfileId = stateProfileId;
    NationalProfileId = nationalProfileId;
    VaccinationId = vaccinationId;
    PolicyId = policyId;
  }

  public String getCountyName() {
    return CountyName;
  }

  public void setCountyName(String countyName) {
    CountyName = countyName;
  }

  public Integer getCountyFIPS() {
    return CountyFIPS;
  }

  public void setCountyFIPS(Integer countyFIPS) {
    CountyFIPS = countyFIPS;
  }

  public Integer getMaskUseId() {
    return MaskUseId;
  }

  public void setMaskUseId(Integer maskUseId) {
    MaskUseId = maskUseId;
  }

  public Integer getStateProfileId() {
    return StateProfileId;
  }

  public void setStateProfileId(Integer stateProfileId) {
    StateProfileId = stateProfileId;
  }

  public Integer getNationalProfileId() {
    return NationalProfileId;
  }

  public void setNationalProfileId(Integer nationalProfileId) {
    NationalProfileId = nationalProfileId;
  }

  public Integer getVaccinationId() {
    return VaccinationId;
  }

  public void setVaccinationId(Integer vaccinationId) {
    VaccinationId = vaccinationId;
  }

  public Integer getPolicyId() {
    return PolicyId;
  }

  public void setPolicyId(Integer policyId) {
    PolicyId = policyId;
  }
}
