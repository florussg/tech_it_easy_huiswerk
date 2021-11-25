package nl.florus.novi.TIE.Controllers;

import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.TelevisionRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    //attribuut
    private List<Television> televisions = new ArrayList<>();

    //constructor - Het toevoegen van testwaarden
    public TelevisionController() {
        Television televisie1 = new Television("Samsung", "A123", "Samsung A123 Oled");
        Television televisie2 = new Television("LG", "B987", "LG B987 4K");
        televisions.add(televisie1);
        televisions.add(televisie2);
    }

    //Via postmen de waarde van alle televisies terug krijgen
    @GetMapping (value = "/televisions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(televisions);
    }

    //Via Postman de waarde van 1 televisie terug krijgen
    @GetMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOneTelevision (@PathVariable int id) {
        return ResponseEntity.ok(televisions.get(id));
    }

    //Via Postman 1 televisie toevoegen aan de ArrayList
    @PostMapping(value = "/televisions/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTelevision (@RequestBody Television television) {
        televisions.add(television);
        int newId = televisions.size() -1;
        Television newTelevision = TelevisionRepository.save(television);

        Book newBook = bookRepository.save(book);
        int newId = book.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
    }


    //Via Postman 1 televisie verwijderen uit de ArrayList
    @DeleteMapping (value = "/televisions/{id}")
    public String deleteTelevision(@PathVariable int id) {
        television.remove(id);
        return "deleted";
    }
    //De PUT request die de waarde van een televisie veranderd via Postman
    @PutMapping (value = "/televisions/{id}")
    public String alterTelevision(@PathVariable int id, @RequestBody String televisionname) {
        television.set(id, televisionname);
        return televisionname + " has been succesfully replaced at id-number: " + id;
            }
}


//@RestController
//public class BookController {
//
//    //attribuut
//    private List<Book> book = new ArrayList<>();
//
//    //constructor - Het toevoegen van testwaarden
//    public BookController() {
//        Book boek1 = new Book();
//        boek1.setTitle("Harry Potter");
//        boek1.setAuthor("Rowling");
//        boek1.setIsbn("12245566");
//
//        book.add(boek1);
//    }
//
//    @GetMapping (value ="/books")
//    public ResponseEntity<Object> getBooks() {
//        return ResponseEntity.ok(book);
//    }
//
//
//
//}
