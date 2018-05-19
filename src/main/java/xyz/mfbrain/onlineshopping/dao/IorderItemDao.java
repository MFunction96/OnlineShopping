package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.OrderitemBean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-19 10:26
 **/

public interface IorderItemDao {
    public ArrayList<OrderitemBean> findAllOrderItems(String inid);
}
