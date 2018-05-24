package xyz.mfbrain.onlineshopping.utils;

import org.junit.Test;
import xyz.mfbrain.onlineshopping.bean.DishorderBean;
import xyz.mfbrain.onlineshopping.bean.OrderBean;
import xyz.mfbrain.onlineshopping.bean.OrderitemBean;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class JsonUtilTest {

    @Test
    public void serializeObj() throws IOException {
        var dishorder = new DishorderBean();
        var items = new ArrayList<OrderitemBean>();
        dishorder.setStid("db9cdff2-f091-40a5-a85c-a15a1479ed06");
        dishorder.setInTotalprice(BigDecimal.valueOf(400));
        dishorder.setCustomerid("a1a7c58a-9ec3-45e0-9141-c6196157c37e");
        dishorder.setInOrdertime(Timestamp.valueOf("2018-4-4 4:34:23"));
        var item = new OrderitemBean();
        item.setInId(dishorder.getInId());
        item.setDiId("0fda5160-ec74-4e68-9190-95639c28b765");
        item.setItAmmount(10);
        item.setItTotalprice(BigDecimal.valueOf(111));
        items.add(item);
        var obj = new OrderBean();
        obj.setDishorderBean(dishorder);
        obj.setOrderItems(items);
        JsonUtil.SerializeObj(obj,  "./test.json", false);
        var result = (OrderBean) JsonUtil.DeserializeObj("./test.json", OrderBean.class);
        assertEquals(obj, result);
    }

    @Test
    public void deserializeObj() {
    }
}