package pergamum.library;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getBooks(){
        List<Book> books = bookRepository.findAll(Sort.by("author").ascending().and(Sort.by("title")));
       // List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public void createBook(Book book) {
       /* Book existTitle= (Book) bookRepository.findByTitle(book.getTitle()).orElse(null);
        Book existAuthor = (Book) bookRepository.findByAuthor(book.getAuthor()).orElse(null);
        if(existTitle!=null && existAuthor!=null){
            throw new IllegalStateException(String.format("Book already exists"));
        }*/
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book bookToUpdate= bookRepository
                             .findById(id)
                                .orElseThrow(()-> new IllegalStateException(String.format("Book with id %s doesn't exist",id)));

        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookRepository.save(bookToUpdate);
    }
    @Override
    public void deleteBook(Long id){
        boolean bookExists = bookRepository.existsById(id);
        if(!bookExists){
            throw new IllegalStateException(String.format("Book with id %s does not exists",id));
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchBooks(String query){
        List<Book> books = bookRepository.searchBooks(query);
        return books;
    }
}
