package br.com.seasaver.aplication.repository;
import br.com.seasaver.aplication.model.Partnership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnershipRepository extends JpaRepository<Partnership, Long>  {
}
