package be.bstorm.demojakartaee.models.forms;

import be.bstorm.demojakartaee.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class BookForm {

    private String isbn;
    private String title;
    private String author;
    private String description;

    public Book toBook() {
        return new Book(
                this.isbn,
                this.title,
                this.author,
                this.description
        );
    }
}
