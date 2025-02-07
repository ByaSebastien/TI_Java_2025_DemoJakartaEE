package be.bstorm.demojakartaee.filters;

import be.bstorm.demojakartaee.entities.User;
import be.bstorm.demojakartaee.models.dtos.UserDTO;
import be.bstorm.demojakartaee.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Inject
    private UserService userService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = null;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("currentUser") != null) {
            UserDTO sessionUser = (UserDTO) session.getAttribute("currentUser");
            user = userService.loadUserByUsername(sessionUser.getUsername());
        }

        if(isNotAuthenticatedRoute(uri)){
            if(user == null){
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/");
            }
            return;
        }

        if(isAuthenticatedRoute(uri)){
            if(user != null){
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
            return;
        }

        if(isAdminRoute(uri)){
            if(user != null && user.getRole().equals("admin")){
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
            return;
        }

        filterChain.doFilter(req, resp);
    }

    private boolean isAdminRoute(String uri) {
        return uri.startsWith("/admin");
    }

    private boolean isAuthenticatedRoute(String uri) {
        return uri.equals("/logout");
    }

    private boolean isNotAuthenticatedRoute(String uri) {
        return uri.equals("/login") || uri.equals("/register");
    }
}
