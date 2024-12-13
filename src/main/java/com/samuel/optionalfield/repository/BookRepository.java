package com.samuel.optionalfield.repository;

import com.samuel.optionalfield.entity.Book;
import com.samuel.optionalfield.projections.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.id as id, b.title, b.author FROM Book b", nativeQuery = true)
    List<BookProjection> fetchBooks();
}
