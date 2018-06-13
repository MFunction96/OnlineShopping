package xyz.mfbrain.onlineshopping.action;

import org.apache.catalina.Session;
import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.bean.StoreBean;
import xyz.mfbrain.onlineshopping.biz.StoreService;
import xyz.mfbrain.onlineshopping.utils.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sregister")
public class SRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher( "sregister.jsp" ).forward( req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        StoreBean storeBean=new StoreBean();
        AccountBean user=(AccountBean) req.getSession().getAttribute("user");
        storeBean.setStName( req.getParameter( "storename" ) );
        storeBean.setStPhone( req.getParameter( "phone" ) );
        storeBean.setStDesc(req.getParameter( "sdesc" ));
        storeBean.setAcId(user.getAcId());
      //  storeBean.setStImage( req.getParameter( "storelogo" ) );

        StoreService storeService=new StoreService();
        Boolean add=storeService.registerStore( storeBean );
        try {
            ImageUtil.Upload( req,this,storeBean.getStId() );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("标志上传失败！");
            resp.sendRedirect( "sregister.jsp" );
        }
        if(add){
            System.out.println( "注册成功" );
            req.getSession().setAttribute( "stid" ,storeBean.getStId());
            resp.sendRedirect( "storemanager.jsp" );

        }else {
            System.out.println( "注册失败" );

        }
    }
}
