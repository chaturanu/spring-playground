package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by chaturanu on 2/19/17.
 */
@RestController
@RequestMapping("/book/{book}/chapter")
public class PathVariableController {

    @GetMapping("/{chapter}")
    public String getIndividualParams(@PathVariable String book, @PathVariable String chapter) {
        return String.format("book:%s chapter:%s", book, chapter);
    }

    @GetMapping("/map/{chapter}")
    public String getBookChapter(@PathVariable Map pathVariables) {
        return pathVariables.toString(); // {book="Animal Farm", chapter=20}
    }

    @GetMapping("/object/{chapter}")
    public String getBookChapter(Books books) {
        return String.format("book is %s; chapter is %d", books.getBook(), books.getChapter());
    }


    public static class Books {

        private String book;
        private int chapter;


        public String getBook() {
            return book;

        }

        public void setBook(String book) {
            this.book = book;
        }

        public int getChapter() {
            return chapter;
        }

        public void setChapter(int chapter) {
            this.chapter = chapter;
        }
    }

}
