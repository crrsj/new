package com.spring.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.model.Cliente;
import com.spring.api.repository.ClienteRepository;

@RestController
public class ClienteController {
	@Autowired
 private ClienteRepository clienteRepository;
	
	@RequestMapping(value =  "/olamundo/{nome}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String Retolamundo(@PathVariable String nome) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);	
		clienteRepository.save(cliente);
		return "Olá," + nome;
	}
	@GetMapping(value = "listartodos")
	@ResponseBody
	public ResponseEntity<List<Cliente>>listaCliente(){
		List<Cliente>clientes = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Cliente>salvar(@RequestBody Cliente cliente){
	Cliente cli = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cli,HttpStatus.CREATED);
	}
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String>delete(@RequestParam Long idclient ){
	    clienteRepository.deleteById(idclient);
		return new ResponseEntity<String>("cliente deletado com sucesso",HttpStatus.OK);
	}
	@GetMapping(value = "buscarclienteid")
	@ResponseBody
	public ResponseEntity<Cliente>buscarclienteid(@RequestParam(name = "idclient" ) Long idclient){
	   Cliente cliente = clienteRepository.findById(idclient).get();
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")//PRECISA INFORMAR O ID PARA ATUALIZAR
	@ResponseBody
	public ResponseEntity<?>atualizar(@RequestBody Cliente cliente){
		if (cliente.getId() == null) {
			return new ResponseEntity<String>("Erro: Para atualizar altere algum dado",HttpStatus.OK);
		}
		
	    Cliente cli = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(cli,HttpStatus.OK);
	}
	
	
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Cliente>>buscarPorNome(@RequestParam(name = "name" ) String name){
	    List<Cliente> cliente = clienteRepository.buscarPorNome(name.trim().toUpperCase());
		return new ResponseEntity<List<Cliente>>(cliente,HttpStatus.OK);
	}
	
	@GetMapping(value = "buscarCpf")
	@ResponseBody
	public ResponseEntity<List<Cliente>>buscarCpf(@RequestParam(name = "name" ) String name){
	    List<Cliente> cliente = clienteRepository.buscarCpf(name.trim().toUpperCase());
		return new ResponseEntity<List<Cliente>>(cliente,HttpStatus.OK);
	}
	

	@GetMapping(value = "buscarPlaca")
	@ResponseBody
	public ResponseEntity<List<Cliente>>buscarPlaca(@RequestParam(name = "name" ) String name){
	    List<Cliente> cliente = clienteRepository.buscarPlaca(name.trim().toUpperCase());
		return new ResponseEntity<List<Cliente>>(cliente,HttpStatus.OK);
	}
}
