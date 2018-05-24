package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentItemBean;
import xyz.mfbrain.onlineshopping.bean.logBean;
import xyz.mfbrain.onlineshopping.utils.JsonUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 订单项数据库操作类
 * @author: ChrisYoung
 * @create: 2018-05-17 22:39
 **/

public class IndentItemDaoImp extends BaseDao implements IindentItemDao {

    /**
     * 根据订单号查找订单项
     * @param inid 订单号
     * @return 订单向链表
     */
    @Override
    public ArrayList<IndentItemBean> findIndentItems(String inid) {
        ArrayList<IndentItemBean> items=null;
        String sql="select it_id ItId,di_id DiId,it_ammount ItAmmount,it_totalprice ItTotalprice from IndentItem where in_id="+"'"+inid+"'";
        try {
            items=this.findAllObject(sql,IndentItemBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            try {
                JsonUtil.SerializeObj(new logBean(e),logBean.class,"./log.json",true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return items;
    }

    /**
     * 添加订单项
     * @param item 新的订单项
     * @return
     */
    @Override
    public boolean addIndentItem(IndentItemBean item) {
        int result=0;
        String sql="insert into IndentItem values(?,?,?,?,?)";
        Object params[]={item.getItId(),item.getDiId(),item.getItAmmount(),item.getItTotalprice(),item.getInId()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                JsonUtil.SerializeObj(new logBean(e),logBean.class,"./log.json",true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return result==1;
    }
}
