package controller;

import model.Acc;
import service.AccService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccServlet", urlPatterns = "/accounts")
public class AccServlet extends HttpServlet {
    AccService accService = new AccService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
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

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        accService.update(new Acc(username, password));
        response.sendRedirect("/Blogs");
    }


    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (accService.add(new Acc(username, password))) {
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            request.setAttribute("msg", "Tồn tại tên đăng nhập");
            request.getRequestDispatcher("auth/register.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        accService.delete(id);
        response.sendRedirect("/home");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "create":
                showCreateForm(request, response);
                break;
            case "editForm":
                editForm(request, response);
                break;
            case "showList":
                showList(request, response);
                break;
            default:
                try {
                    verify(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Acc acc = new Acc();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("acc/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        acc = accService.findById(id);
        request.setAttribute("Edit", acc);
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("acc/create.jsp").forward(request, response);
    }

    private void verify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(password);
        Acc acc = new Acc(username, password);
        if (accService.verify(acc)) {
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            request.setAttribute("msg", "Sai, mời đăng nhập lại");
            request.getRequestDispatcher("auth/login.jsp").forward(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Acc> accs = accService.findAll();
        request.setAttribute("accs", accs);
        request.getRequestDispatcher("admin/accounts.jsp").forward(request, response);
    }
}
