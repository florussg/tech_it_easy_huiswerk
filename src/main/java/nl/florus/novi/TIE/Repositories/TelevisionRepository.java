package nl.florus.novi.TIE.Repositories;
import nl.florus.novi.TIE.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public class TelevisionRepository {

    public interface BookRepository extends JpaRepository<Integer, Television> {

    }
}
