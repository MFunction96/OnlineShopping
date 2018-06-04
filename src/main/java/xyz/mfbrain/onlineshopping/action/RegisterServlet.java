package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.biz.UserService;
import xyz.mfbrain.onlineshopping.dao.IAccountDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        AccountBean newaccount=new AccountBean();
       newaccount.setAcName(req.getParameter( "username" ));
       newaccount.setAcPassword(req.getParameter( "password" ));
       newaccount.setAcAddress( req.getParameter( "address" ) );
       newaccount.setAcBirthday( Date.valueOf( req.getParameter( "birthday" ) ) );
        newaccount.setAcPhone( req.getParameter( "phone" ) );
       newaccount.setAcSex( req.getParameter( "sex" ) );
       /*       * 1--商户       * 2--用户*/
       newaccount.setAcRole( Long.parseLong( req.getParameter( "role" ) ) );
        UserService userService=new UserService();
      Boolean add=userService.registerAccount( newaccount );
      if(add){
          System.out.println( "注册成功" );
          resp.sendRedirect( "chooseRestaurant.jsp" );
      }else {
          System.out.println( "注册失败" );
          resp.sendRedirect( "register.jsp" );
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet( req, resp );
        //doPost( req,resp );
        // 重定向
       req.getRequestDispatcher( "register.jsp" ).forward( req,resp );
       // resp.sendRedirect( "register" );
    }
}
