package xyz.mfbrain.onlineshopping.biz;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.dao.AccountDaoImp;
import xyz.mfbrain.onlineshopping.dao.IAccountDao;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.sql.Date;
import java.util.UUID;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService ser;

    @Before
    public void setUp() throws Exception {
      ser=new UserService();
    }

    @Test
    public void vaidateAccount() {
        assertEquals(true,ser.vaidateAccount("Tomas","12345678",1));

    }

    @Test
    public void isExist() {
        assertEquals(true,ser.isExist("Tomas"));
    }

    @Test
    public void showAccountInfor() {
        System.out.println(ser.showAccountInfor("46422b05-bf95-4372-978d-47bd5bf2d3d9").getAcName());
    }

    @Test
    public void registerAccount() {
        AccountBean account=new AccountBean();
        account.setAcId(String.valueOf(UUID.randomUUID().toString()));
        account.setAcName("Tomas");
        account.setAcAddress("dsfadsdfhghfgfaf");
        account.setAcBirthday(Date.valueOf("1996-1-1"));
        account.setAcPassword("123456");
        account.setAcPhone("1212112446312121");
        account.setAcSex("男");
        account.setAcRole(1);
        assertEquals(true,ser.registerAccount(account));
    }

    @Test
    public void modifyPassword() {
        assertEquals(true,ser.modifyPassword("46422b05-bf95-4372-978d-47bd5bf2d3d9","12345678"));
    }

    @Test
    public void modifyAccountInfo() {
    }
}