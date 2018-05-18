package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.StoreBean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 数据库商铺操作
 * @author: ChrisYoung
 * @create: 2018-05-17 22:35
 **/

public interface IStoreDao {
    public ArrayList<StoreBean> findAllStore();

    public StoreBean findStoreByName(String name);

    public boolean addStore(StoreBean store);

    public boolean modifyStoreInfor(StoreBean store);

    public boolean deleteStoreByID(String id);

    public int getStoreNum();
}
