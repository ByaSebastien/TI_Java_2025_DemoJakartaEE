package be.bstorm.demojakartaee.servlets;

import be.bstorm.demojakartaee.utils.EmfFactoryUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(value = "/",loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

    public IndexServlet() {
        EmfFactoryUtils.getEmfFactory();
    }
}
