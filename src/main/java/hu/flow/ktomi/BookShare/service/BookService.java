package hu.flow.ktomi.BookShare.service;

import hu.flow.ktomi.BookShare.exceptions.idValidationException;
import hu.flow.ktomi.BookShare.persistence.model.Book;
import hu.flow.ktomi.BookShare.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

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
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
