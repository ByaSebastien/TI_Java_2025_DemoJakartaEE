package be.bstorm.demojakartaee.models;

import be.bstorm.demojakartaee.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class BookDetailsDTO {

    private String isbn;
    private String title;
    private String author;

    // Mapper
    public static BookDetailsDTO fromBook(Book book) {
        return new BookDetailsDTO(book.getIsbn(), book.getTitle(), book.getAuthor());
    }

//    public Book toBook() {
//        return new Book(this.isbn, title, author, description);
//    }
}
