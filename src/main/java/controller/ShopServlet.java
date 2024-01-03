package controller;


import model.Acc;
import model.Product;
import model.Shop;
import service.AccService;
import service.ProductService;
import service.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shops")
public class ShopServlet extends HttpServlet {
    ShopService shopService  = new ShopService();
    AccService accService = new AccService();

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
            default:
                showList(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAcc = Integer.parseInt(request.getParameter("idaccount"));
        Acc acc = accService.findById(idAcc);
        String name= request.getParameter("name");
        shopService.add(new Shop(0, name, acc));
        response.sendRedirect("/home");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        shopService.delete(id);
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
                editForm(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = new Shop();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        shop = shopService.findById(id);
        request.setAttribute("EditProduct", shop);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("shopzz/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shop> shopList = shopService.findAll();
        request.setAttribute("ds", shopList);
        request.getRequestDispatcher("shopzz/list.jsp").forward(request, response);
    }
}
