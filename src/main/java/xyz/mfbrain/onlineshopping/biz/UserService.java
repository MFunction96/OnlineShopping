package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.dao.AccountDaoImp;
import xyz.mfbrain.onlineshopping.dao.IAccountDao;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;
import xyz.mfbrain.onlineshopping.utils.MD5EncryptUtils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @program: OnlineShopping
 * @description: 用户管理模块
 * @author: ChrisYoung
 * @create: 2018-05-19 14:26
 **/

public class UserService {
    private IAccountDao accountDao;

    public UserService(){
        String key="AccountDao";
        try {
            accountDao=(AccountDaoImp)DAOFactory.getDaoFactory().newInstance(key);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证用户
     * @param name 用户名
     * @param password 密码
     * @param role 角色
     * @return 验证结果
     */
    public boolean vaidateAccount(String name,String password,int role){
        boolean result=false;
        AccountBean account=accountDao.findAccount(name,role);
        try {
            result= MD5EncryptUtils.validPassword(password,account.getAcPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断用户名是否存在
     * @param name
     * @return
     */
    public boolean isExist(String name){
        return accountDao.findAccountByName(name)!=null;
    }

    /**
     * 显示用户详细信息
     * @param id 用户id
     * @return 包含用户详细信息的对象
     */
    public AccountBean showAccountInfor(String id){
        AccountBean account=null;
        account=accountDao.findAccountById(id);
        return account;
    }

    /**
     * 注册账户
     * @param account 新账户
     * @return 注册结果
     */
    public boolean registerAccount(AccountBean account){
        UUID uuid=UUID.randomUUID();
        String truepwd= null;
        try {
            truepwd = MD5EncryptUtils.getEncryptedPwd(account.getAcPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        account.setAcId(String.valueOf(uuid));
        account.setAcPassword(truepwd);
        return accountDao.addAccount(account);
    }

    /**
     * 修改用户密码
     * @param id 用户id
     * @param newpwd 新密码
     * @return 修改结果
     */
    public boolean modifyPassword(String id,String newpwd){
        boolean result=false;
        String truepwd= null;
        try {
            truepwd = MD5EncryptUtils.getEncryptedPwd(newpwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        result=accountDao.modifyPassword(id,truepwd);
        return result;
    }

    /**
     * 修改用户信息
     * @param account 包含修改后信息的用户对象
     * @return 修改结果
     */
    public boolean modifyAccountInfo(AccountBean account){
        return accountDao.modifyAccount(account);
    }

}
