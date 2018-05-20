package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.dao.IStoreDao;
import xyz.mfbrain.onlineshopping.dao.StoreDaoImp;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @program: OnlineShopping
 * @description: 商铺管理模块
 * @author: ChrisYoung
 * @create: 2018-05-19 14:27
 **/

public class StoreService {
    private IStoreDao storeDao;

    public StoreService(){
        String key="StoreDao";
        try {
            storeDao=(StoreDaoImp)DAOFactory.getDaoFactory().newInstance(key);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public boolean isExist(String name){
        return storeDao.findStoreByName(name)==null;
    }

    public boolean registerStore(StoreBean store){
        UUID uuid=UUID.randomUUID();
        store.setStId(String.valueOf(uuid));
        return storeDao.addStore(store);
    }

    public ArrayList<StoreBean> getAllStores(){
        return storeDao.findAllStore();
    }

    public StoreBean searchStoreByName(String name){
        return storeDao.findStoreByName(name);
    }

    public boolean modifyStoreInfor(StoreBean store){
        return storeDao.modifyStoreInfor(store);
    }

    public boolean deleteStore(String id ){
        return storeDao.deleteStoreByID(id);
    }

}
