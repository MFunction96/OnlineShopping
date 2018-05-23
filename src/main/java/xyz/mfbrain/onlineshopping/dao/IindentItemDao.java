package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentItemBean;

import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 数据库订单项操作
 * @author: ChrisYoung
 * @create: 2018-05-17 22:35
 **/

public interface IindentItemDao {

    public ArrayList<IndentItemBean> findIndentItems(String inid);

    public boolean addIndentItem(IndentItemBean item);
}
