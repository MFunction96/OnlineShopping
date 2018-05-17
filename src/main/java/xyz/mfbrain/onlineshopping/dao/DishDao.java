package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @program: OnlineShopping
 * @description: 菜品数据操作模块
 * @author: ChrisYoung
 * @create: 2018-05-17 14:33
 **/

public class DishDao extends BaseDao implements IdishDao {

    @Override
    public ArrayList<DishBean> findAllDishinOrder(int order, String stid) {
        ArrayList<DishBean> dishBeans=null;
        String sql="select di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where Commodit.st_id="+stid;
        if(order==1){
            sql=sql+"order by di_price asc";
        }else if(order==2){
            sql=sql+"order by di_price desc";
        }
        try {
            dishBeans=this.findAllObject(sql,DishBean.class);
        } catch (InvocationTargetException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return dishBeans;
    }

    @Override
    public DishBean findDishByID(String id, String stid) {
        DishBean dishBean=null;
        String sql="select di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where Commodit.di_id=?  and Commodit.st_id=?";
        Object params[]={id,stid};
        try {
            dishBean=(DishBean) this.findObjectWithConditions(sql,params,DishBean.class);
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return dishBean;
    }

    @Override
    public DishBean findDishByName(String name, String stid) {
        DishBean dishBean=null;
        String sql="select di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where di_name=?  and Commodit.st_id=?";
        Object params[]={name,stid};
        try {
            dishBean=(DishBean) this.findObjectWithConditions(sql,params,DishBean.class);
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return dishBean;
    }

    @Override
    public boolean addDish(DishBean dish, String stid) {
        return false;
    }

    @Override
    public boolean modifyDish(DishBean dish, String stid) {
        return false;
    }

    @Override
    public boolean deleteDish(String diid, String stid) {
        return false;
    }

    @Override
    public int getDishNum() {
        return 0;
    }
}
