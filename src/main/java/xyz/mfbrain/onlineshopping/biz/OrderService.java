package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.*;
import xyz.mfbrain.onlineshopping.dao.*;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 订单管理模块
 * @author: ChrisYoung
 * @create: 2018-05-19 14:27
 **/

public class OrderService  {
    private IdishDao dishDao;
    private IdishOrderDao dishOrderDao;
    private IorderItemDao orderItemDao;
    private IindentDao indentDao;
    private IindentItemDao indentItemDao;
    private OrderBean orderBean;

    public ArrayList<OrderBean> showOrdersForeUser(String acid){
        ArrayList<DishorderBean> dishorders=null;
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders=dishOrderDao.findDishOrderByAcountId(acid);

        return combineOrderAndItem(dishorders);
    }

    public ArrayList<OrderBean> showOrderForStoreInDetail(String stid){
        ArrayList<DishorderBean> dishorders=null;
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders=dishOrderDao.findDishOrder(stid);

        return combineOrderAndItem(dishorders);
    }

    public  ArrayList<OrderBean> showOrdersByDateForUser(String start,String end,String acid){
        ArrayList<DishorderBean> dishorders=null;
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders=dishOrderDao.findDishOrderByDateAndAcid(start,end,acid);
        return combineOrderAndItem(dishorders);
    }

    public  ArrayList<OrderBean> showOrdersByDateForStore(String start,String end,String stid){
        ArrayList<DishorderBean> dishorders=null;
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders=dishOrderDao.findDishOrderByDateAndStid(start,end,stid);
        return combineOrderAndItem(dishorders);
    }

    public OrderBean showOrderByID(String inid){
        ArrayList<DishorderBean> dishorders=null;
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders.add(dishOrderDao.findDishOrderByOrderId(inid));
        OrderBean order=combineOrderAndItem(dishorders).get(0);
        return order;
    }

    private ArrayList<OrderBean> combineOrderAndItem(ArrayList<DishorderBean> dishorders){
        ArrayList<OrderBean> orders=new ArrayList<>();
        OrderBean order=new OrderBean();
        ArrayList<OrderitemBean> orderitems=null;
        try {
            orderItemDao=(OrderItemDaoImp)DAOFactory.getDaoFactory().newInstance("OrderItemDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        for (DishorderBean dishorder :
                dishorders) {
            orderitems = orderItemDao.findAllOrderItems(dishorder.getInId());
            order.setDishorderBean(dishorder);
            order.setOrderItems(orderitems);
            orders.add(order);
        }
        return orders;
    }

    public boolean addOrder(IndentBean indent, IndentItemBean item){
        boolean result1=false;
        boolean result2=false;
        try {
            indentItemDao=(IndentItemDaoImp)DAOFactory.getDaoFactory().newInstance("IndentItemDao");
            indentDao=(IndentDaoImp)DAOFactory.getDaoFactory().newInstance("IndentDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        result1=indentDao.addIndent(indent);
        result2=indentItemDao.addIndentItem(item);

        return result1&&result2;
    }
















}
