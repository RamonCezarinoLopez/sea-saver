package br.com.seasaver.aplication.repository;
import br.com.seasaver.aplication.model.ONG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OngRepository  extends JpaRepository<ONG, Long> {
}
