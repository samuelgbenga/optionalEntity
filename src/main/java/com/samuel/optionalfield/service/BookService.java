package com.samuel.optionalfield.service;


import com.samuel.optionalfield.dto.BookDto;
import com.samuel.optionalfield.entity.Book;
import com.samuel.optionalfield.payload.BookRequest;
import com.samuel.optionalfield.projections.BookProjection;
import com.samuel.optionalfield.repository.BookDtoRepository;
import com.samuel.optionalfield.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookDtoRepository bookDtoRepository;
    private final ModelMapper modelMapper;


    public String insertBook(BookRequest bookRequest){

//        Book newBook = Book.builder()
//                .author(bookRequest.getAuthor())
//                .language(bookRequest.getLanguage())
//                .title(bookRequest.getTitle())
//                .synopsis(bookRequest.getSynopsis())
//                .build();

        // just testing the model mapper over builder
        Book newBook1 = modelMapper.map(bookRequest, Book.class);

        bookRepository.save(newBook1);

        return "Book inserted successfully!";
    }

    public List<BookProjection> getBookListProjection(){
        return bookRepository.fetchBooks();
    }

    public List<BookDto> getBookListDto(){
        return bookDtoRepository.fetchBooks();
    }

}
