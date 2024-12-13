package com.samuel.optionalfield;

import com.samuel.optionalfield.dto.BookDto;
import com.samuel.optionalfield.entity.Book;
import com.samuel.optionalfield.projections.BookProjection;
import com.samuel.optionalfield.repository.BookDtoRepository;
import com.samuel.optionalfield.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("h2")
@SpringBootTest(classes = OptionalfieldApplication.class)
@Transactional
class OptionalfieldApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookDtoRepository bookDtoRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenUseProjection_thenFetchOnlyProjectionAttributes() {
		String title = "Title Projection";
		String author = "Author Projection";

		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		bookRepository.save(book);

		List<BookProjection> result = bookRepository.fetchBooks();

		assertEquals(1, result.size());
		assertEquals(title, result.get(0).getTitle());
		assertEquals(author, result.get(0).getAuthor());
	}

	@Test
	public void whenUseDto_thenFetchOnlyDtoAttributes() {
		String title = "Title Dto";
		String author = "Author Dto";

		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		bookDtoRepository.save(book);

		List<BookDto> result = bookDtoRepository.fetchBooks();

		assertEquals(1, result.size());
		assertEquals(title, result.get(0).title());
		assertEquals(author, result.get(0).author());
	}

}
