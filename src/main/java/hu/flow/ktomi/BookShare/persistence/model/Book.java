package hu.flow.ktomi.BookShare.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private boolean isAtHome; // indicates if the book is borrowed at the moment or not

    public Long getBookId() {
        return bookId;
    }

    @ManyToOne
    @JoinColumn
    private User owner;

    @OneToOne
    private User borrower;
}
