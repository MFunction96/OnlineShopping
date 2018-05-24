package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.*;
import xyz.mfbrain.onlineshopping.dao.*;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @program: OnlineShopping
 * @description: 订单管理模块
 * @author: ChrisYoung
 * @create: 2018-05-19 14:27
 **/

public class OrderService  {
    private IdishOrderDao dishOrderDao;
    private IorderItemDao orderItemDao;
    private IindentDao indentDao;
    private IindentItemDao indentItemDao;

    /**
     * 显示用户所有订单
     * @param acid 用户id
     * @return 包含订单项的订单
     */
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

    /**
     * 显示商家所有订单（包含订单项）
     * @param stid 商家id
     * @return 详细订单
     */
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

    /**
     * 显示指定日期范围的用户详细订单
     * @param start 起始时间
     * @param end 截至时间
     * @param acid 用户id
     * @return
     */
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

    /**
     *显示指定日期范围的商铺详细订单
     * @param start 起始时间
     * @param end 截至时间
     * @param stid 商铺id
     * @return 订单链表
     */
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

    /**
     * 根据订单编号查找订单
     * @param inid 订单编号
     * @return 相应订单
     */
    public OrderBean showOrderByID(String inid){
        ArrayList<DishorderBean> dishorders=new ArrayList<>();
        try {
            dishOrderDao=(DishOrderDaoImp)DAOFactory.getDaoFactory().newInstance("DishOrderDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        dishorders.add(dishOrderDao.findDishOrderByOrderId(inid));
        OrderBean order=combineOrderAndItem(dishorders).get(0);
        return order;
    }

    /**
     * 将订单和订单项进行组合
     * @param dishorders 订单项链表
     * @return 组合好的订单
     */
    private ArrayList<OrderBean> combineOrderAndItem(ArrayList<DishorderBean> dishorders){
        ArrayList<OrderBean> orders=new ArrayList<>();

        try {
            orderItemDao=(OrderItemDaoImp)DAOFactory.getDaoFactory().newInstance("OrderItemDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        for (DishorderBean dishorder :
                dishorders) {
            OrderBean order=new OrderBean();
            ArrayList<OrderitemBean> orderitems = orderItemDao.findAllOrderItems(dishorder.getInId());
            order.setDishorderBean(dishorder);
            order.setOrderItems(orderitems);
            orders.add(order);

        }
        return orders;
    }

    /**
     * 添加新订单
     * @param shopcart 购物车信息
     * @return 添加结果
     */
    public boolean addOrder(OrderBean shopcart){
        IndentBean indent=new IndentBean();
        boolean result1;
        boolean result2=false;
        UUID uuid;
        try {
            indentItemDao=(IndentItemDaoImp)DAOFactory.getDaoFactory().newInstance("IndentItemDao");
            indentDao=(IndentDaoImp)DAOFactory.getDaoFactory().newInstance("IndentDao");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        uuid=UUID.randomUUID();
        indent.setInId(String.valueOf(uuid));
        indent.setCustomerid(shopcart.getDishorderBean().getCustomerid());
        indent.setStId(shopcart.getDishorderBean().getStid());
        indent.setInOrdertime(shopcart.getDishorderBean().getInOrdertime());
        indent.setInDesc(shopcart.getDishorderBean().getInDesc());
        indent.setInRemark(shopcart.getDishorderBean().getInRemark());
        indent.setInTotalprice(shopcart.getDishorderBean().getInTotalprice());
        indent.setInStatus(shopcart.getDishorderBean().getInStatus());
        result1=indentDao.addIndent(indent);

        for(int i=0;i<shopcart.getOrderItems().size();i++){
            uuid=UUID.randomUUID();
            IndentItemBean item=new IndentItemBean();
            item.setInId(indent.getInId());
            item.setDiId(shopcart.getOrderItems().get(i).getDiId());
            item.setItAmmount(shopcart.getOrderItems().get(i).getItAmmount());
            item.setItId(String.valueOf(uuid));
            item.setItTotalprice(shopcart.getOrderItems().get(i).getItTotalprice());
            result2=indentItemDao.addIndentItem(item);
        }

        return result1&&result2;
    }
















}
