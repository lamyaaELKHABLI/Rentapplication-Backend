package com.rentapplication.rentapplication;

import com.rentapplication.rentapplication.test.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@SpringBootApplication
public class RentapplicationApplication {

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return Stream.of(new Book(101, "Javas" , 999),
                new Book(11, "SS" , 9898798),
                new Book(12, "sdsd" , 10)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        SpringApplication.run(RentapplicationApplication.class, args);
    }
}
