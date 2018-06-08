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
        acid="0738c940-7c1b-49f6-8730-9cacf1e10e39";
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
    public void finddish(){
        ArrayList<DishorderBean> ordes=dao.findDishOrderInPageForA(acid,0,3);
        for (DishorderBean dish:ordes
             ) {
            System.out.println(dish.getInId());
        }
    }

    @Test
    public void getDishOrderNumByAcId() {
        System.out.println(dao.getDishOrderNumByAcId(acid));
    }
}