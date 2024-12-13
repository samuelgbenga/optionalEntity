package com.samuel.optionalfield.repository;

import com.samuel.optionalfield.dto.BookDto;
import com.samuel.optionalfield.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDtoRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT new com.samuel.optionalfield.dto.BookDto(b.id, b.title, b.author) FROM Book b")
    List<BookDto> fetchBooks();
}
