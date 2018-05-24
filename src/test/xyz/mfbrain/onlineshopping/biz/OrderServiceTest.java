package xyz.mfbrain.onlineshopping.biz;

import org.apache.tomcat.jni.Time;
import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService ser;
    String diid1;
    String diid2;
    String acid;
    String stid;

    @Before
    public void setUp() throws Exception {
        ser=new OrderService();
        diid1="0fda5160-ec74-4e68-9190-95639c28b765";
        diid2="2681f39f-9b02-4c89-baf2-29c968ca6b32";
        stid="db9cdff2-f091-40a5-a85c-a15a1479ed06";
        acid="a1a7c58a-9ec3-45e0-9141-c6196157c37e";
    }

    @Test
    public void showOrdersForeUser() {
        ArrayList<OrderBean> orders=ser.showOrdersForeUser(acid);
        for(int i=0;i<orders.size();i++){
            System.out.println(orders.get(i).getDishorderBean().getAcName());
            ArrayList<OrderitemBean> items=orders.get(i).getOrderItems();
            for(int j=0;j<items.size();j++){
                System.out.println(items.get(i).getDiName());
            }
        }
    }

    @Test
    public void showOrderForStoreInDetail() {
        ArrayList<OrderBean> orders=ser.showOrderForStoreInDetail(stid);
        for(int i=0;i<orders.size();i++){
            System.out.println(orders.get(i).getDishorderBean().getStname());
            ArrayList<OrderitemBean> items=orders.get(i).getOrderItems();
            for(int j=0;j<items.size();j++){
                System.out.println(items.get(i).getDiName());
            }
        }

    }

    @Test
    public void showOrdersByDateForUser() {
        ArrayList<OrderBean> orders=ser.showOrdersByDateForUser("2018-4-4","2018-5-25",acid);
        for(int i=0;i<orders.size();i++){
            System.out.println(orders.get(i).getDishorderBean().getStname());
            ArrayList<OrderitemBean> items=orders.get(i).getOrderItems();
            for(int j=0;j<items.size();j++){
                System.out.println(items.get(i).getDiName());
            }
        }
    }

    @Test
    public void showOrdersByDateForStore() {
    }

    @Test
    public void showOrderByID() {
        OrderBean order=ser.showOrderByID("bc51bbd7-64e0-4445-a884-62cd3e02db6c");
        System.out.println(order.getDishorderBean().getInId());
        ArrayList<OrderitemBean> items=new ArrayList<>();
        items=order.getOrderItems();
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).getItId());
        }

    }

    @Test
    public void addOrder() {
        DishorderBean dishorder=new DishorderBean();
        ArrayList<OrderitemBean> items=new ArrayList<>();
        dishorder.setStid(stid);
        dishorder.setInTotalprice(BigDecimal.valueOf(400));
        dishorder.setCustomerid(acid);
        dishorder.setInOrdertime(Timestamp.valueOf("2018-4-4 4:34:23"));
        OrderitemBean item=new OrderitemBean();
        item.setInId(dishorder.getInId());
        item.setDiId(diid1);
        item.setItAmmount(10);
        item.setItTotalprice(BigDecimal.valueOf(111));
        items.add(item);
        OrderBean order=new OrderBean();
        order.setDishorderBean(dishorder);
        order.setOrderItems(items);
        assertEquals(true,ser.addOrder(order));


    }
}