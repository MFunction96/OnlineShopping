package xyz.mfbrain.onlineshopping.dao;

import xyz.mfbrain.onlineshopping.bean.DishBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @program: OnlineShopping
 * @description: 数据库菜品表操作类
 * @author: ChrisYoung
 * @create: 2018-05-17 14:33
 **/

public class DishDaoImp extends BaseDao implements IdishDao {

    /**
     * 查询所有菜品，可以有序
     * @param order 是否排序 1：升序 2：降序 其他顺序
     * @param stid 商品id
     * @return 返回菜品数组
     */
    @Override
    public ArrayList<DishBean> findAllDishInOrder(int order, String stid) {
        ArrayList<DishBean> dishBeans=null;
        String sql="select Dish.di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where Commodit.st_id="+"'"+stid+"'";
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
    public ArrayList<DishBean> findDishesForPageList(int startrow, int rownums,String stid) {
        ArrayList<DishBean> dishes=null;
        String sql="select Dish.di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where Commodit.st_id="+"'"+stid+"'"+" limit "+String.valueOf(startrow)+","+String.valueOf(rownums);
        try {
            dishes=this.findAllObject(sql,DishBean.class);
        } catch (InvocationTargetException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }


        return dishes;
    }

    /**
     * 根据菜品ID找到菜品
     * @param id 菜品ID
     * @param stid 商铺ID
     * @return 返回菜品对象
     */
    @Override
    public DishBean findDishByID(String id, String stid) {
        DishBean dishBean=null;
        String sql="select Dish.di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where Commodit.di_id=?  and Commodit.st_id=?";
        Object params[]={id,stid};
        try {
            dishBean=(DishBean) this.findObjectWithConditions(sql,params,DishBean.class);
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return dishBean;
    }

    /**
     * 根据菜名找到菜品，可用于店内搜索
     * @param name 名称
     * @param stid 店铺id
     * @return 返回菜品对象
     */
    @Override
    public DishBean findDishByName(String name, String stid) {
        DishBean dishBean=null;
        String sql="select Dish.di_id DiId,di_name DiName,di_price DiPrice,di_desc DiDesc,di_image DiImage,di_status DiStatus " +
                "from Dish inner join Commodit on Dish.di_id=Commodit.di_id where di_name=?  and Commodit.st_id=?";
        Object params[]={name,stid};
        try {
            dishBean=(DishBean) this.findObjectWithConditions(sql,params,DishBean.class);
        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return dishBean;
    }

    /**
     * 搜索菜名查找菜品
     * @param name 菜名
     * @return 菜品对象
     */
    @Override
    public ArrayList<DishBean> findDishByName(String name) {
        ArrayList<DishBean> dishes=null;
        String sql="select Dish.di_id DiId,di_name DiName,di_price DiPrice ,di_image DiImage,di_status DiStatus from Dish where di_name="+name;
        try {
            dishes=this.findAllObject(sql,DishBean.class);
        } catch (InvocationTargetException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return dishes;
    }

    /**
     * 添加菜品
     * @param dish 新的菜品对象
     * @param stid 商铺ID
     * @return 添加结果
     */
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

    /**
     * 修改菜品
     * @param dish 包含修改信息后的菜品对象
     * @param stid 商铺信息
     * @return 添加结果
     */
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

    /**
     * 删除菜品
     * @param diid 菜品id
     * @param stid 商铺id
     * @return 删除结果
     */
    @Override
    public boolean deleteDish(String diid, String stid) {
        int result=0;
        String sql="delete from Dish where di_id="+"'"+diid+"'";
        try {
            result=this.deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    /**
     * 获取菜品种类数量
     * @param stid 商铺id
     * @return 菜品种类数量
     */
    @Override
    public int getDishNum(String stid) {
        int count=0;
        String sql="select count(*) from Commodit where st_id="+"'"+stid+"'";
        try {
            count=this.getTotalObjectsNum(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
