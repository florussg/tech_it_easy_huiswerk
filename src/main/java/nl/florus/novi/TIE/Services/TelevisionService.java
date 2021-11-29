package nl.florus.novi.TIE.Services;

import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class TelevisionService {

    //connectie tussen service en repository
    @Autowired
    private TelevisionRepository televisionRepository;


    public Iterable<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    //Geeft een object television terug, vandaar de "public Television"
    public Television getOneTelevision (@PathVariable Long id) {
        return televisionRepository.findById(id);


    }

    //Via Postman 1 televisie toevoegen aan de database
    @PostMapping(value = "/televisions/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addTelevision (@RequestBody Television television) {
        Television newTelevision = televisionRepository.save(television);
        Long newId = newTelevision.getId();

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
    //WERKT MOMENTEEL NIET. ZIE LES 18-11-2021 37-38 MINUTEN
    @PatchMapping (value = "/televisions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> partialChangeTelevision(@PathVariable Long id, @RequestBody Television television) {
        Television excistingTelevision = televisionRepository.findById(id).orElse(null);

        if (!television.getName().isEmpty()) {
            excistingTelevision.setName(television.getName());
        } else
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





//functie om 1 televisie op te halen

    //functie om alle televisies op te halen

    //functie opslaan van 1 televisie

    //functie verwijderen van 1 televisie

    //functie voor het updaten van 1 televisie




}
