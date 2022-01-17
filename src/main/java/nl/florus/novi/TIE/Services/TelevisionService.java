package nl.florus.novi.TIE.Services;

import nl.florus.novi.TIE.Dtos.TelevisionInputDto;
import nl.florus.novi.TIE.Exceptions.BadRequestException;
import nl.florus.novi.TIE.Exceptions.RecordNotFoundException;
import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    //connectie tussen service en repository
    @Autowired
    private TelevisionRepository televisionRepository;

    public Iterable<Television> getAllTelevisions(String uniquename) {
        if (uniquename.isEmpty()) {
            return televisionRepository.findAll();
        }
        else {
            return televisionRepository.findAllByUniqueNameContainingIgnoreCase(uniquename);
        }
    }

    //Geeft 1 object television terug, vandaar de "public Television"
    public Television getOneTelevision(Long id) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isPresent()) {
            return optionalTelevision.get();
        } else {
            throw new RecordNotFoundException("ID bestaat niet");
        }
    }

    public Long addTelevision(TelevisionInputDto televisionInputDto) {
        String uniqueName = televisionInputDto.getUniqueName();
        List<Television> televisions = (List<Television>) televisionRepository.findAllByUniqueName(uniqueName);
        if (televisions.size() > 0) {
            throw new BadRequestException("this TV already exists");
        }

        Television newTelevision = new Television();
        newTelevision.setBrand(televisionInputDto.getBrand());
        newTelevision.setType(televisionInputDto.getType());
        newTelevision.setUniqueName(televisionInputDto.getUniqueName());
        newTelevision.setPrice(televisionInputDto.getPrice());

        Television newTelevisionSave = televisionRepository.save(newTelevision);
        return newTelevisionSave.getId();
    }

    //Via Postman 1 televisie verwijderen uit de database
    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public void alterTelevision(@PathVariable Long id, @RequestBody Television television) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

        if (optionalTelevision.isPresent()) {
            Television storedTelevision = optionalTelevision.get();

            television.setId(storedTelevision.getId());

            televisionRepository.save(television);
        }
        else {
            throw new RecordNotFoundException("The television ID does not exist");
        }
    }

    public void partialChangeTelevision(@PathVariable Long id, @RequestBody Television television) {
        Optional<Television> optionalTelevision = televisionRepository.findById(id);

        if (optionalTelevision.isPresent()) {
            Television storedTelevision = televisionRepository.findById(id).orElse(null);


            if (television.getType() != null && !television.getType().isEmpty()) {
                storedTelevision.setType(television.getType());
            }

            if (television.getBrand() != null && !television.getBrand().isEmpty()) {
                storedTelevision.setBrand(television.getBrand());
            }

            if (television.getUniqueName() != null && !television.getUniqueName().isEmpty()) {
                storedTelevision.setUniqueName(television.getUniqueName());
            }

            if (television.getPrice() != null) {
                storedTelevision.setPrice(television.getPrice());
            }

            televisionRepository.save(storedTelevision);
        } else {
            throw new RecordNotFoundException("The television ID does not exist");
        }
    }
}






