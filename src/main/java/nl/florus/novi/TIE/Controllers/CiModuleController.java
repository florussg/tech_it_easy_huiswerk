package nl.florus.novi.TIE.Controllers;

import nl.florus.novi.TIE.Dtos.CiModuleDto;
import nl.florus.novi.TIE.Services.CiModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

public class CiModuleController {

    @Autowired
    private CiModuleService ciModuleService;

    //Via Postman 1 CiModule toevoegen aan de database
    @PostMapping(value = "/cimodule/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addCiModule (@Valid @RequestBody CiModuleDto ciModule) {

        long newId = ciModuleService.addCiModule(ciModule);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }
}
