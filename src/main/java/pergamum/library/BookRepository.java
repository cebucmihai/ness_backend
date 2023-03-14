package pergamum.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    

  //  Optional<Object> findByTitle(String title);

   // Optional<Object> findByAuthor(String author);
    @Query("SELECT b FROM Book b WHERE " +
            "b.title LIKE CONCAT('%',:query,'%')")
    List<Book> searchBooks(String query);

}
