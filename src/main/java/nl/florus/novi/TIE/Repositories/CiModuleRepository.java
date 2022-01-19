package nl.florus.novi.TIE.Repositories;
import nl.florus.novi.TIE.Models.CiModule;
import nl.florus.novi.TIE.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {

    Iterable<CiModule> findAllByUniqueName(String Name);

}
