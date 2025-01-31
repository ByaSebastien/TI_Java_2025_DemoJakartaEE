package be.bstorm.demojakartaee.servlets.book;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.services.BookService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/book/update")
public class BookUpdateServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String isbn = req.getParameter("isbn");

        Book book = bookService.findByIsbn(isbn);

        req.setAttribute("book", book);

        req.getRequestDispatcher("/pages/bookUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        String id = req.getParameter("id");

        Book book = new Book(isbn, title, author, description);
        bookService.update(id,book);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
