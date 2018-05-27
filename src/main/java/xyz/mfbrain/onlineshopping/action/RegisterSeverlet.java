package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.dao.IAccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegisterSeverlet extends HttpServlet {
    IAccountDao accountDao=null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountBean newaccount=new AccountBean();
       newaccount.setAcName(req.getParameter( "username" ));
       newaccount.setAcPassword(req.getParameter( "password" ));
       newaccount.setAcAddress( req.getParameter( "address" ) );
       SimpleDateFormat simpleDateFormat=new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            newaccount.setAcBirthday( (Date) simpleDateFormat.parse( req.getParameter( "birthday" ) ) );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newaccount.setAcPhone( req.getParameter( "phone" ) );
       newaccount.setAcSex( req.getParameter( "sex" ) );
       /*       * 1--商户       * 2--用户*/
       newaccount.setAcRole( Long.parseLong( req.getParameter( "role" ) ) );
       accountDao.addAccount( newaccount );
    }
}
