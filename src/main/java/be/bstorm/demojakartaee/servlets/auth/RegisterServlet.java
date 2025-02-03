package be.bstorm.demojakartaee.servlets.auth;

import be.bstorm.demojakartaee.entities.User;
import be.bstorm.demojakartaee.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try{
            userService.Register(new User(username, password,null));
            resp.sendRedirect(req.getContextPath() + "/login");
        }catch (Exception e){
            System.out.println(e.getMessage());
            req.getRequestDispatcher("/pages/register.jsp").forward(req, resp);
        }
    }
}
