package br.com.seasaver.aplication.repository;

import br.com.seasaver.aplication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>  {


}
