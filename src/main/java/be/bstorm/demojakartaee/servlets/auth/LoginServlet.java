package be.bstorm.demojakartaee.servlets.auth;

import be.bstorm.demojakartaee.entities.User;
import be.bstorm.demojakartaee.models.dtos.UserDTO;
import be.bstorm.demojakartaee.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = userService.Login(username, password);
            req.getSession(true).setAttribute("currentUser", UserDTO.fromUser(user));
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
    }
}
