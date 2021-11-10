package nl.florus.novi.huiswerk_assignment1springboot082021.Controllers;

import nl.florus.novi.huiswerk_assignment1springboot082021.Exceptions.RecordNotFoundException;
import org.apache.coyote.Response;
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
