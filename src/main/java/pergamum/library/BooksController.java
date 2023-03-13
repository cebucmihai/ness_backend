package pergamum.library;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path="/library/books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }
    @PutMapping(path="{id}")
    public void updateBook(@PathVariable Long id,@RequestBody Book book){
        bookService.updateBook(id,book);
    }
    @DeleteMapping(path="{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam("query") String query){
        return ResponseEntity.ok(bookService.searchBooks(query));
    }
}
