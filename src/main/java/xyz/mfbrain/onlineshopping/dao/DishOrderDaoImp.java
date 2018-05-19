package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishorderBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-19 10:26
 **/

public class DishOrderDaoImp extends BaseDao implements IdishOrderDao {
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
