package hu.flow.ktomi.BookShare.service;

import hu.flow.ktomi.BookShare.exceptions.idValidationException;
import hu.flow.ktomi.BookShare.persistence.model.Book;
import hu.flow.ktomi.BookShare.persistence.repository.BookRepository;
import hu.flow.ktomi.BookShare.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book addBook(Book book) {
        if (book.getBookId() != null) {
            throw new idValidationException();
        }
        userRepository.save(book.getOwner());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
