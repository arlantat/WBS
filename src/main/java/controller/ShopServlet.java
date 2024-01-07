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
    ShopService shopService = new ShopService();
    AccService accService = new AccService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createShop(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteShop(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editShop(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void editShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        String name = request.getParameter("name");
        shopService.update(new Shop(idShop, name));
        response.sendRedirect("/suppliers?idShop=" + idShop);
    }

    private void createShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idAcc = Integer.parseInt(request.getParameter("idaccount"));
        Acc acc = accService.findById(idAcc);
        String name = request.getParameter("name");
        shopService.add(new Shop(0, acc, name));
        response.sendRedirect("/suppliers");
    }

    private void deleteShop(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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
            case "editFormShop":
                editFormShop(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void editFormShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        request.setAttribute("idShop", idShop);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("shop/edit.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("shop/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shop> shopList = shopService.findAll();
        request.setAttribute("shopList", shopList);
        request.setAttribute("username", request.getAttribute("username"));
        request.setAttribute("idAccount", request.getAttribute("idAccount"));
        request.getRequestDispatcher("shop/shopList.jsp").forward(request, response);
    }
}
