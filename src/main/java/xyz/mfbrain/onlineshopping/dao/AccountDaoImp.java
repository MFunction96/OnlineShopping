package xyz.mfbrain.onlineshopping.dao;


import xyz.mfbrain.onlineshopping.bean.AccountBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @program: myshop
 * @description: 用户管理模块基础实现类
 * @author: ChrisYoung
 * @create: 2018-05-16 22:00
 **/

public class AccountDaoImp extends BaseDao implements IAccountDao {

    @Override
    public AccountBean findAccount(String name, String password,int role)  {
        AccountBean accountBean=null;
        String sql="select ac_id AcId,ac_name AcName,ac_password AcPassword Account where ac_name=? and ac_password=? and ac_role=?";
        Object [] conditions={name,password,role};
        try {
            accountBean=(AccountBean) this.findObjectWithConditions(sql,conditions,AccountBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return accountBean;
    }

    @Override
    public AccountBean findAccountById(String id) {
        AccountBean accountBean=null;
        String sql="select ac_id AcId,ac_name AcName,ac_sex AcSex,ac_birthday AcBirthday,ac_phone AcPhone,ac_address AcAddress,ac_role AcRole from Account where ac_id=?";
        Object [] params={id};
        try {
            accountBean=(AccountBean)this.findObjectWithConditions(sql,params,AccountBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return accountBean;
    }

    @Override
    public boolean addAccount(AccountBean account) {
        int result=0;
        String sql="insert into Account values(?,?,?,?,?,?,?,?)";
        Object [] params={account.getAcId(),account.getAcPassword(),account.getAcName(),account.getAcSex(),account.getAcBirthday(),account.getAcPhone(), account.getAcAddress(),account.getAcRole()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public boolean modifyAccount(AccountBean account) {
        boolean result=false;
        String sql="update account set ac_name=?,ac_sex=?,ac_birthday=?,ac_phone=?,ac_Address=? where ac_id=?";
        Object [] params={account.getAcName(),account.getAcSex(),account.getAcBirthday(),account.getAcPhone(), account.getAcAddress(),account.getAcId()};

        try {
           result= this.modifyObjectInformation(sql,params)==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteAccount(String accountId) {
        int result=0;
        String sql="delete from account where ac_id="+accountId;
        try {
            result=deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    @Override
    public boolean modifyPassword(String id,String password) {
        int result=0;
        String sql="update account set ac_password=? where ac_id=?";
        Object params[]={password,id};
        try {
            result=modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result==1;
    }


}
