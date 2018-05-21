package xyz.mfbrain.onlineshopping.bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @program: myshop
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-16 21:38
 **/

public class OrderitemBean {
    private String inId=" ";
    private String itId=" ";
    private String diId=" ";
    private String diImage=" ";
    private String diName=" ";
    private int itAmmount=0;
    private BigDecimal itTotalprice=BigDecimal.valueOf(0);

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

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

    public String getDiImage() {
        return diImage;
    }

    public void setDiImage(String diImage) {
        this.diImage = diImage;
    }

    public String getDiName() {
        return diName;
    }

    public void setDiName(String diName) {
        this.diName = diName;
    }

    public int getItAmmount() {
        return itAmmount;
    }

    public void setItAmmount(int itAmmount) {
        this.itAmmount = itAmmount;
    }

    public BigDecimal getItTotalprice() {
        return itTotalprice;
    }

    public void setItTotalprice(BigDecimal itTotalprice) {
        this.itTotalprice = itTotalprice;
    }


}
