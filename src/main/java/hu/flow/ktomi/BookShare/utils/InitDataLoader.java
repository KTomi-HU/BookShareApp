package hu.flow.ktomi.BookShare.utils;

import hu.flow.ktomi.BookShare.persistence.model.Book;
import hu.flow.ktomi.BookShare.persistence.model.User;
import hu.flow.ktomi.BookShare.persistence.repository.BookRepository;
import hu.flow.ktomi.BookShare.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class InitDataLoader {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(User.builder().userName("Tomi").build());
        userRepository.save(User.builder().userName("Evelin").build());

        bookRepository.save(Book.builder().title("Dune").authorFname("Frank").authorLname("Herbert").isAtHome(true).build());
        bookRepository.save(Book.builder().title("1984").authorFname("George").authorLname("Orwell").isAtHome(true).build());
        bookRepository.save(Book.builder().title("Alapítvány").authorFname("Isaac").authorLname("Asimov").isAtHome(true).build());
        bookRepository.save(Book.builder().title("Szép új világ").authorFname("Aldous").authorLname("Huxley").isAtHome(true).build());
    }
}
