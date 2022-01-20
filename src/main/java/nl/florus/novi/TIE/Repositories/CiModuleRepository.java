package nl.florus.novi.TIE.Repositories;
import nl.florus.novi.TIE.Models.CiModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {

    Iterable<CiModule> findAllByName(String Name);
    Iterable<CiModule> findAllByNameContainingIgnoreCase(String Name);

}
