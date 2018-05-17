package xyz.mfbrain.onlineshopping.bean;


import java.sql.Date;

public class AccountBean {

  private String acId;
  private String acName;
  private String acPassword;
  private String acSex;
  private Date acBirthday;
  private String acPhone;
  private String acAddress;
  private long acRole;


  public String getAcId() {
    return acId;
  }

  public void setAcId(String acId) {
    this.acId = acId;
  }


  public String getAcName() {
    return acName;
  }

  public void setAcName(String acName) {
    this.acName = acName;
  }


  public String getAcPassword() {
    return acPassword;
  }

  public void setAcPassword(String acPassword) {
    this.acPassword = acPassword;
  }


  public String getAcSex() {
    return acSex;
  }

  public void setAcSex(String acSex) {
    this.acSex = acSex;
  }


  public Date getAcBirthday() {
    return acBirthday;
  }

  public void setAcBirthday(Date acBirthday) {
    this.acBirthday = acBirthday;
  }


  public String getAcPhone() {
    return acPhone;
  }

  public void setAcPhone(String acPhone) {
    this.acPhone = acPhone;
  }


  public String getAcAddress() {
    return acAddress;
  }

  public void setAcAddress(String acAddress) {
    this.acAddress = acAddress;
  }


  public long getAcRole() {
    return acRole;
  }

  public void setAcRole(long acRole) {
    this.acRole = acRole;
  }

}
