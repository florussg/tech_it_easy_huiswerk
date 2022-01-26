package nl.florus.novi.TIE.Controllers;

import nl.florus.novi.TIE.Dtos.RemoteControllerDto;
import nl.florus.novi.TIE.Dtos.TelevisionInputDto;
import nl.florus.novi.TIE.Services.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class RemoteControllerController {

    @Autowired
    private RemoteControllerService remoteControllerService;

    //Via Postman 1 remotecontroller toevoegen aan de database
    @PostMapping(value = "/remotecontroller/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addRemoteController (@Valid @RequestBody RemoteControllerDto remoteController) {

        Long newId = remoteControllerService.addRemoteController(remoteController);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping (value = "/remotecontrollers")
    public ResponseEntity<Object> getAllRemoteControllers (@Valid @RequestParam(name="name", defaultValue = "") String name) {
        return ResponseEntity.ok(remoteControllerService.getAllRemoteControllers(name));
    }

}
