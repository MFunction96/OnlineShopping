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
import java.io.UnsupportedEncodingException;
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
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(result){
            HttpSession session=req.getSession();
            session.setAttribute("user",account);
            if(account.getAcRole()==2){
                System.out.println( "登陆成功" );
                resp.sendRedirect("index.jsp");

            }else{
                resp.sendRedirect("index.jsp");
            }


        }else {
            System.out.println( "登录失败" );
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 重定向
        String code=req.getParameter("code");
        if(code.equals("1")){
            req.getRequestDispatcher( "login.jsp" ).forward( req,resp );
        }else if(code.equals("2")){
            logout(req,resp);
        }

    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("user",null);
        resp.sendRedirect("index.jsp");
    }

}
