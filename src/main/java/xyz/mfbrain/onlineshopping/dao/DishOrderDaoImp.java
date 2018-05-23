package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishorderBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 菜品订单显示类
 * @author: ChrisYoung
 * @create: 2018-05-19 10:26
 **/

public class DishOrderDaoImp extends BaseDao implements IdishOrderDao {

    /**
     *查找订单（非详细），给商家使用
     * @param stid 商铺id
     * @return 订单链表
     */
    @Override
    public ArrayList<DishorderBean> findDishOrder(String stid) {
        ArrayList<DishorderBean> orders=null;
        String sql="select In_id Inid,St_id Stid,St_name StName,Customerid,Ac_name AcName,In_totalprice InTotalprice," +
                "In_desc InDesc,In_remark InRemark,In_status InStatus,Ac_phone AcPhone,Ac_address AcAddress,In_ordertime " +
                "InOrdertime from DishOrder where St_id="+stid;
        try {
            orders=this.findAllObject(sql,DishorderBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * 通过日期范围，查询订单（非详细—=）
     * @param startDate 起始时间
     * @param endDate 截至时间
     * @param stid 店铺id
     * @return 订单链表
     */
    @Override
    public ArrayList<DishorderBean> findDishOrderByDateAndStid(String startDate, String endDate, String stid) {
        ArrayList<DishorderBean> orders=null;
        String sql="select In_id Inid,St_id Stid,St_name StName,Customerid,Ac_name AcName,In_totalprice InTotalprice," +
                "In_desc InDesc,In_remark InRemark,In_status InStatus,Ac_phone AcPhone,Ac_address AcAddress,In_ordertime " +
                "InOrdertime from DishOrder where St_id="+stid+" and In_ordertime between "+startDate+" and "+endDate;
        try {
            orders=this.findAllObject(sql,DishorderBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * 用户通过日期范围查找订单（非详细）
     * @param startDate  起始时间
     * @param endDate 截至时间
     * @param acid 用户ID
     * @return 订单链表
     */
    @Override
    public ArrayList<DishorderBean> findDishOrderByDateAndAcid(String startDate, String endDate, String acid) {
        ArrayList<DishorderBean> orders=null;
        String sql="select In_id Inid,St_id Stid,St_name StName,Customerid,Ac_name AcName,In_totalprice InTotalprice," +
                "In_desc InDesc,In_remark InRemark,In_status InStatus,Ac_phone AcPhone,Ac_address AcAddress,In_ordertime " +
                "InOrdertime from DishOrder where St_id="+acid+" and In_ordertime between "+startDate+" and "+endDate;
        try {
            orders=this.findAllObject(sql,DishorderBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * 根据订单编号查找订单
     * @param inid 订单编号
     * @return 相应订单
     */
    @Override
    public DishorderBean findDishOrderByOrderId(String inid) {
        DishorderBean order=null;
        String sql="select In_id Inid,St_id Stid,St_name StName,Customerid,Ac_name AcName,In_totalprice InTotalprice," +
                "In_desc InDesc,In_remark InRemark,In_status InStatus,Ac_phone AcPhone,Ac_address AcAddress,In_ordertime " +
                "InOrdertime from DishOrder where In_id=?";
        Object params[]={inid};
        try {
            order=(DishorderBean) this.findObjectWithConditions(sql,params,DishorderBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return order;
    }

    /**
     * 查找用户所有订单（非详细）
     * @param acid 用户id
     * @return 用户订单
     */
    @Override
    public ArrayList<DishorderBean> findDishOrderByAcountId(String acid) {
        ArrayList<DishorderBean> orders=null;
        String sql="select In_id Inid,St_id Stid,St_name StName,Customerid,Ac_name AcName,In_totalprice InTotalprice," +
                "In_desc InDesc,In_remark InRemark,In_status InStatus,Ac_phone AcPhone,Ac_address AcAddress,In_ordertime " +
                "InOrdertime from DishOrder where Customerid="+acid;
        try {
            orders=this.findAllObject(sql,DishorderBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return orders;
    }

    /**
     * 获得订单数量（商户）
     * @param stid 店铺id
     * @return 订单数量
     */
    @Override
    public int getDishOrderNumByStId(String stid) {
        int count=0;
        String sql="select cout(*) frome DishOrder where St_id="+stid;
        try {
            this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 返回商户指定日期范围的订单的数量
     * @param startDate 起始时间
     * @param endDate 截至时间
     * @param stid 店铺id
     * @return 订单数量
     */
    @Override
    public int getDishOrderNumByDateAndStid(String startDate, String endDate, String stid) {
        int count=0;
        String sql="select cout(*) from DishOrder where St_id="+stid+" and In_ordertime between "+startDate+" and "+endDate;
        try {
            this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 返回用户指定日期范围的订单数量
     * @param startDate 起止时间
     * @param endDate 截至时间
     * @param acid 用户id
     * @return 订单数量
     */
    @Override
    public int getDishOrderNumByDateAndAcid(String startDate, String endDate, String acid) {
        int count=0;
        String sql="select cout(*) from DishOrder where Customerid="+acid+" and In_ordertime between "+startDate+" and "+endDate;
        try {
            this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 返回用户的订单数量
     * @param acid 用户id
     * @return 订单数量
     */
    @Override
    public int getDishOrderNumByAcId(String acid) {
        int count=0;
        String sql="select cout(*) frome DishOrder where Customerid="+acid;
        try {
            this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
