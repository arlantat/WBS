package controller;

import model.*;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService  = new ProductService();
    ShopService shopService = new ShopService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "pay":
                payment(request, response);
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
            case  "edit":
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
        String name = request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        productService.add(new Product(0, name, price));
        response.sendRedirect("/home");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        productService.add(new Product(0, name, price));
        response.sendRedirect("/home");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "editForm":
                editForm(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = 1;
        String nameCur;
        double priceCur;
        int idCur, quantityCur;
        List<CartItem> cart = new ArrayList<>();
        while (request.getParameter("id" + index) != null) {
            quantityCur = Integer.parseInt(request.getParameter("quantity" + index));
            if (quantityCur == 0) {
                index++;
                continue;
            }
            idCur = Integer.parseInt(request.getParameter("id" + index));
            nameCur = request.getParameter("name" + index);
            priceCur = Double.parseDouble(request.getParameter("price" + index));
            CartItem cartItem = new CartItem(idCur, nameCur, priceCur, quantityCur);
            cart.add(cartItem);
            index++;
        }
        request.setAttribute("cart", cart);
        request.setAttribute("idShop", request.getParameter("idShop"));
        request.setAttribute("idAccount", request.getParameter("idAccount"));
        request.setAttribute("nameShop", request.getParameter("nameShop"));
        request.getRequestDispatcher("product/cart.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        product = productService.findById(id);
        request.setAttribute("EditProduct", product);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("productss/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        String nameShop = shopService.findById(idShop).getName();
        List<Product> products = productService.findAllByShop(idShop);
        request.setAttribute("nameShop", nameShop);
        request.setAttribute("idShop", idShop);
        request.setAttribute("idAccount", idAccount);
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }
}
