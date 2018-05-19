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
        String key="xyz.mfbrain.onlineshopping.dao.DishDaoImp";
        try {
            dishDao=(DishDaoImp)DAOFactory.getDaoFactory().newInstance(key);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DishBean> getAllDish(int oreder,String stid){
        return dishDao.findAllDishInOrder(oreder,stid);
    }

    public ArrayList<DishBean> searchDishByName(String name){
        return dishDao.findDishByName(name);
    }

    public DishBean searchDishByName(String name,String stid){
        return dishDao.findDishByName(name,stid);
    }

    public boolean addDish(DishBean dish,String stid){
        UUID uuid=UUID.randomUUID();
        dish.setDiId(String.valueOf(uuid));
        return dishDao.addDish(dish,stid);
    }


    public boolean modifyDish(DishBean dishBean,String stid){
        return dishDao.modifyDish(dishBean,stid);
    }

    public boolean deleteDish(String dishid,String stid){
        return this.deleteDish(dishid,stid);
    }





}
