package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.DishorderBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DishOrderDaoImpTest {
    String stid;
    String acid;
    IdishOrderDao dao;

    @Before
    public void setUp() throws Exception {
        stid="db9cdff2-f091-40a5-a85c-a15a1479ed06";
        acid="a1a7c58a-9ec3-45e0-9141-c6196157c37e";
        dao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
    }

    @Test
    public void findDishOrder() {
        ArrayList<DishorderBean> dishes=dao.findDishOrder(stid);
        assertNotNull(dishes);
        for (DishorderBean dish:dishes
             ) {
            System.out.println(dish.getInId()+" "+dish.getCustomerid()+" "+dish.getStid()+" "+dish.getAcName()+" "+dish.getStname()+" "+dish.getInOrdertime()+" "+dish.getInTotalprice()+" "+dish.getAcAddress()+" "+dish.getAcPhone()+" "+dish.getInDesc()+" "+dish.getInRemark()+" "+dish.getInStatus());
        }
    }

    @Test
    public void findDishOrderByDateAndStid() {
        ArrayList<DishorderBean> dishes=dao.findDishOrderByDateAndStid("2018-4-12","2018-5-15",stid);
        assertNotNull(dishes);
        for (DishorderBean dish:dishes
                ) {
            System.out.println(dish.getInId()+" "+dish.getAcName()+" "+dish.getStname()+" "+dish.getInOrdertime()+" "+dish.getInTotalprice()+" "+dish.getAcAddress()+" "+dish.getAcPhone());
        }
    }

    @Test
    public void findDishOrderByDateAndAcid() {
        ArrayList<DishorderBean> dishes=dao.findDishOrderByDateAndAcid("2018-4-12","2018-5-15",acid);

        for (DishorderBean dish:dishes
                ) {
            System.out.println(dish.getInId()+" "+dish.getCustomerid()+" "+dish.getStid()+" "+dish.getAcName()+" "+dish.getStname()+" "+dish.getInOrdertime()+" "+dish.getInTotalprice()+" "+dish.getAcAddress()+" "+dish.getAcPhone()+" "+dish.getInDesc()+" "+dish.getInRemark()+" "+dish.getInStatus());
        }
    }

    @Test
    public void findDishOrderByOrderId() {
        DishorderBean dish=dao.findDishOrderByOrderId("bc51bbd7-64e0-4445-a884-62cd3e02db6c");
        System.out.println(dish.getInId()+" "+dish.getCustomerid()+" "+dish.getStid()+" "+dish.getAcName()+" "+dish.getStname()+" "+dish.getInOrdertime()+" "+dish.getInTotalprice()+" "+dish.getAcAddress()+" "+dish.getAcPhone()+" "+dish.getInDesc()+" "+dish.getInRemark()+" "+dish.getInStatus());

    }

    @Test
    public void findDishOrderByAcountId() {
        ArrayList<DishorderBean> dishes=dao.findDishOrderByAcountId(acid);

        for (DishorderBean dish:dishes
                ) {
            System.out.println(dish.getInId()+" "+dish.getCustomerid()+" "+dish.getStid()+" "+dish.getAcName()+" "+dish.getStname()+" "+dish.getInOrdertime()+" "+dish.getInTotalprice()+" "+dish.getAcAddress()+" "+dish.getAcPhone()+" "+dish.getInDesc()+" "+dish.getInRemark()+" "+dish.getInStatus());
        }
    }

    @Test
    public void getDishOrderNumByStId() {
        System.out.println(dao.getDishOrderNumByStId(stid));
    }

    @Test
    public void getDishOrderNumByDateAndStid() {
        System.out.println(dao.getDishOrderNumByDateAndStid("2018-4-12","2018-5-15",stid));
    }

    @Test
    public void getDishOrderNumByDateAndAcid() {
        System.out.println(dao.getDishOrderNumByDateAndAcid("2018-4-12","2018-5-15",acid));
    }

    @Test
    public void getDishOrderNumByAcId() {
        System.out.println(dao.getDishOrderNumByAcId(acid));
    }
}