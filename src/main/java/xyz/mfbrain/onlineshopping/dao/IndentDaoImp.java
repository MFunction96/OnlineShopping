package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentBean;
import xyz.mfbrain.onlineshopping.utils.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 订单数据库操作类
 * @author: ChrisYoung
 * @create: 2018-05-17 22:37
 **/

public class IndentDaoImp extends BaseDao implements IindentDao {

    /**
     * 查询商户所有订单
     * @param stid 商户id
     * @return 订单链表
     */
    @Override
    public ArrayList<IndentBean> findAllIndents(String stid) {
        ArrayList<IndentBean> indents=null;
        String sql="select in_id InId,customerid Customerid,in_ordertime InOrdertime,in_totalprice InTotalprice,in_desc InDesc,in_remark InRemark,in_status InStatus from Indent where st_id="+"'"+stid+"'";
        try {
            indents=this.findAllObject(sql,IndentBean.class);
        } catch (InvocationTargetException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return indents;
    }

    /**
     * 根据日期范围查找订单
     * @param startDate 起始时间
     * @param endDate 截止时间
     * @param stid 用户id
     * @return 订单链表
     */
    @Override
    public ArrayList<IndentBean> findAllIndentsByDate(String startDate,String endDate,String stid) {
        ArrayList<IndentBean> indents=null;
        String sql="select in_id InId,customerid Customerid,in_ordertime InOrdertime,in_totalprice InTotalprice,in_desc InDesc,in_remark InRemark,in_status InStatus from Indent where st_id="+"'"+stid+"'"+" and In_ordertime between "+"'"+startDate+"'"+" and "+"'"+endDate+"'";
        try {
            indents=this.findAllObject(sql,IndentBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return indents;
    }

    @Override
    public IndentBean findIndentByID(String id) {
        IndentBean indent=null;
        String sql="select in_id InId,customerid Customerid,in_ordertime InOrdertime,in_totalprice InTotalprice,in_desc InDesc,in_remark InRemark,in_status InStatus from Indent where in_id=?";
        Object params[]={id};
        try {
            indent=(IndentBean)this.findObjectWithConditions(sql,params,IndentBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return indent;
    }

    /**
     * 添加订单
     * @param indent 新订单
     * @return 添加结果
     */
    @Override
    public boolean addIndent(IndentBean indent) {
        int result=0;
        String sql="insert into Indent values(?,?,?,?,?,?,?,?)";
        Object params []={indent.getInId(),indent.getStId(),indent.getCustomerid(),indent.getInOrdertime(),indent.getInTotalprice(),indent.getInDesc(),indent.getInRemark(),indent.getInStatus()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    /**
     * 修改订单状态
     * @param id 订单编号
     * @param status 订单状态
     * @return 修改结果
     */
    @Override
    public boolean modifyIndentStatus(String id, String status) {
        int result=0;
        String sql="update Indent set in_status=? where in_id=?";
        Object params[]={status,id};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    /**
     * 修改订单评论
     * @param id 订单编号
     * @param remark 评论内容
     * @return 修改结果
     */
    @Override
    public boolean modifyIndentRemark(String id, String remark) {
        int result=0;
        String sql="update Indent set in_remark=? where in_id=?";
        Object params[]={remark,id};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;


    }


    /**
     * 获取订单数量
     * @param stid 商户id
     * @return 订单数量
     */
    @Override
    public int getIndentNumByStoreId(String stid) {
        int count=0;
        String sql="select count(*) from Indent where st_id="+"'"+stid+"'";
        try {
            count=this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 获取指定范围内的订单数量
     * @param startDate 起始时间
     * @param endDate 截止时间
     * @param stid 商户id
     * @return 订单数量
     *
     */
    @Override
    public int getIndentNumByDate(String startDate, String endDate, String stid) {
        int count=0;
        String sql="select count(*) from Indent where st_id="+"'"+stid+"'"+" and In_ordertime between "+"'"+startDate+"'"+" and "+"'"+endDate+"'";
        try {
            count=this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 删除订单
     * @param inid 订单id
     * @return 删除结果
     */
    @Override
    public boolean deleteIndent(String inid) {
        int result=0;
        String sql="delete from Indent where in_id="+"'"+inid+"'";
        try {
            result=this.deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }
}
