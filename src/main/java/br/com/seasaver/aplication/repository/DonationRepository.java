package br.com.seasaver.aplication.repository;
import br.com.seasaver.aplication.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DonationRepository extends JpaRepository<Donation, Long> {

}
