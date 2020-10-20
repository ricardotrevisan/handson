package br.com.ricardotrevisan.handson.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ricardotrevisan.handson.api.exception.ResourceNotFoundException;
import br.com.ricardotrevisan.handson.domain.exception.BusinessException;
import br.com.ricardotrevisan.handson.domain.model.Client;
import br.com.ricardotrevisan.handson.domain.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientRepository repository;

	@GetMapping
	public List<Client> listClients(){
		return repository.findAll();		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client adicionar(@Valid @RequestBody Client client) {
		Client clienteExistente = repository.findByEmail(client.getEmail());
		if(clienteExistente != null && !clienteExistente.equals(client)){
			throw new BusinessException("existing.email");
		}		
		return repository.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client){
		if(repository.existsById(clientId)) {
			client.setId(clientId);
			client = repository.save(client);
			return ResponseEntity.ok(client);
			
		}else {
			throw new BusinessException("client.notfound");
		}
	}
			
	@GetMapping("/{id}")
	public Client buscar(@PathVariable(value="id") Long clientId) {
		//suppressing service classes... until a more complex endeavor 
		Optional<Client> client = repository.findById(clientId);
		if(client.isPresent()) {
			return client.get();
		}else {
			throw new ResourceNotFoundException("client.notfound");
		}
	}		
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> remover(@PathVariable Long clientId){
		if(repository.existsById(clientId)) {						
			repository.deleteById(clientId);
			return ResponseEntity.noContent().build(); //HttpCode 204
		}else {
			throw new ResourceNotFoundException("client.notfound");
		}		
	}
}

