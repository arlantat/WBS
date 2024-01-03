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
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException throwAbles) {
                    throwAbles.printStackTrace();
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


    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        accService.add(new Acc(0, name, password));
        response.sendRedirect("/home");
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
            default:
                showList(request, response);
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

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Acc> accs = accService.findAll();
        request.setAttribute("ds", accs);
        request.getRequestDispatcher("acc/list.jsp").forward(request, response);
    }
}
