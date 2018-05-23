package xyz.mfbrain.onlineshopping.dao;


import xyz.mfbrain.onlineshopping.bean.AccountBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @program: myshop
 * @description: 数据库账户表操作类
 * @author: ChrisYoung
 * @create: 2018-05-16 22:00
 **/

public class AccountDaoImp extends BaseDao implements IAccountDao {


    /**
     * 根据用户名、密码以及用户角色查找用户
     * 可用于用户登录、修改密码
     * @param name  用户名
     * @param password 密码
     * @param role 角色
     * @return 只包含用户名、密码和角色信息的用户对象
     */
    @Override
    public AccountBean findAccount(String name, String password,int role)  {
        AccountBean accountBean=null;
        String sql="select ac_id AcId,ac_name AcName,ac_password AcPassword from Account where ac_name=? and ac_password=? and ac_role=?";
        Object [] conditions={name,password,role};
        try {
            accountBean=(AccountBean) this.findObjectWithConditions(sql,conditions,AccountBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return accountBean;
    }


    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     * @return 返回包含除密码意外的全部用户信息
     */
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


    /**
     * 根据用户名查找用户
     * @param name  用户名
     * @return  返回用户对象
     */
    @Override
    public AccountBean findAccountByName(String name) {
        AccountBean accountBean=null;
        String sql="select ac_id AcId,ac_name AcName from Account where ac_name=?";
        Object [] params={name};
        try {
            accountBean=(AccountBean)this.findObjectWithConditions(sql,params,AccountBean.class);
        } catch (SQLException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return accountBean;
    }

    /**
     * 添加用户
     * @param account 从Servlet传入的用户对象
     * @return 返回添加结果 true成功、false失败
     */

    @Override
    public boolean addAccount(AccountBean account) {
        int result=0;
        String sql="insert into Account values(?,?,?,?,?,?,?,?)";
        Object [] params={account.getAcId(),account.getAcName(),account.getAcPassword(),account.getAcSex(),account.getAcBirthday(),account.getAcPhone(), account.getAcAddress(),account.getAcRole()};
        try {
            result=this.modifyObjectInformation(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }

    /**
     * 修改用户信息
     * @param account  包含已经修改好的用户信息
     * @return 返回修改结果 ture成功/false失败
     */
    @Override
    public boolean modifyAccount(AccountBean account) {
        boolean result=false;
        String sql="update Account set ac_name=?,ac_sex=?,ac_birthday=?,ac_phone=?,ac_Address=? where ac_id=?";
        Object [] params={account.getAcName(),account.getAcSex(),account.getAcBirthday(),account.getAcPhone(), account.getAcAddress(),account.getAcId()};

        try {
           result= this.modifyObjectInformation(sql,params)==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除账户
     * @param accountId  账户ID
     * @return 删除结果
     */
    @Override
    public boolean deleteAccount(String accountId) {
        int result=0;
        String sql="delete from Account where ac_id="+"'"+accountId+"'";
        try {
            result=deleteObject(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result==1;
    }


    /**
     * 修改密码
     * @param id  账户id
     * @param password 新密码
     * @return 返回修改结果
     */
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
