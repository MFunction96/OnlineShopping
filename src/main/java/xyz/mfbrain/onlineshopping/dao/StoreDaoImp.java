package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.StoreBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-17 22:38
 **/

public class StoreDaoImp extends BaseDao implements IStoreDao {
    @Override
    public ArrayList<StoreBean> findAllStore() {
        ArrayList<StoreBean> stores=null;
        String sql="select st_id StId,st_name StName,st_phone StPhone,st_desc StDesc from Store";
        try {
            stores=this.findAllObject(sql,StoreBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return stores;
    }

    @Override
    public StoreBean findStoreByName(String name) {
        StoreBean store=null;
        String sql="select st_id StId,st_name StName,st_phone StPhone,st_desc StDesc from Store where st_name=?";
        Object params []={name};
        try {
            store=(StoreBean) this.findObjectWithConditions(sql,params,StoreBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return store;
    }

    @Override
    public boolean addStore(StoreBean store) {
        int result=0;
        String sql="insert into Store values(?,?,?,?,?)";
        Object params [] ={store.getStId(),store.getAcId(),store.getStName(),store.getStPhone(),store.getStDesc()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public boolean modifyStoreInfor(StoreBean store) {
        int result=0;
        String sql="update Store set st_name=?,st_phone=?,st_desc=? where st_id=?";
        Object params[]={store.getStName(),store.getStPhone(),store.getStDesc(),store.getStId()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public boolean deleteStoreByID(String id) {
        int result=0;
        String sql="delete from Store where st_id="+id;
        try {
            result=this.deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public int getStoreNum() {
        int count=0;
        String sql="select count(*) from Store";
        try {
            count=this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
