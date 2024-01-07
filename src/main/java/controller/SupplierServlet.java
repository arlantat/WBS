package controller;

import model.Product;
import service.ProductService;
import service.ShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "supplierServlet", urlPatterns = "/suppliers")
public class SupplierServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShopService shopService = new ShopService();
        ProductService productService = new ProductService();
        int idShop = Integer.parseInt(req.getParameter("idShop"));
        String nameShop = shopService.findById(idShop).getName();
        List<Product> products = productService.findAllByShop(idShop);
        req.setAttribute("nameShop", nameShop);
        req.setAttribute("idShop", idShop);
        req.setAttribute("products", products);
        req.getRequestDispatcher("supplier/home.jsp").forward(req, resp);
    }
}
