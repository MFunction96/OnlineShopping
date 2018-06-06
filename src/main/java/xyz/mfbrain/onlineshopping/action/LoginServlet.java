package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.biz.UserService;
import xyz.mfbrain.onlineshopping.utils.MD5EncryptUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName=req.getParameter( "username" );
        String passWord=req.getParameter( "password" );
        UserService userService=new UserService();
        boolean result=false;
        AccountBean account=userService.vaidateAccount( userName);
        try {
            result=MD5EncryptUtils.validPassword(passWord,account.getAcPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(result){
            HttpSession session=req.getSession();
            session.setAttribute("user",account);
            if(account.getAcRole()==1){
                System.out.println( "登陆成功" );
               resp.sendRedirect("index.jsp");

            }else{
                resp.sendRedirect("chooseRestaurant.jsp");
            }


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
