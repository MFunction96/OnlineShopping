package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.IndentBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class IndentDaoImpTest {
    IindentDao indentDao=null;
    String stid;
    String acid;
    String inid;

    @Before
    public void setUp() throws Exception {
        stid="2ce85a49-d4f1-4a9d-a827-1f6f2c129c77";
        acid="0738c940-7c1b-49f6-8730-9cacf1e10e39";
        inid="bc51bbd7-64e0-4445-a884-62cd3e02db6c";
        indentDao=(IndentDaoImp)DAOFactory.getDaoFactory().newInstance("IndentDao");
    }

    @Test
    public void findAllIndents() {
        ArrayList<IndentBean> indents=new ArrayList<>();
        indents=indentDao.findAllIndents(stid);
        for (IndentBean indent:indents
             ) {
            System.out.println(indent.getInTotalprice());

        }
    }

    @Test
    public void findAllIndentsByDate() {
        ArrayList<IndentBean> indents=new ArrayList<>();
        indents=indentDao.findAllIndentsByDate("2018-4-12","2018-5-13",stid);
        for (IndentBean indent:indents
                ) {
            System.out.println(indent.getInTotalprice());

        }
    }

    @Test
    public void findIndentByID() {
        System.out.println(indentDao.findIndentByID("bc51bbd7-64e0-4445-a884-62cd3e02db6c").getInOrdertime());
    }

    @Test
    public void addIndent() {
        IndentBean indent=new IndentBean();
        indent.setInId(UUID.randomUUID().toString());
        indent.setStId(stid);
        indent.setCustomerid(acid);
        indent.setInOrdertime(Timestamp.valueOf("2018-3-12 18:31:11"));
        indent.setInTotalprice(BigDecimal.valueOf(66));
        indent.setInStatus("确认");
        assertEquals(true,indentDao.addIndent(indent));
    }

    @Test
    public void modifyIndentStatus() {

      assertEquals(true,indentDao.modifyIndentStatus("bc51bbd7-64e0-4445-a884-62cd3e02db6c","取消"));

    }

    @Test
    public void modifyIndentRemark() {
    }

    @Test
    public void getIndentNumByStoreId() {
        System.out.println(indentDao.getIndentNumByStoreId(stid));
    }

    @Test
    public void getIndentNumByDate() {
        System.out.println(indentDao.getIndentNumByDate("2018-4-12","2018-5-13",stid));
    }

    @Test
    public void deleteIndent() {
        assertEquals(true,indentDao.deleteIndent("d5ac1bbd-df50-4977-aedb-74481814235a"));
    }
}