package xyz.mfbrain.onlineshopping.biz;

import org.apache.catalina.Store;
import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.dao.IStoreDao;
import xyz.mfbrain.onlineshopping.dao.StoreDaoImp;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;
import xyz.mfbrain.onlineshopping.utils.PageModle;

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

    /**
     * 构造函数
     */
    public StoreService(){
        String key="StoreDao";
        try {
            storeDao=(StoreDaoImp)DAOFactory.getDaoFactory().newInstance(key);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断店铺名是否存在
     * @param name
     * @return 结果
     */
    public boolean isExist(String name){
        return storeDao.findStoreByName(name)!=null;
    }

    /**
     * 注册店铺
     * @param store 新店铺
     * @return 注册结果
     */
    public boolean registerStore(StoreBean store){
        UUID uuid=UUID.randomUUID();
        store.setStId(String.valueOf(uuid));
        return storeDao.addStore(store);
    }

    /**
     * 显示所有商铺
     * @return 商铺链表
     */
    public ArrayList<StoreBean> getAllStores(){
        return storeDao.findAllStore();
    }

    /**
     * 根据商铺名查找商铺
     * @param name 商铺名
     * @return 相应商铺
     */
    public StoreBean searchStoreByName(String name){
        return storeDao.findStoreByName(name);
    }

    /**
     * 修改商户信息
     * @param store 包含修改后商户信息的对象
     * @return 修改结果
     */
    public boolean modifyStoreInfor(StoreBean store){
        return storeDao.modifyStoreInfor(store);
    }

    /**
     * 删除商户
     * @param id 商铺id
     * @return 删除结果
     */
    public boolean deleteStore(String id ){
        return storeDao.deleteStoreByID(id);
    }

    public PageModle<StoreBean> findSroreInPages(int pageNo,int pageSize){
        int realPageNo=(pageNo-1)*pageSize;
        ArrayList<StoreBean> stores=storeDao.findStoresForPageList(realPageNo,pageSize);
        PageModle<StoreBean> pagelist=new PageModle<>(storeDao.getStoreNum(),pageNo,pageSize,stores);
        return pagelist;
    }

}
