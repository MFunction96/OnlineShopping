package xyz.mfbrain.onlineshopping.dao;


import xyz.mfbrain.onlineshopping.bean.AccountBean;

/**
 * @program: myshop
 * @description: 用户管理模块接口
 * @author: ChrisYoung
 * @create: 2018-05-16 21:57
 **/

public interface IAccountDao {
    public AccountBean findAccount(String name, String password, int role);

    public AccountBean findAccountById(String id);

    public boolean addAccount(AccountBean account);

    public boolean modifyAccount(AccountBean account);

    public boolean deleteAccount(String accountId);

    public boolean modifyPassword(String id,String password);
}
