package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.biz.StoreService;
import xyz.mfbrain.onlineshopping.utils.PageModle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet ("/chooseRestaurant")
public class Restaurantservlet extends HttpServlet {
    private int pageSize=1;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        StoreService ss=new StoreService();
        String search=req.getParameter("search");
        StoreBean store=ss.searchStoreByName(search);
        ArrayList<StoreBean> stores=new ArrayList<>();
        stores.add(store);
        req.setAttribute("stores",stores);
        req.getRequestDispatcher( "chooseRestaurant.jsp" ).forward( req,resp );

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actiontype=req.getParameter("actiontype");
        switch (actiontype){
            case "show":
                showStores(req,resp);
                break;
            case "pagelist":
                pageListView(req,resp);
        }


    }

    private void showStores(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        StoreService ss=new StoreService();
        int pageNo=1;
        PageModle<StoreBean> pagemodel=ss.findSroreInPages(pageNo,pageSize);
        req.setAttribute("stores",pagemodel.getList());
        req.setAttribute("pageModel",pagemodel);
        req.getRequestDispatcher("chooseRestaurant.jsp?pageNo=1&totalpages="+pagemodel.getTotalPages()).forward(req,resp);
    }

    private void pageListView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=Integer.parseInt(req.getParameter("pageNo"));
        StoreService ss=new StoreService();
        PageModle<StoreBean> pagemodel=ss.findSroreInPages(pageNo,pageSize);
        req.setAttribute("stores",pagemodel.getList());
        req.setAttribute("pageModel",pagemodel);
        req.getRequestDispatcher("chooseRestaurant.jsp?pageNo="+pageNo+"&totalpages="+pagemodel.getTotalPages()).forward(req,resp);
    }

}
