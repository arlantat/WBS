package controller;

import model.Account;
import service.AccountService;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

    @WebServlet(name = "authenticate", value = "/authenticate")
public class Authenticate extends HttpServlet {
    protected AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        List<Account> accounts = accountService.findAll();
//        System.out.println(accounts.get(0).getLoginName());
//        System.out.println(accounts.get(0).getHashedPassword());

        String loginUsername = request.getParameter("loginUsername");
        String loginPassword = request.getParameter("loginPassword");
        if (accountService.verifyLogin(loginUsername, loginPassword)) {
            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("accounts.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Sai");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("b");
        String registerUsername = request.getParameter("registerUsername");
        String registerPassword = request.getParameter("registerPassword");
        Account newAccount = new Account(registerUsername, registerPassword, false);
        try {
            if (accountService.add(newAccount)) {
                request.setAttribute("msg", "Đăng nhập thành công");
            } else {
                request.setAttribute("msg", "Sai mật khẩu");
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}