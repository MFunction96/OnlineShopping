package xyz.mfbrain.onlineshopping.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: OnlineShopping
 * @description: 日志类
 * @author: ChrisYoung
 * @create: 2018-05-24 14:39
 **/

public class logBean {
    private Date time;
    private Exception e;

    public logBean(Exception e){
        time=new Date();
        this.e=e;
    }
}
