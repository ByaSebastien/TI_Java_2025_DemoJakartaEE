package be.bstorm.demojakartaee.servlets.book;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.models.dtos.BookDetailsDTO;
import be.bstorm.demojakartaee.services.BookService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.NoSuchElementException;

@WebServlet(value = "/book/details")
public class BookDetailsServlet extends HttpServlet {

    @Inject
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String isbn = req.getParameter("isbn");

        try {

            Book book = bookService.findByIsbn(isbn);
            BookDetailsDTO dto = BookDetailsDTO.fromBook(book);
            req.setAttribute("book", dto);
            req.getRequestDispatcher("/pages/bookDetails.jsp").forward(req, resp);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }


}
