package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.biz.StoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/chooseRestaurant")
public class Restaurantservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req,resp );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StoreService ss=new StoreService();
        ArrayList<StoreBean> stores=ss.getAllStores();
        req.setAttribute("stores",stores);
        req.getRequestDispatcher( "chooseRestaurant.jsp" ).forward( req,resp );
    }
}
