package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.biz.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter( "username" );
        String passWord=req.getParameter( "password" );
        UserService userService=new UserService();
        if(userService.vaidateAccount( userName,passWord,1 )){
            System.out.println( "登陆成功" );
            resp.sendRedirect( "chooseRestaurant.jsp" );
        }else {

            System.out.println( "登录失败" );
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向
        req.getRequestDispatcher( "login.jsp" ).forward( req,resp );
    }
}