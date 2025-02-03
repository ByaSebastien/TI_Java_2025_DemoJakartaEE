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

@WebServlet("/admin/book/create")
public class BookCreateServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/bookCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String isbn = req.getParameter("isbn");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String description = req.getParameter("description");

//        BookForm bookForm = new BookForm(isbn, title, author, description);
//        bookService.save(bookForm.toBook());

        Book book = new Book(isbn, title, author, description);
        bookService.save(book);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
