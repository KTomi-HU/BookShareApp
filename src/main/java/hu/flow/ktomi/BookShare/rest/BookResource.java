package hu.flow.ktomi.BookShare.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.flow.ktomi.BookShare.persistence.model.Book;
import hu.flow.ktomi.BookShare.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class BookResource {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{title}")
    List<Book> findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @PostMapping
    Book addBook(@RequestBody Book data) {
        return bookService.addBook(data);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
