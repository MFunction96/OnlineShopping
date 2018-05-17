package xyz.mfbrain.onlineshopping.bean;


import java.math.BigDecimal;

public class IndentBean {

  private String inId;
  private String customerid;
  private java.sql.Timestamp inOrdertime;
  private BigDecimal inTotalprice;
  private String inDiesc;
  private String inRemark;
  private String inStatus;


  public String getInId() {
    return inId;
  }

  public void setInId(String inId) {
    this.inId = inId;
  }


  public String getCustomerid() {
    return customerid;
  }

  public void setCustomerid(String customerid) {
    this.customerid = customerid;
  }


  public java.sql.Timestamp getInOrdertime() {
    return inOrdertime;
  }

  public void setInOrdertime(java.sql.Timestamp inOrdertime) {
    this.inOrdertime = inOrdertime;
  }


  public BigDecimal getInTotalprice() {
    return inTotalprice;
  }

  public void setInTotalprice(BigDecimal inTotalprice) {
    this.inTotalprice = inTotalprice;
  }


  public String getInDiesc() {
    return inDiesc;
  }

  public void setInDiesc(String inDiesc) {
    this.inDiesc = inDiesc;
  }


  public String getInRemark() {
    return inRemark;
  }

  public void setInRemark(String inRemark) {
    this.inRemark = inRemark;
  }


  public String getInStatus() {
    return inStatus;
  }

  public void setInStatus(String inStatus) {
    this.inStatus = inStatus;
  }

}
