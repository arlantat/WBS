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

    @WebServlet(name = "SupplierServlet", urlPatterns = "/supplier")
    public class supplierSelvet extends HttpServlet {
        ShopService shopService = new ShopService();
        ProductService productService = new ProductService();
        AccService accService = new AccService();

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {

                default:
                    showList(req, resp);
            }
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

        private void showList(HttpServletRequest req, HttpServletResponse resp) {
        }


    }
