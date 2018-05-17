package xyz.mfbrain.onlineshopping.bean;


import java.math.BigDecimal;

public class IndentItemBean {

  private String itId;
  private String diId;
  private long itAmmount;
  private BigDecimal itTotalprice;
  private String inId;


  public String getItId() {
    return itId;
  }

  public void setItId(String itId) {
    this.itId = itId;
  }


  public String getDiId() {
    return diId;
  }

  public void setDiId(String diId) {
    this.diId = diId;
  }


  public long getItAmmount() {
    return itAmmount;
  }

  public void setItAmmount(long itAmmount) {
    this.itAmmount = itAmmount;
  }


  public BigDecimal getItTotalprice() {
    return itTotalprice;
  }

  public void setItTotalprice(BigDecimal itTotalprice) {
    this.itTotalprice = itTotalprice;
  }


  public String getInId() {
    return inId;
  }

  public void setInId(String inId) {
    this.inId = inId;
  }

}
