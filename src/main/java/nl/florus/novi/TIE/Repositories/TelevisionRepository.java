package nl.florus.novi.TIE.Repositories;
import nl.florus.novi.TIE.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    Iterable<Television> findAllByUniqueName(String uniqueName);
    Iterable<Television> findAllByUniqueNameContainingIgnoreCase(String uniqueName);
}

