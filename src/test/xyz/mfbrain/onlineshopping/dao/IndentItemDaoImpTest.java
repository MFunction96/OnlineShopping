package xyz.mfbrain.onlineshopping.dao;

import org.junit.Before;
import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.IndentItemBean;
import xyz.mfbrain.onlineshopping.utils.DAOFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class IndentItemDaoImpTest {
    String diid1;
    String diid2;
    String inid;
    IindentItemDao indentItemDao;

    @Before
    public void setUp() throws Exception {
        indentItemDao=(IndentItemDaoImp)DAOFactory.getDaoFactory().newInstance("IndentItemDao");
        diid1="10b625e9-19d2-4f5c-8985-7646bbca49e0";
        diid2="d03dd6fb-9b79-4b29-8580-19c14d3e174a";
        inid="e490be76-0fa8-4123-9263-aa17ca3ad74f";

    }

    @Test
    public void findIndentItems() {
        ArrayList<IndentItemBean> items=indentItemDao.findIndentItems(inid);
        for (IndentItemBean item:
             items) {
            System.out.println(item.getItId());

        }
    }

    @Test
    public void addIndentItem() {
        IndentItemBean item=new IndentItemBean();
        item.setItId(UUID.randomUUID().toString());
        item.setDiId(diid2);
        item.setInId(inid);
        item.setItAmmount(1);
        item.setItTotalprice(BigDecimal.valueOf(12));
        assertEquals(true,indentItemDao.addIndentItem(item));
    }
}