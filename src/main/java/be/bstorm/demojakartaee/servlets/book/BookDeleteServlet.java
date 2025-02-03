package be.bstorm.demojakartaee.servlets.book;

import be.bstorm.demojakartaee.services.BookService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/book/delete")
public class BookDeleteServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String isbn = req.getParameter("isbn");

        bookService.deleteByIsbn(isbn);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
