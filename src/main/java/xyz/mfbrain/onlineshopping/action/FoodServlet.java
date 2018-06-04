package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.DishBean;
import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.biz.DishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/chooseFood")
public class FoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req,resp );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String s=req.getParameter("stid");
        DishService dishService=new DishService();
        StoreBean store=new StoreBean();
        store.setStName(req.getParameter("stname"));
        store.setStImage(req.getParameter("stimg"));
        store.setStDesc(req.getParameter("stdesc"));
        ArrayList<DishBean> dishes=dishService.getAllDish(0,s);
        req.setAttribute("dishes",dishes);
        req.setAttribute("store",store);
        req.getRequestDispatcher( "chooseFood.jsp" ).forward( req,resp );
    }
}
