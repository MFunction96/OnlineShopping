package xyz.mfbrain.onlineshopping.action;

import javafx.scene.control.Alert;
import xyz.mfbrain.onlineshopping.bean.AccountBean;
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

@WebServlet("/storemanager")
public class StoreControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher( "storemanager.jsp" ).forward( req,resp );
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
            AccountBean user=(AccountBean) httpSession.getAttribute( "usrt" );
           boolean add=dishService.addDish( dishBean,user.getAcId());
           if(add){
               dishBean.setDiImage( dishBean.getDiId() );
               try {
                   ImageUtil.Upload( req,this,dishBean.getDiImage() );
               } catch (Exception e) {
                   e.printStackTrace();
                   System.out.println("标志上传失败！");
               }
               System.out.println( "注册成功" );

           }
           else {
               System.out.println( "注册失败" );
           }
        }
    }
}
