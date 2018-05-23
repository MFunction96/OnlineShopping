package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishorderBean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-19 10:25
 **/

public interface IdishOrderDao {
    public ArrayList<DishorderBean> findDishOrder(String stid);

    public ArrayList<DishorderBean> findDishOrderByDateAndStid(String startDate,String endDate,String stid);

    public ArrayList<DishorderBean> findDishOrderByDateAndAcid(String startDate,String endDate,String acid);

    public DishorderBean findDishOrderByOrderId(String inid);

    public ArrayList<DishorderBean> findDishOrderByAcountId(String acid);

    public int getDishOrderNumByStId(String stid);

    public int getDishOrderNumByDateAndStid(String startDate,String endDate,String stid);

    public int getDishOrderNumByDateAndAcid(String startDate,String endDate,String acid);

    public int getDishOrderNumByAcId(String acid);
}
