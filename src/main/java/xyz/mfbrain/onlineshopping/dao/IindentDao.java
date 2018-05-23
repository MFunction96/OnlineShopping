package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentBean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 数据库订单操作
 * @author: ChrisYoung
 * @create: 2018-05-17 22:34
 **/

public interface IindentDao {
    public ArrayList<IndentBean> findAllIndents(String stid);

    public ArrayList<IndentBean> findAllIndentsByDate(String startDate,String endDate,String id);

    public IndentBean findIndentByID(String id);

    public boolean addIndent(IndentBean indent);

    public boolean modifyIndentStatus(String id,String status);

    public boolean modifyIndentRemark(String id,String remark);

    public int getIndentNumByStoreId(String stid);

    public int getIndentNumByDate(String startDate,String endDate,String stid);

    public boolean deleteIndent(String inid);
}
