package hu.flow.ktomi.BookShare.persistence.model.dto;

import hu.flow.ktomi.BookShare.persistence.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BookDTO {

    private Long bookId;
    private Long userId;
    private String title;
    private String authorFname;
    private String authorLname;
    private String blurb;
    private boolean isAtHome;

    public void bookDTOFromBook(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
        this.authorFname = book.getAuthorFname();
        this.authorLname = book.getAuthorLname();
        this.blurb = book.getBlurb();
        this.isAtHome = book.isAtHome();
        if (book.getOwner() != null) {
            this.userId = book.getOwner().getId();
        } else this.userId = null;
    }

}
