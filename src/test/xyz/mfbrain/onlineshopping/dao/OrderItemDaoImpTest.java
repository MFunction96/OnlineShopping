package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.OrderitemBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderItemDaoImpTest {

    String inid;
    OrderItemDaoImp dao;

    @Before
    public void setUp() throws Exception {
        inid="bc51bbd7-64e0-4445-a884-62cd3e02db6c";
        dao=(OrderItemDaoImp) DAOFactory.getDaoFactory().newInstance("OrderItemDao");
    }

    @Test
    public void findAllOrderItems() {
        ArrayList<OrderitemBean> items=dao.findAllOrderItems(inid);
        for (OrderitemBean item:items
             ) {System.out.println(item.getInId()+" "+item.getItId()+" "+item.getDiId()+" "+item.getDiName()+" "+item.getDiImage()+" "+item.getItAmmount()+" "+item.getItTotalprice());

        }
    }
}