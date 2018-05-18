package xyz.mfbrain.onlineshopping.dao;


import xyz.mfbrain.onlineshopping.bean.DishBean;

import java.util.ArrayList;

/**
 * @program: myshop
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-17 08:21
 **/

public interface IdishDao {
    public ArrayList<DishBean> findAllDishInOrder(int order,String stid);
    public DishBean findDishByID(String id,String stid);
    public DishBean findDishByName(String name,String stid);
    public boolean addDish(DishBean dish,String stid);
    public boolean modifyDish(DishBean dish,String stid);
    public boolean deleteDish(String diid,String stid);
    public int getDishNum(String stid);
}
