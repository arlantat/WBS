package controller;

import model.Acc;
import model.Order;
import model.OrderDetail;
import model.Shop;
import service.AccService;
import service.OrderService;
import service.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    OrderServlet orderServlet = new OrderServlet();
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
                    edit(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(request, response);
        }
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
            case "createForm":
                showCreateForm(request, response);
                break;
            case "editForm":
                editForm(request, response);
                break;
            default:
                showList(request, response);
        }
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
