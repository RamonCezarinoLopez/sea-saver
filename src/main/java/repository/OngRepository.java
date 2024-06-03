package repository;
import model.ONG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OngRepository  extends JpaRepository<ONG, Long> {
}
