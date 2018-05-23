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
        diid1="0fda5160-ec74-4e68-9190-95639c28b765";
        diid2="2681f39f-9b02-4c89-baf2-29c968ca6b32";
        inid="bc51bbd7-64e0-4445-a884-62cd3e02db6c";

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
        item.setItAmmount(4);
        item.setItTotalprice(BigDecimal.valueOf(56));
        assertEquals(true,indentItemDao.addIndentItem(item));
    }
}