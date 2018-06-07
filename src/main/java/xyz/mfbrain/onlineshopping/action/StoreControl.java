package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.DishBean;
import xyz.mfbrain.onlineshopping.biz.DishService;
import xyz.mfbrain.onlineshopping.utils.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/adddish")
public class StoreControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher( "adddish.jsp" ).forward( req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter( "method" );
        if(method.equals( "add" )){
            DishBean dishBean =new DishBean();
            dishBean.setDiName( req.getParameter( "dishname" ) );
            dishBean.setDiPrice(BigDecimal.valueOf( Long.valueOf( req.getParameter( "diprice" ) )) );
            dishBean.setDiDesc( req.getParameter( "didesc" ) );
            DishService dishService=new DishService();
            HttpSession httpSession=req.getSession();
           // dishService.addDish( dishBean,httpSession.getAttribute( "sid" ) )
        }
    }
}
