package nl.florus.novi.huiswerk_assignment1springboot082021.Controllers;

import nl.florus.novi.huiswerk_assignment1springboot082021.Model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //attribuut
    private List<Book> book = new ArrayList<>();

    //constructor - Het toevoegen van testwaarden
    public BookController() {
        Book boek1 = new Book();
        boek1.setTitle("Harry Potter");
        boek1.setAuthor("Rowling");
        boek1.setIsbn("12245566");

        book.add(boek1);
    }

    @GetMapping (value ="/books")
    public ResponseEntity<Object> getBooks() {
        return ResponseEntity.ok(book);
    }



}
