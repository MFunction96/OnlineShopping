package xyz.mfbrain.onlineshopping.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
    private Properties properties;
    private static DAOFactory daoFactory=new DAOFactory();

    private DAOFactory(){
        //加载daoconfig.property
        InputStream ios=DAOFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        properties=new Properties();
        try {
            properties.load(ios);//将输入输流中的配置信息（键值对）的方式，加载到properties对象中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }

    private Properties getProperties(){
        return properties;
    }



    public Object newInstance(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        return Class.forName(getDaoFactory().getProperties().getProperty(key)).newInstance();
        //Class.forName(getDaoFactory().getProperties().getProperty(key)).getDeclaredConstructor().newInstance();
    }
}
