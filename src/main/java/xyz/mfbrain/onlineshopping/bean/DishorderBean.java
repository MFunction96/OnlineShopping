package xyz.mfbrain.onlineshopping.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: myshop
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-16 21:38
 **/

public class DishorderBean {
    private String inId = " ";
    private String stid = " ";
    private String stname = " ";
    private String customerid = " ";
    private String acName = " ";
    private BigDecimal inTotalprice = BigDecimal.valueOf(0);
    private String inDesc = " ";
    private String inRemark = " ";
    private String inStatus = " ";
    private String acPhone = " ";
    private String acAddress = " ";
    private Timestamp inOrdertime = Timestamp.valueOf("1870-1-1 0:0:0");

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
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

    public Timestamp getInOrdertime() {
        return inOrdertime;
    }

    public void setInOrdertime(Timestamp inOrdertime) {
        this.inOrdertime = inOrdertime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DishorderBean) {
            var dish = (DishorderBean) obj;
            return acAddress.equals(dish.acAddress) && acName.equals(dish.acName) && acPhone.equals(dish.acPhone) && customerid.equals(dish.customerid)
                    && inDesc.equals(dish.inDesc) && inId.equals(dish.inId) && inOrdertime.equals(dish.inOrdertime) && inRemark.equals(dish.inRemark)
                    && inStatus.equals(dish.inStatus) && inTotalprice.equals(dish.inTotalprice) && stid.equals(dish.stid) && stname.equals(dish.stname);
        }
        return false;
    }
}
