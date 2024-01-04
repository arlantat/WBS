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

@WebServlet(name = "ProductServlet", urlPatterns = "/products/idShop=1")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ProductService productService = new ProductService();
    ShopService shopService = new ShopService();

    public ProductServlet() {
        // Default constructor
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "pay":
                payment(request, response);
                System.out.println("ddddd");
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
                    e.printStackTrace();
                    response.sendRedirect("/errorPage");
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            productService.add(new Product(0, name, price));
            response.sendRedirect("/home");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/errorPage");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            productService.add(new Product(0, name, price));
            response.sendRedirect("/home");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/errorPage");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            productService.delete(id);
            response.sendRedirect("/home");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("/errorPage");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                editForm(request, response);
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
        while (request.getParameter("id" + index) != null && !request.getParameter("id" + index).isEmpty()) {
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
            System.out.println(cartItem.getId());
            System.out.println(cartItem.getName());
            System.out.println(cartItem.getPrice());
            System.out.println(cartItem.getQuantity());
            index++;
        }
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("product/payment.jsp").forward(request, response);
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("EditProduct", product);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        String nameShop = shopService.findById(idShop).getName();
        List<Product> products = productService.findAllByShop(idShop);
        request.setAttribute("nameShop", nameShop);
        request.setAttribute("idShop", idShop);
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }
}