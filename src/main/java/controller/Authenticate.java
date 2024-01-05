package controller;

import model.Account;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "authenticate", value = "/authenticate")
public class Authenticate extends HttpServlet {

    private final AccountService accountService = new AccountService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if ("logout".equalsIgnoreCase(action)) {
            handleLogout(request, response);
        } else {
            handleLogin(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String registerUsername = request.getParameter("registerUsername");
        String registerPassword = request.getParameter("registerPassword");

        Account newAccount = new Account(registerUsername, registerPassword, false);
        try {
            if (accountService.add(newAccount)) {
                request.setAttribute("msg", "Đăng ký thành công");
            } else {
                request.setAttribute("msg", "Đã có lỗi xảy ra khi đăng ký");
            }
            request.getRequestDispatcher("quocanh/login.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException("Đã có lỗi xảy ra khi thực hiện đăng ký", e);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Account> accounts = accountService.findAll();

        String loginUsername = request.getParameter("loginUsername");
        String loginPassword = request.getParameter("loginPassword");

        if (accountService.verifyLogin(loginUsername, loginPassword)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedInUser", loginUsername);

            request.setAttribute("accounts", accounts);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("quocanh/login.jsp").forward(request, response);
        }
    }

    private void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        request.getRequestDispatcher("quocanh/login.jsp").forward(request, response);
    }
}
