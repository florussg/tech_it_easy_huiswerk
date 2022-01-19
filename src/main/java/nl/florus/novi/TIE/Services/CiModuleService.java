package nl.florus.novi.TIE.Services;

import nl.florus.novi.TIE.Dtos.CiModuleDto;
import nl.florus.novi.TIE.Exceptions.BadRequestException;
import nl.florus.novi.TIE.Models.CiModule;
import nl.florus.novi.TIE.Models.Television;
import nl.florus.novi.TIE.Repositories.CiModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CiModuleService {

    //connectie tussen service en repository
    @Autowired
    private CiModuleRepository ciModuleRepository;


    public Long addCiModule(CiModuleDto ciModuleDto) {
        String Name = ciModuleDto.getName();
        List<CiModule> ciModule = (List<CiModule>) ciModuleRepository.findAllByUniqueName(Name);
        if (ciModule.size() > 0) {
            throw new BadRequestException("this CiModule already exists");
        }

        CiModule newCiModule = new CiModule();

        newCiModule.setName(ciModuleDto.getName());
        newCiModule.setType(ciModuleDto.getType());
        newCiModule.setPrice(ciModuleDto.getPrice());

        CiModule newCiModuleSave = ciModuleRepository.save(newCiModule);
        return newCiModuleSave.getId();
    }



}
