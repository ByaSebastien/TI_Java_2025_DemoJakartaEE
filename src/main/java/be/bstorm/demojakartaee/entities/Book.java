package be.bstorm.demojakartaee.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
@Entity
public class Book {

    @Getter @Setter
    @Id
    private String isbn;

    @Getter @Setter
    @Column(unique = true,nullable = false,length = 50)
    private String title;

    @Getter @Setter
    @Column(nullable = false,length = 50)
    private String author;

    @Getter @Setter
    @Column
    private String description;
}
