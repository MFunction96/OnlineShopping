package xyz.mfbrain.onlineshopping.bean;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class IndentBean {

  private String inId=" ";
  private String customerid=" ";
  private String stId=" ";
  private Timestamp inOrdertime=Timestamp.valueOf("1870-1-1 0:0:0");
  private BigDecimal inTotalprice=BigDecimal.valueOf(0);
  private String inDesc=" ";
  private String inRemark=" ";
  private String inStatus=" ";


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


  public String getStId() {
    return stId;
  }

  public void setStId(String stId) {
    this.stId = stId;
  }



  public Timestamp getInOrdertime() {
    return inOrdertime;
  }

  public void setInOrdertime(Timestamp inOrdertime) {
    this.inOrdertime = inOrdertime;
  }


  public BigDecimal getInTotalprice() {
    return inTotalprice;
  }

  public void setInTotalprice(BigDecimal inTotalprice) {
    this.inTotalprice = inTotalprice;
  }


  public String getInDesc() {
    return inDesc;
  }

  public void setInDesc(String inDesc) {
    this.inDesc = inDesc;
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
