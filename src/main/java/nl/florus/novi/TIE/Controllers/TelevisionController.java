package nl.florus.novi.TIE.Controllers;

import nl.florus.novi.TIE.Dtos.TelevisionInputDto;
import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
public class TelevisionController {

    @Autowired
    private TelevisionService televisionService;

    //constructor - Het toevoegen van testwaarden
//    public TelevisionController() {
//        Television televisie1 = new Television("Samsung", "A123", "test");
//        Television televisie2 = new Television("LG", "B987", "LG B987 4K");
//
//        Television newTv = new Television();
//        newTv.setBrand("Apple");
//        newTv.setType("telly");
//        newTv.setUniqueName("Best Telly Ever");
//    }

    //Via postmen de waarde van alle televisies terug krijgen uit de database
    @GetMapping (value = "/televisions")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(televisionService.getAllTelevisions());
    }

    //Via Postman de waarde van 1 televisie terug krijgen uit de database
    @GetMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getOneTelevision (@PathVariable Long id) {
        return ResponseEntity.ok(televisionService.getOneTelevision(id));
    }

    //Via Postman 1 televisie toevoegen aan de database
    @PostMapping(value = "/televisions/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTelevision (@Valid @RequestBody TelevisionInputDto television) {

        Long newId = televisionService.addTelevision(television);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    //Via Postman 1 televisie verwijderen uit de database
    @DeleteMapping (value = "/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    //De PUT request die de volledige waarden van een bestaande televisie veranderd via Postman
    @PutMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> alterTelevision(@PathVariable Long id, @RequestBody Television television) {

        televisionService.alterTelevision(id, television);
        return ResponseEntity.noContent().build();
    }

    //De PATCH request die een gedeeltelijke waarde van een bestaande televisie veranderd via Postman
    //WERKT MOMENTEEL NIET. ZIE LES 18-11-2021 37-38 MINUTEN
    @PatchMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> partialChangeTelevision(@PathVariable Long id, @RequestBody Television television) {

        televisionService.partialChangeTelevision(id, television);
        return ResponseEntity.noContent().build();
    }
}



