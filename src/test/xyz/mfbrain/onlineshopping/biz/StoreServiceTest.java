package xyz.mfbrain.onlineshopping.biz;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.dao.IStoreDao;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class StoreServiceTest {
    StoreService service;

    @Before
    public void setUp() throws Exception {
        service=new StoreService();
    }

    @Test
    public void isExist() {
        assertEquals(true,service.isExist("老朴炸鸡"));
    }

    @Test
    public void registerStore() {
        StoreBean store=new StoreBean();
        store.setStId(UUID.randomUUID().toString());
        store.setAcId("46422b05-bf95-4372-978d-47bd5bf2d3d9");
        store.setStName("老朴炸鸡");
        store.setStPhone("3423446444242");
        store.setStDesc("sadfjsadkfjkljk");
        assertEquals(true,service.registerStore(store));
    }

    @Test
    public void getAllStores() {
        ArrayList<StoreBean> stores=service.getAllStores();
        for (StoreBean s:stores
             ) {
            System.out.println(s.getStName());
        }
    }

    @Test
    public void searchStoreByName() {
        System.out.println(service.searchStoreByName("老朴炸鸡").getStName());
    }

    @Test
    public void modifyStoreInfor() {
    }

    @Test
    public void deleteStore() {
    }
}