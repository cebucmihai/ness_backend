package pergamum.library;


import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    void createBook(Book book);

    void updateBook(Long id, Book book);
    void deleteBook(Long id);

    List<Book> searchBooks(String query);
}

