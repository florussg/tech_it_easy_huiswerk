package nl.florus.novi.TIE.Controllers;

import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.TelevisionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;


@RestController
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    //constructor - Het toevoegen van testwaarden
    public TelevisionController() {
        Television televisie1 = new Television("Samsung", "A123", "Samsung A123 Oled");
        Television televisie2 = new Television("LG", "B987", "LG B987 4K");

        Television newTv = new Television();
        newTv.setBrand("Apple");
        newTv.setType("telly");
        newTv.setName("Best Telly Ever");
    }

    //Via postmen de waarde van alle televisies terug krijgen uit de database
    @GetMapping (value = "/televisions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(televisionRepository.findAll());
    }

    //Via Postman de waarde van 1 televisie terug krijgen uit de database
    @GetMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOneTelevision (@PathVariable Long id) {
        return ResponseEntity.ok(televisionRepository.findById(id));
    }

    //Via Postman 1 televisie toevoegen aan de database
    @PostMapping(value = "/televisions/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTelevision (@RequestBody Television television) {
        Television newTelevision = televisionRepository.save(television);
        Long newId = television.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

    //Via Postman 1 televisie verwijderen uit de database
    @DeleteMapping (value = "/televisions/{id}")
    public String deleteTelevision(@PathVariable Long id) {
        televisionRepository.deleteById(id);
        return "deleted";
    }
    //De PUT request die de volledige waarden van een bestaande televisie veranderd via Postman
    @PutMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> alterTelevision(@PathVariable Long id, @RequestBody Television television) {
        Television excistingTelevision = televisionRepository.findById(id).orElse(null);

        if (!television.getName().isEmpty()) {
            excistingTelevision.setName(television.getName());
        }
        if (!television.getBrand().isEmpty()) {
            excistingTelevision.setBrand(television.getBrand());
        }
        if (!television.getType().isEmpty()) {
            excistingTelevision.setType(television.getType());
        }
        televisionRepository.save(excistingTelevision);

        return ResponseEntity.noContent().build();
    }

    //De PATCH request die een gedeeltelijke waarde van een bestaande televisie veranderd via Postman
    @PatchMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> partialChangeTelevision(@PathVariable Long id, @RequestBody Television television) {
        Television excistingTelevision = televisionRepository.findById(id).orElse(null);

        if (!television.getName().isEmpty()) {
            excistingTelevision.setName(television.getName());
        }
        if (!television.getBrand().isEmpty()) {
            excistingTelevision.setBrand(television.getBrand());
        }
        if (!television.getType().isEmpty()) {
            excistingTelevision.setType(television.getType());
        }
        televisionRepository.save(excistingTelevision);

        return ResponseEntity.noContent().build();
    }
}



