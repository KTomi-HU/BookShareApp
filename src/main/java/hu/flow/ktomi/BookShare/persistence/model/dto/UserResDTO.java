package hu.flow.ktomi.BookShare.persistence.model.dto;

import hu.flow.ktomi.BookShare.persistence.model.Book;
import hu.flow.ktomi.BookShare.persistence.model.Role;
import hu.flow.ktomi.BookShare.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserResDTO {

    private Long id;
    private String userFirstName;
    private String userLastName;
    private String userName;
    private String email;
    private LocalDate birthDate;
    private Role role;
    private List<String> books;


    public UserResDTO(User user) {
        this.id = user.getId();
        this.userFirstName = user.getUserFirstName();
        this.userLastName = user.getUserLastName();
        this.userName = user.getUsername();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.role = user.getRole();
        if (user.getBooks() == null) {
            this.books = null;
        } else {
            this.books = user.getBooks()
                    .stream().map(x -> x.getTitle()
                            + ", written by:"
                            + " " + x.getAuthorFname()
                            + " " + x.getAuthorLname()
                            + ", rated to " + x.getRating() + " stars"
                            + ", Owner: " + x.getOwner()).collect(Collectors.toList());

        }
    }
}
