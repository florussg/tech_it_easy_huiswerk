package nl.florus.novi.TIE.Repositories;
import nl.florus.novi.TIE.Models.CiModule;
import nl.florus.novi.TIE.Models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteControllerRepository extends JpaRepository <RemoteController, Long> {

    Iterable<RemoteController> findAllByName(String Name);
    Iterable<RemoteController> findAllByNameContainingIgnoreCase(String Name);

}


