package com.samuel.optionalfield.controller;

import com.samuel.optionalfield.payload.BookRequest;
import com.samuel.optionalfield.projections.BookProjection;
import com.samuel.optionalfield.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping("/")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok("Hello world");
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody BookRequest bookRequest){

        String result = bookService.insertBook(bookRequest);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getBook(){
        return ResponseEntity.ok(bookService.getBookListProjection());
    }

    @GetMapping("/getfromdto")
    public ResponseEntity<?> getBookDto(){
        return ResponseEntity.ok(bookService.getBookListDto());
    }

}
