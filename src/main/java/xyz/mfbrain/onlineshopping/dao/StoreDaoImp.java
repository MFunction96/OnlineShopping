package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.StoreBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:商铺数据库操作
 * @author: ChrisYoung
 * @create: 2018-05-17 22:38
 **/

public class StoreDaoImp extends BaseDao implements IStoreDao {

    /**
     * 显示所有商铺
     * @return 商铺链表
     */
    @Override
    public ArrayList<StoreBean> findAllStore() {
        ArrayList<StoreBean> stores=null;
        String sql="select st_id StId,ac_id AcId,st_name StName,st_phone StPhone,st_desc StDesc from Store";
        try {
            stores=this.findAllObject(sql,StoreBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return stores;
    }

    /**
     * 根据名称查找商铺
     * @param name 商铺名称
     * @return 相应商铺
     */
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

    /**
     * 添加商铺
     * @param store 新的商铺
     * @return 添加结果
     */
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

    /**
     * 修改商铺信息
     * @param store 包含修改过的商铺信息的商铺对象
     * @return 修改结果
     */
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


    /**
     * 删除商户
     * @param id 商户编号
     * @return
     */
    @Override
    public boolean deleteStoreByID(String id) {
        int result=0;
        String sql="delete from Store where st_id="+"'"+id+"'";
        try {
            result=this.deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    /**
     * 获得商铺数量
     * @return 返回商铺数量
     */
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
