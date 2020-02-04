package hu.flow.ktomi.BookShare.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column
    private String title;

    @Column
    private String authorFname;

    @Column
    private String authorLname;

    @Column
    private String blurb; // a short description of the book

    @Column
    private boolean isAtHome; // indicates if the book is borrowed at the moment

    @Column
    @OneToMany
    private List<Rating> ratings;

    public Long getBookId() {
        return bookId;
    }

    @ManyToOne
    @JoinColumn
    private User owner;

    @OneToOne
    private User borrower;
}
