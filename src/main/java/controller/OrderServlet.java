package controller;

import model.*;
import service.AccService;
import service.OrderService;
import service.ShopService;
import service.TotalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    AccService accService = new AccService();
    OrderService orderService = new OrderService();
    ShopService shopService = new ShopService();
    OrderDetail orderDetail = new OrderDetail();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "cancelOrder":
                try {
                    cancelOrder(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "completeOrder":
                try {
                    completeOrder(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    create(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    edit(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(request, response);
        }
    }
    private void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        if (orderService.cancel(idOrder)) {
            request.setAttribute("msg", "Hủy đơn thành công");
        } else {
            request.setAttribute("msg", "Hủy đơn không thành công");
        }
        request.setAttribute("idAccount", idAccount);
        request.setAttribute("username", accService.findById(idAccount).getUsername());
        request.getRequestDispatcher("user/accountinfo.jsp").forward(request, response);
    }
    private void completeOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        int index = 1;
        String nameCur;
        double priceCur;
        int idCur, quantityCur;
        List<CartItem> cart = new ArrayList<>();
        while (request.getParameter("id" + index) != null) {
            quantityCur = Integer.parseInt(request.getParameter("quantity" + index));
            idCur = Integer.parseInt(request.getParameter("id" + index));
            nameCur = request.getParameter("name" + index);
            priceCur = Double.parseDouble(request.getParameter("price" + index));
            CartItem cartItem = new CartItem(idCur, nameCur, priceCur, quantityCur);
            cart.add(cartItem);
            index++;
        }
        request.setAttribute("idAccount", idAccount);
        request.setAttribute("username", accService.findById(idAccount).getUsername());
        System.out.println(accService.findById(idAccount).getUsername());
        if (orderService.add(idShop, idAccount, totalPrice, cart)) {
            request.setAttribute("msg", "Thành công, nhấn xem lịch sử mua hàng");
        } else {
            request.setAttribute("msg", "Có lỗi");
        }
        request.getRequestDispatcher("user/accountinfo.jsp").forward(request, response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAcc = Integer.parseInt(request.getParameter("idaccount"));
        Acc acc = accService.findById(idAcc);
        int idOrderDetail= Integer.parseInt(request.getParameter("idod"));
        OrderDetail orderDetail = orderService.findById(idOrderDetail);
        int idShop = Integer.parseInt(request.getParameter("idshop"));
        Shop shop = shopService.findById(idShop);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        orderService.update(new Order(acc, orderDetail,shop,timestamp,status));
        response.sendRedirect("/Blogs");
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAcc = Integer.parseInt(request.getParameter("idaccount"));
        Acc acc = accService.findById(idAcc);
        int idOrderDetail= Integer.parseInt(request.getParameter("idod"));
        OrderDetail orderDetail = orderService.findById(idOrderDetail);
        int idShop = Integer.parseInt(request.getParameter("idshop"));
        Shop shop = shopService.findById(idShop);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        orderService.add(new Order(0, acc, orderDetail, shop,timestamp,status));
        response.sendRedirect("/home");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.delete(id);
        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showHistory":
                showHistory(request, response);
                break;
            case "createForm":
                showCreateForm(request, response);
                break;
            case "editForm":
                editForm(request, response);
                break;
            case "showTotal":
                totalForm(request,response);
            default:
                showList(request, response);
        }
    }

    private void totalForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TotalService totalService = new TotalService();
        List<Total> totalList = totalService.total();
        request.setAttribute("danhsach", totalList);
        request.getRequestDispatcher("admin/total.jsp").forward(request, response);
    }

    private void showHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        List<PastOrder> pastOrders = orderService.ordersByAccount(idAccount);
        request.setAttribute("pastOrders", pastOrders);
        request.setAttribute("idAccount", idAccount);
        request.setAttribute("username", accService.findById(idAccount).getUsername());
        request.getRequestDispatcher("user/orderhistory.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        order = orderService.findById(id);
        request.setAttribute("editOrder", order);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("order/create.jsp").forward(request, response);
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.findAll();
        request.setAttribute("ds", orders);
        request.getRequestDispatcher("order/list.jsp").forward(request, response);
    }

}
