package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.sql.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class AccountDaoImpTest {
    IAccountDao accountDao=null;
    UUID uuid=UUID.randomUUID();

    @Before
    public void setUp() throws Exception {
        try {
            accountDao=(AccountDaoImp)DAOFactory.getDaoFactory().newInstance("AccountDao");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAccount() {
        assertNotNull(accountDao.findAccount("Tom",1));

    }

    @Test
    public void findAccountById() {
        System.out.println(accountDao.findAccountById("a1a7c58a-9ec3-45e0-9141-c6196157c37e").getAcName());
    }

    @Test
    public void findAccountByName() {
        System.out.println(accountDao.findAccountByName("Tomas").getAcName());

    }

    @Test
    public void addAccount() {
        AccountBean account=new AccountBean();
        account.setAcId(String.valueOf(uuid));
        account.setAcName("Chris");
        account.setAcPassword("1322222");
        account.setAcAddress("dsfadsdfhghfgfaf");
        account.setAcBirthday(Date.valueOf("1998-1-1"));
        account.setAcPhone("1212112446342112121");
        account.setAcSex("男");
        account.setAcRole(1);
        assertEquals(true,accountDao.addAccount(account));
    }

    @Test
    public void modifyAccount() {
    }

    @Test
    public void deleteAccount() {
        assertEquals(true,accountDao.deleteAccount("111"));
    }

    @Test
    public void modifyPassword() {
    }
}