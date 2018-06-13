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
        store.setAcId("f61d8f6d-76e5-4733-b276-00d8d2851285");
        store.setStName("汉堡王");
        store.setStPhone("15190801614");
        store.setStDesc("我家薯条好吃");
        store.setStImage("/upload/hanbaowang.jpeg");
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

    @Test
    public void page(){
        assertNotNull(service.findSroreInPages(1,2));
    }
}