package nl.florus.novi.TIE.Services;

import nl.florus.novi.TIE.Dtos.RemoteControllerDto;
import nl.florus.novi.TIE.Exceptions.BadRequestException;
import nl.florus.novi.TIE.Models.CiModule;
import nl.florus.novi.TIE.Models.RemoteController;
import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.RemoteControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControllerService {

    @Autowired
    private RemoteControllerRepository remoteControllerRepository;

    public Iterable<RemoteController> getAllRemoteControllers(String name) {
        if (name.isEmpty()) {
            return remoteControllerRepository.findAll();
        }
        else {
            return remoteControllerRepository.findAllByNameContainingIgnoreCase(name);
        }
    }

    public Long addRemoteController(RemoteControllerDto remoteControllerDto) {
        String Name = remoteControllerDto.getName();
        List<RemoteController> remotecontroller = (List<RemoteController>) remoteControllerRepository.findAllByName(Name);
        if (remotecontroller.size() > 0) {
            throw new BadRequestException("this Remote Controller already exists");
        }

        RemoteController newRemoteController = new RemoteController();

        newRemoteController.setId(remoteControllerDto.getId());
        newRemoteController.setCompatibleWith(remoteControllerDto.getCompatibleWith());
        newRemoteController.setBatteryType(remoteControllerDto.getBatteryType());
        newRemoteController.setName(remoteControllerDto.getName());
        newRemoteController.setBrand(remoteControllerDto.getBrand());
        newRemoteController.setPrice(remoteControllerDto.getPrice());
        newRemoteController.setOriginalStock(remoteControllerDto.getOriginalStock());

        RemoteController newRemoteControllerSave = remoteControllerRepository.save(newRemoteController);
        return newRemoteControllerSave.getId();
    }
}
