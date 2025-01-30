package be.bstorm.demojakartaee.servlets;

import be.bstorm.demojakartaee.entities.Book;
import be.bstorm.demojakartaee.models.BookSimpleDTO;
import be.bstorm.demojakartaee.repositories.BookRepository;
import be.bstorm.demojakartaee.repositories.impls.BookRepositoryImpl;
import be.bstorm.demojakartaee.services.BookService;
import be.bstorm.demojakartaee.services.impls.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/",loadOnStartup = 1)
public class BookIndexServlet extends HttpServlet {

    private final BookService bookService;

    public BookIndexServlet() {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = bookService.findAll();

//        List<BookSimpleDTO> dtos = new ArrayList<>();
//        for (Book book : books) {
//            dtos.add(BookSimpleDTO.fromBook(book));
//        }

        List<BookSimpleDTO> dtos = books.stream()
                .map(b -> BookSimpleDTO.fromBook(b))
                .collect(Collectors.toList());

        req.setAttribute("books", dtos);

        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}
