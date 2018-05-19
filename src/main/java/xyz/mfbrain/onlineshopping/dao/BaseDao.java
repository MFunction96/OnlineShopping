package xyz.mfbrain.onlineshopping.dao;



import xyz.mfbrain.onlineshopping.utils.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public abstract class BaseDao {
    Statement st=null;
    Connection con=null;
    ResultSet resultSet=null;
    PreparedStatement ps=null;

    public Object mappingObject(ResultSet rs, Class cl) throws IllegalAccessException, InstantiationException, SQLException, InvocationTargetException {
        Object obj=cl.newInstance();
        Method[] methods=cl.getMethods();
        ResultSetMetaData resultSetMetaData=rs.getMetaData();
        for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
            //构造方法名
            String column_name=resultSetMetaData.getColumnLabel(i);
            String method_name="set"+column_name;

            //在类的方法结合中查找该方法
            for(Method method:methods){
                if(method.getName().equals(method_name)){
                    //找到方法名后，调用该方法
                    method.invoke(obj,rs.getObject(i));
                    break;
                }
            }
        }


        return obj;

    }




    public Object findObjectWithConditions(String sql, Object conditions[], Class cl ) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        con=JDBCUtils.getJdbc_ustils().getConnection();
        Object obj=null;
        ps=con.prepareStatement(sql);
        for(int i=0;i<conditions.length;i++){
            ps.setObject(i+1,conditions[i]);
        }
        resultSet=ps.executeQuery();
        while(resultSet.next()){
            obj=mappingObject(resultSet,cl);
        }
        JDBCUtils.getJdbc_ustils().free(con,resultSet,ps);
        return obj;
    }

    public ArrayList findAllObject(String sql, Class cl) throws InvocationTargetException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList objects=new ArrayList<>();
        con=JDBCUtils.getJdbc_ustils().getConnection();
        st=con.createStatement();
        //String sql="select sid ID,sname Name,age Age,sex Sex,birthday Birthday,address Address from studentinfo";
        resultSet=st.executeQuery(sql);
        while(resultSet.next()){
            Object object=new Object();
            object=mappingObject(resultSet,cl);
            objects.add(object);
        }
        JDBCUtils.getJdbc_ustils().free(con,resultSet,st);

        return objects;
    }

    public int modifyObjectInformation(String sql, Object params[]) throws SQLException {
        int affect_rows;
        con=JDBCUtils.getJdbc_ustils().getConnection();
        ps=con.prepareStatement(sql);
        for(int i=0;i<params.length;i++){
            ps.setObject(i+1,params[i]);
        }
        affect_rows=ps.executeUpdate();
        JDBCUtils.getJdbc_ustils().free(con,null,ps);
        return affect_rows;
    }

    public int deleteObject(String sql) throws SQLException {
        int affect_rows;
        con=JDBCUtils.getJdbc_ustils().getConnection();
        ps=con.prepareStatement(sql);
        affect_rows=ps.executeUpdate();
        JDBCUtils.getJdbc_ustils().free(con,resultSet,ps);
        return affect_rows;
    }


    public int getTotalObjectsNum(String sql) throws SQLException {
        int rows=0;
        con=JDBCUtils.getJdbc_ustils().getConnection();
        ps=con.prepareStatement(sql);
        resultSet=ps.executeQuery();
        while (resultSet.next()){
            rows=resultSet.getInt(1);
        }
        JDBCUtils.getJdbc_ustils().free(con,resultSet,ps);
        return rows;

    }



}
