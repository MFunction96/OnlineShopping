package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.ObjDoubleConsumer;

/**
 * @program: OnlineShopping
 * @description: 菜品数据操作模块
 * @author: ChrisYoung
 * @create: 2018-05-17 14:33
 **/

public class DishDaoImp extends BaseDao implements IdishDao {

    @Override
    public ArrayList<DishBean> findAllDishInOrder(int order, String stid) {
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
        int result1=0;
        int result2=0;
        String sql1="insert into Dish values(?,?,?,?,?,?)";
        Object params1[]={dish.getDiId(),dish.getDiName(),dish.getDiPrice(),dish.getDiDesc(),dish.getDiImage(),dish.getDiStatus()};
        String sql2="insert into Commodit values(?,?)";
        Object params2[]={stid,dish.getDiId()};
        try {
            result1=this.modifyObjectInformation(sql1,params1);
            result2=this.modifyObjectInformation(sql2,params2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result1==1&&result2==1;
    }

    @Override
    public boolean modifyDish(DishBean dish, String stid) {
        int result=0;
        String sql="update Dish set di_name=?,di_price=?,di_desc=?,di_image=?,di_status=? where di_id=?";
        Object [] params={dish.getDiName(),dish.getDiPrice(),dish.getDiDesc(),dish.getDiImage(),dish.getDiStatus(),dish.getDiId()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public boolean deleteDish(String diid, String stid) {
        int result=0;
        String sql="delete from Dish where di_id="+diid;
        try {
            result=this.deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public int getDishNum(String stid) {
        int count=0;
        String sql="select count(*) from Commodit where st_id="+stid;
        try {
            count=this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
