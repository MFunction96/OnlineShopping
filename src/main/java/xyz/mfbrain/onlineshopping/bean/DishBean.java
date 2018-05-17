package xyz.mfbrain.onlineshopping.bean;


import java.math.BigDecimal;

public class DishBean {

  private String diId;
  private String diName;
  private BigDecimal diPrice;
  private String diDesc;
  private String diImage;
  private long diStatus;


  public String getDiId() {
    return diId;
  }

  public void setDiId(String diId) {
    this.diId = diId;
  }


  public String getDiName() {
    return diName;
  }

  public void setDiName(String diName) {
    this.diName = diName;
  }


  public BigDecimal getDiPrice() {
    return diPrice;
  }

  public void setDiPrice(BigDecimal diPrice) {
    this.diPrice = diPrice;
  }


  public String getDiDesc() {
    return diDesc;
  }

  public void setDiDesc(String diDesc) {
    this.diDesc = diDesc;
  }


  public String getDiImage() {
    return diImage;
  }

  public void setDiImage(String diImage) {
    this.diImage = diImage;
  }


  public long getDiStatus() {
    return diStatus;
  }

  public void setDiStatus(long diStatus) {
    this.diStatus = diStatus;
  }

}
