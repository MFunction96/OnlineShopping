package xyz.mfbrain.onlineshopping.bean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 真正订单模块
 * @author: ChrisYoung
 * @create: 2018-05-19 16:30
 **/

public class OrderBean {
    private DishorderBean dishorderBean;
    private ArrayList<OrderitemBean> orderItems;

    public ArrayList<OrderitemBean> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderitemBean> orderItems) {
        this.orderItems = orderItems;
    }

    public DishorderBean getDishorderBean() {
        return dishorderBean;
    }

    public void setDishorderBean(DishorderBean dishorderBean) {
        this.dishorderBean = dishorderBean;
    }
}
