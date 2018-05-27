package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.DishBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class DishDaoImpTest {
    IdishDao dishDao=null;
    UUID uuid;
    String stid;

    @Before
    public void setUp() throws Exception {
        dishDao=(DishDaoImp)DAOFactory.getDaoFactory().newInstance("DishDao");
        stid="db9cdff2-f091-40a5-a85c-a15a1479ed06";
    }

    @Test
    public void findAllDishInOrder() {
        ArrayList<DishBean> dishes=new ArrayList<>();
        dishes=dishDao.findAllDishInOrder(1,stid);
        for (DishBean dish:dishes
             ) {
            System.out.println(dish.getDiName());
            System.out.println(dish.getDiPrice());
        }
    }

    @Test
    public void findDishByID() {
        System.out.println(dishDao.findDishByID("5884b938-9d9c-4da0-80e3-5050a972a6ac",stid).getDiName());
    }

    @Test
    public void findDishByName() {
        System.out.println(dishDao.findDishByName("千岛烤肉饭",stid).getDiPrice());
    }

    @Test
    public void findDishByName1() {
    }

    @Test
    public void addDish() {
        DishBean dish=new DishBean();
        dish.setDiId(UUID.randomUUID().toString());
        //dish.setDiDesc("沙拉烤肉饭");
        dish.setDiDesc("dafafadsfadsff3fe");
        dish.setDiImage("dfafadf");
        //dish.setDiName("沙拉烤肉饭");
        dish.setDiName("千岛烤肉饭");
        dish.setDiPrice(BigDecimal.valueOf(10.00));
        dish.setDiStatus(1);
        assertEquals(true,dishDao.addDish(dish,stid));

    }

    @Test
    public void modifyDish() {
    }

    @Test
    public void deleteDish() {
        assertEquals(true,dishDao.deleteDish("5884b938-9d9c-4da0-80e3-5050a972a6ac",stid));
    }

    @Test
    public void getDishNum() {
        System.out.println(dishDao.getDishNum(stid));
    }

    @Test
    public void getPage(){
        assertNotNull(dishDao.findDishesForPageList(0,2,"db9cdff2-f091-40a5-a85c-a15a1479ed06"));dishDao.findDishesForPageList(0,2,"db9cdff2-f091-40a5-a85c-a15a1479ed06");

    }
}