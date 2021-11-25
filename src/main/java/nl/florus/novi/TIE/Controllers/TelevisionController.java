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

    //Via Postman 1 televisie verwijderen uit de ArrayList
    @DeleteMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        televisions.remove(id);
        return ResponseEntity.noContent().build();
    }

    //Via Postman 1 televisie object toevoegen aan televisions ArrayList
    @PostMapping(value = "/televisions/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTelevision (@RequestBody Television television) {
        televisions.add(television);
        int newId = televisions.size() -1;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    //De PUT request die de waarde van een televisie volledig veranderd via Postman
    @PutMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity alterTelevision(@PathVariable int id, @RequestBody Television television) {
        televisions.set(id, television);
        return ResponseEntity.noContent().build();
    }

    //De PATCH request die de waarde van een televisie gedeelterlijk veranderd via Postman
    // LET OP: Is niet compleet afgemaakt. Om deze af te maken werk je met if statements om te kijken of de waarde die mee wordt gegeven leeg is of niet
    @PatchMapping(value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity alterTelevisionpartial(@PathVariable int id, @RequestBody Television television) {
        televisions.set(id, television);
        return ResponseEntity.noContent().build();
    }
}
