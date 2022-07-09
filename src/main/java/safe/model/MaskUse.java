package safe.model;

public class MaskUse {
  protected Integer MaskUseId;
  protected Integer CountyFIPS;
  protected Double NEVER;
  protected Double RARELY;
  protected Double SOMETIMES;
  protected Double FREQUENTLY;
  protected Double ALWAYS;

  public MaskUse(Integer maskUseId, Integer countyFIPS, Double NEVER, Double RARELY, Double SOMETIMES, Double FREQUENTLY, Double ALWAYS) {
    MaskUseId = maskUseId;
    CountyFIPS = countyFIPS;
    this.NEVER = NEVER;
    this.RARELY = RARELY;
    this.SOMETIMES = SOMETIMES;
    this.FREQUENTLY = FREQUENTLY;
    this.ALWAYS = ALWAYS;
  }

  public Integer getMaskUseId() {
    return MaskUseId;
  }

  public Integer getCountyFIPS() {
    return CountyFIPS;
  }

  public Double getNEVER() {
    return NEVER;
  }

  public Double getRARELY() {
    return RARELY;
  }

  public Double getSOMETIMES() {
    return SOMETIMES;
  }

  public Double getFREQUENTLY() {
    return FREQUENTLY;
  }

  public Double getALWAYS() {
    return ALWAYS;
  }
}