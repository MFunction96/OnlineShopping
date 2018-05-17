package xyz.mfbrain.onlineshopping.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class JDBCUtilsTest {

    @Test
    public void getJdbc_ustils() {
        assertNotNull(JDBCUtils.getJdbc_ustils());
    }

    @Test
    public void getConnection() {
    }
}