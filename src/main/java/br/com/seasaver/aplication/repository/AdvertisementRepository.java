package br.com.seasaver.aplication.repository;
import br.com.seasaver.aplication.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
