package xyz.mfbrain.onlineshopping.action;

import xyz.mfbrain.onlineshopping.bean.*;
import xyz.mfbrain.onlineshopping.biz.DishService;
import xyz.mfbrain.onlineshopping.utils.JDBCUtils;
import xyz.mfbrain.onlineshopping.utils.JsonUtil;
import xyz.mfbrain.onlineshopping.utils.OrderList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;

@WebServlet("/chooseFood")
public class FoodServlet extends HttpServlet {
    String stid;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("actype").equals("showfood")) {
            showFood(req, resp);
        } else if (req.getParameter("actype").equals("addcart")) {
            addToShopCart(req, resp);
            resp.sendRedirect("chooseRestaurant?actiontype=show");
        }



    }


    private void showFood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        stid = req.getParameter("stid");
        DishService dishService = new DishService();
        StoreBean store = new StoreBean();
        store.setStId(stid);
        store.setStName(req.getParameter("stname"));
        store.setStImage(req.getParameter("stimg"));
        store.setStDesc(req.getParameter("stdesc"));
        store.setStPhone(req.getParameter("stphone"));
        ArrayList<DishBean> dishes = dishService.getAllDish(0, stid);
        req.setAttribute("dishes", dishes);
        req.setAttribute("store", store);
        req.getRequestDispatcher("chooseFood.jsp").forward(req,resp);
    }

    private void addToShopCart(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        AccountBean user = (AccountBean) req.getSession().getAttribute("user");
        DishorderBean dishOrder;
        OrderBean shopCart = null;
        OrderitemBean newDishCartItem;
        ArrayList<OrderitemBean> items;
        String filePath=this.getServletContext().getRealPath("/shopcart")+"/"+user.getAcId()+stid+".json";
        try {
            shopCart = (OrderBean) JsonUtil.DeserializeObj(filePath, OrderBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (shopCart == null) {
            dishOrder = makeNewDishOrder(req, user, stid);
            shopCart = new OrderBean();
            shopCart.setDishorderBean(dishOrder);
            newDishCartItem = makeNewItem(req);
            items = new ArrayList<>();
            items.add(newDishCartItem);
            shopCart.setOrderItems(items);
        } else {
            for (int i=0;i<shopCart.getOrderItems().size();i++) {
                OrderitemBean item=shopCart.getOrderItems().get(i);
                if (item.getDiId().equals(req.getParameter("diid"))) {
                    item.setItAmmount(item.getItAmmount() + 1);
                } else {
                    newDishCartItem = makeNewItem(req);
                    shopCart.getOrderItems().add(newDishCartItem);
                }
            }
        }
        try {
            JsonUtil.SerializeObj(shopCart, OrderBean.class, filePath, false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private DishorderBean makeNewDishOrder(HttpServletRequest req, AccountBean user, String stid) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        DishorderBean newDishOrder = new DishorderBean();
        newDishOrder.setCustomerid(user.getAcId());
        newDishOrder.setAcName(user.getAcName());
        newDishOrder.setStid(stid);
        newDishOrder.setStname(req.getParameter("sname"));
        return newDishOrder;
    }


    private OrderitemBean makeNewItem(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        OrderitemBean newItem = new OrderitemBean();
        newItem.setItAmmount(1);
        newItem.setDiId(req.getParameter("diid"));
        newItem.setDiName(req.getParameter("diname"));
        newItem.setDiImage(req.getParameter("diimage"));
        newItem.setItTotalprice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("diprice"))));
        return newItem;
    }


}
