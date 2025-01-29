package be.bstorm.demojakartaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        System.out.println("----------------------> id : " + id);
        System.out.println("----------------------> name : " + name);

        req.setAttribute("id", id);
        req.setAttribute("name", name);

        req.getRequestDispatcher("/pages/demo.jsp").forward(req, resp);
    }
}
