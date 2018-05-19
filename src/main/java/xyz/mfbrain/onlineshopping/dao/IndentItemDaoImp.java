package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.IndentItemBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description:
 * @author: ChrisYoung
 * @create: 2018-05-17 22:39
 **/

public class IndentItemDaoImp extends BaseDao implements IindentItemDao {
    @Override
    public ArrayList<IndentItemBean> findIndentItems(String inid) {
        ArrayList<IndentItemBean> items=null;
        String sql="select it_id ItId,di_id DiId,it_ammount ItAmmount,it_totalprice ItTotalprice where in_id=?"+inid;
        try {
            items=this.findAllObject(sql,IndentItemBean.class);
        } catch (InvocationTargetException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public boolean addIndentItem(IndentItemBean item) {
        int result=0;
        String sql="inset into IndentItem values(?,?,?,?,?)";
        Object params[]={item.getItId(),item.getDiId(),item.getItAmmount(),item.getItTotalprice(),item.getInId()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }
}
