package com.example.booktracker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book  {
    private Integer id;
    private String title;
    private String author;
    private int year;
    private int pages;
}