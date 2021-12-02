package nl.florus.novi.TIE.Services;

import nl.florus.novi.TIE.Exceptions.RecordNotFoundException;
import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class TelevisionService {

    //connectie tussen service en repository
    @Autowired
    private TelevisionRepository televisionRepository;

    public Iterable<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    //Geeft 1 object television terug, vandaar de "public Television"
    public Television getOneTelevision (Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if(optionalTelevision.isPresent()) {
            return optionalTelevision.get();
        }
        else { throw new RecordNotFoundException("ID bestaat niet");}
    }

    public Long addTelevision (Television television) {
        Television newTelevision = televisionRepository.save(television);
        Long newId = newTelevision.getId();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return newTelevision.getId() ;
    }

    //Via Postman 1 televisie verwijderen uit de database
    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public void alterTelevision(@PathVariable Long id, @RequestBody Television television) {
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

    }

    public void partialChangeTelevision(@PathVariable Long id, @RequestBody Television television) {
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

    }
}







