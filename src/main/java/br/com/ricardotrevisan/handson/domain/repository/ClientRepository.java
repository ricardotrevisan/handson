package br.com.ricardotrevisan.handson.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ricardotrevisan.handson.domain.model.Client;

/*
 * Option by Spring Data JPA (instead of Hibernate)
 * 
 * */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	List<Client> findByName(String name);
	List<Client> findByNameContaining(String name);
	Client findByEmail(String email);
}
