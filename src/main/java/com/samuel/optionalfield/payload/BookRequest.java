package com.samuel.optionalfield.payload;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {


    private String title;


    private String author;


    private String synopsis;


    private String language;

}
