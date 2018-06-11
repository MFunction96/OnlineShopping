package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.AccountBean;
import xyz.mfbrain.onlineshopping.bean.OrderBean;
import xyz.mfbrain.onlineshopping.biz.OrderService;
import xyz.mfbrain.onlineshopping.utils.PageModle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoppingCart")
public class CartServlet extends HttpServlet {
    private int pageSize = 6;
    private int _total;
    private PageModle<OrderBean> _pagemodel;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        var os = new OrderService();
        int pageNo;
        try {
            pageNo = Integer.parseInt(req.getParameter("pageNo"));
        } catch (Exception ignored) {
            pageNo = 1;
        }
        var account = (AccountBean) req.getSession().getAttribute("user");
        if (account == null) {
            resp.sendRedirect("/login?code=1");
            return;
        }
        _pagemodel = os.findOrdersInPagesForA(account.getAcId(), pageNo, pageSize);
        _total = _pagemodel.getTotalPages();
        req.setAttribute("dishes", _pagemodel.getList());
        req.setAttribute("pageModel", _pagemodel);
        req.getRequestDispatcher("shoppingCart.jsp?pageNo=" + pageNo + "&totalpages=" + _total).forward(req, resp);
    }

}
