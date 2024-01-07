package controller;

import model.*;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    ShopService shopService = new ShopService();
    AccService accService = new AccService();

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

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        int oldId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String url = request.getParameter("imageurl");
        String description = request.getParameter("description");
        productService.update(new Product(oldId, name, price, url, description));
        response.sendRedirect("/suppliers?idShop=" + idShop);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String imageurl = request.getParameter("imageurl");
        String description = request.getParameter("description");
        productService.addInShop(new Product(0, name, price,imageurl,description), idShop);
        String nameShop = shopService.findById(idShop).getName();
        List<Product> products = productService.findAllByShop(idShop);
        request.setAttribute("nameShop", nameShop);
        request.setAttribute("idShop", idShop);
        request.setAttribute("products", products);
        request.getRequestDispatcher("supplier/home.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id,idShop);
        response.sendRedirect("suppliers?idShop=" + idShop);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showCreateForm":
                showCreateForm(request, response);
                break;
            case "editForm":
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
        boolean notEmpty = false;
        while (request.getParameter("id" + index) != null) {
            quantityCur = Integer.parseInt(request.getParameter("quantity" + index));
            if (quantityCur == 0) {
                index++;
                continue;
            }
            notEmpty = true;
            idCur = Integer.parseInt(request.getParameter("id" + index));
            nameCur = request.getParameter("name" + index);
            priceCur = Double.parseDouble(request.getParameter("price" + index));
            CartItem cartItem = new CartItem(idCur, nameCur, priceCur, quantityCur);
            cart.add(cartItem);
            index++;
        }
        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        request.setAttribute("idShop", idShop);
        request.setAttribute("idAccount", idAccount);
        request.setAttribute("nameShop", request.getParameter("nameShop"));
        if (notEmpty) {
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("product/cart.jsp").forward(request, response);
        } else {
            request.setAttribute("username", accService.findById(idAccount).getUsername());
            request.setAttribute("products", productService.findAllByShop(idShop));
            request.setAttribute("msg", "Tăng số lượng sp đi cháu");
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("EditProduct", product);
        request.setAttribute("idShop", idShop);
        request.setAttribute("id", id);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        request.setAttribute("idShop", idShop);
        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products;
        int idShop = Integer.parseInt(request.getParameter("idShop"));
        String nameShop = shopService.findById(idShop).getName();
        if (request.getParameter("opt") != null) {
            String productPattern = request.getParameter("product");
            products = productService.findAllByShopFiltered(idShop, productPattern);
        } else {
            products = productService.findAllByShop(idShop);
        }
        request.setAttribute("nameShop", nameShop);
        request.setAttribute("idShop", idShop);
        request.setAttribute("products", products);
        request.setAttribute("idAccount", request.getParameter("idAccount"));
        String supplier = request.getParameter("supplier");
        if (supplier == null) {
            supplier = "";
        }
        if (supplier.equals("true")) {
            request.getRequestDispatcher("supplier/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("product/list.jsp").forward(request, response);
        }
    }
}
