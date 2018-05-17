package xyz.mfbrain.onlineshopping.utils;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库工具类
 */
public class JDBCUtils {
    private  static JDBCUtils jdbc_ustils=new JDBCUtils();
//    private String driver;//数据库驱动
//    private String username;//数据库登录名
//    private String password;//密码
    private Properties properties=new Properties();
    private DataSource dataSource;
    //url格式：
    //JDBC:子协议:子名称//主机名:端口/数据库名？属性名=属性值&…
    private String url;

    public static JDBCUtils getJdbc_ustils() {
        return jdbc_ustils;
    }

    public static void setJdbc_ustils(JDBCUtils ustils) {
        jdbc_ustils = ustils;
    }


    private JDBCUtils(){
        //读取配置文件
        InputStream ios=JDBCUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");

        try {
            properties.load(ios);//将输入输流中的配置信息（键值对）的方式，加载到properties对象中
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dataSource=BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private Connection getConnection1(){
        Connection connection=null;//负责连接数据库并担任传送数据的任务
//
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 释放资源
     * @param con
     * @param rs
     * @param st
     */
    private void free1(Connection con, ResultSet rs, Statement st){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection(){
        return getJdbc_ustils().getConnection1();
    }

    public void free(Connection con, ResultSet rs, Statement st){
        getJdbc_ustils().free1(con,rs,st);
    }


}
