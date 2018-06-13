package xyz.mfbrain.onlineshopping.utils;

import xyz.mfbrain.onlineshopping.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Shop
 * @description: 包装类
 * @author: ChrisYoung
 * @create: 2018-06-12 22:24
 **/

public class OrderList {
    private ArrayList<OrderBean> list;

    public OrderList(){
        list=new ArrayList<>();
    }

    public ArrayList<OrderBean> getList() {
        return list;
    }

    public void setList(ArrayList<OrderBean> list) {
        this.list = list;
    }


}
