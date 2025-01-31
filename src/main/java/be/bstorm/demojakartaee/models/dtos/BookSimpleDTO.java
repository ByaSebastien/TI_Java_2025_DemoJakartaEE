package be.bstorm.demojakartaee.models.dtos;

import be.bstorm.demojakartaee.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class BookSimpleDTO {

    private String isbn;
    private String title;
    private String author;
    private String description;

    public static BookSimpleDTO fromBook(Book book) {

//        String description = null;
//
//        if(book.getDescription() != null){
//            description = book.getDescription().length() < 23 ? book.getDescription() : book.getDescription().substring(0, 20) + "...";
//        }

        String description = book.getDescription() == null ? null : book.getDescription().length() < 23 ? book.getDescription() : book.getDescription().substring(0, 20) + "...";


        return new BookSimpleDTO(
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                description
        );
    }
}
