package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class StoreDaoImpTest {
    IStoreDao storeDao;
    UUID uuid;

    @Before
    public void setUp() throws Exception {
        storeDao=(StoreDaoImp)DAOFactory.getDaoFactory().newInstance("StoreDao");
        uuid=UUID.randomUUID();
    }

    @Test
    public void findAllStore() {
        ArrayList<StoreBean> storeBeans=storeDao.findAllStore();
        for (StoreBean store:storeBeans
             ) {
            System.out.println(store.getStName());

        }
    }

    @Test
    public void findStoreByName() {
        System.out.println(storeDao.findStoreByName("锐捷烤肉饭").getStId());
    }

    @Test
    public void addStore() {
        StoreBean storeBean=new StoreBean();
        storeBean.setStId(uuid.toString());
        storeBean.setAcId("111111");
        storeBean.setStName("锐捷脆皮鸡饭");
        storeBean.setStPhone("2131231");
        storeBean.setStDesc("kljfkladsjklfjsd");
        assertEquals(true,storeDao.addStore(storeBean));
    }

    @Test
    public void modifyStoreInfor() {
    }

    @Test
    public void deleteStoreByID() {
        assertEquals(true,storeDao.deleteStoreByID("779e90f27bd1491f88240f4ae0b6a11d"));
    }

    @Test
    public void getStoreNum() {
        System.out.println(storeDao.getStoreNum());
    }
}