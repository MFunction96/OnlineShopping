package xyz.mfbrain.onlineshopping.biz;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.dao.AccountDaoImp;
import xyz.mfbrain.onlineshopping.dao.IAccountDao;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;
import xyz.mfbrain.onlineshopping.utils.MD5EncryptUtils;

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

    public boolean vaidateAccount(String name,String password,int role){
        String truepwd=MD5EncryptUtils.MD5(password);
        return accountDao.findAccount(name,truepwd,role)==null;
    }

    public boolean isExist(String name){
        return accountDao.findAccountByName(name)==null;
    }

    public AccountBean showAccountInfor(String id){
        AccountBean account=null;
        account=accountDao.findAccountById(id);
        return account;
    }

    public boolean registerAccount(AccountBean account){
        UUID uuid=UUID.randomUUID();
        String truepwd=MD5EncryptUtils.MD5(account.getAcPassword());
        account.setAcId(String.valueOf(uuid));
        account.setAcPassword(truepwd);
        return accountDao.addAccount(account);
    }

    public boolean modifyPassword(String id,String newpwd){
        boolean result=false;
        String truepwd=MD5EncryptUtils.MD5(newpwd);
        result=accountDao.modifyPassword(id,truepwd);
        return result;
    }

    public boolean modifyAccountInfo(AccountBean account){
        return accountDao.modifyAccount(account);
    }

}
