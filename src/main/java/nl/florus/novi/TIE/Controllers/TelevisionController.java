package nl.florus.novi.TIE.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    //attribuut
    private List<String> television = new ArrayList<>();

    //constructor - Het toevoegen van testwaarden
    public TelevisionController() {
        television.add("test");
        television.add("test 2");
    }

    //Via postmen de waarde van alle televisies terug krijgen
    @GetMapping (value = "/televisions")
    @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<List<String>> getAllTelevisions() {
        //public List<String> getAllTelevisions() {
        //return television;
        return ResponseEntity.ok().body(television);
    }


    //Via Postman de waarde van 1 televisie terug krijgen
    @GetMapping (value = "/televisions/{id}")
    public String getOneTelevision (@PathVariable int id) {
//        if (television.contains(id)) {
            return television.get(id);
//        } else throw new RecordNotFoundException("ID can not be found");
    }

    //Via Postman 1 televisie toevoegen aan de ArrayList
    @PostMapping(value = "/televisions")
    public String addTelevision (@RequestBody String nametelevision) {
        television.add(nametelevision);
        return "added";
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
