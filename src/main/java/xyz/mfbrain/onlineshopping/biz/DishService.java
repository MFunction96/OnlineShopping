package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.DishBean;
import xyz.mfbrain.onlineshopping.dao.DishDaoImp;
import xyz.mfbrain.onlineshopping.dao.IdishDao;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @program: OnlineShopping
 * @description: 菜品控制模块
 * @author: ChrisYoung
 * @create: 2018-05-19 15:29
 **/

public class DishService {
    private IdishDao dishDao;

    public DishService(){
        String key="DishDao";
        try {
            dishDao=(DishDaoImp)DAOFactory.getDaoFactory().newInstance(key);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到商铺的所有菜品
     * @param oreder 顺序 1；升序 2；降序 其他；顺序
     * @param stid 商户id
     * @return 菜品链表
     */
    public ArrayList<DishBean> getAllDish(int oreder,String stid){
        return dishDao.findAllDishInOrder(oreder,stid);
    }

    /**
     * 搜索菜品名
     * @param name 菜品名
     * @return 相应菜品信息
     */
    public ArrayList<DishBean> searchDishByName(String name){
        return dishDao.findDishByName(name);
    }

    /**
     * 店内搜索菜品
     * @param name 菜品名称
     * @param stid 店铺id
     * @return 相应菜品
     */
    public DishBean searchDishByName(String name,String stid){
        return dishDao.findDishByName(name,stid);
    }

    /**
     * 添加菜品
     * @param dish 新菜品
     * @param stid 商户id
     * @return 添加结果
     */
    public boolean addDish(DishBean dish,String stid){
        UUID uuid=UUID.randomUUID();
        dish.setDiId(String.valueOf(uuid));
        return dishDao.addDish(dish,stid);
    }

    /**
     * 修改店铺信息
     * @param dishBean 包含修改后菜品信息的对象
     * @param stid 店铺id
     * @return 修改结果
     */
    public boolean modifyDish(DishBean dishBean,String stid){
        return dishDao.modifyDish(dishBean,stid);
    }

    /**
     * 删除菜品
     * @param dishid 菜品id
     * @param stid 商铺id
     * @return 删除结果
     */
    public boolean deleteDish(String dishid,String stid){
        return this.deleteDish(dishid,stid);
    }





}
