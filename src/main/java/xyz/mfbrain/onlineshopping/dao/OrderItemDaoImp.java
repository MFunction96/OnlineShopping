package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.OrderitemBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-19 10:26
 **/

public class OrderItemDaoImp extends BaseDao implements IorderItemDao {
    @Override
    public ArrayList<OrderitemBean> findAllOrderItems(String inid) {
        ArrayList<OrderitemBean> items=null;
        String sql="select In_id InId,It_id ItId,Di_id DiId,Di_image DiImage,It_ammount ItAmmount,It_totalprice ItTotalPrice from OrderItem where In_id="+inid;
        try {
            items=this.findAllObject(sql,OrderitemBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return items;
    }
}
