package com.fatec.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.dto.ClienteDTO;
import com.fatec.dto.FichaDTO;
import com.fatec.model.Cliente;
import com.fatec.repository.ClienteRepository;



@Service
public class ClienteService  {
	@Autowired
	private ClienteRepository repository;
	private FichaService fichaService;
	
	public Cliente SearchById (Long id){
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!"));

	}
	
	public Cliente InsertCliente (ClienteDTO clienteDTO,String nomeCliente, String CPF){
		Cliente cliente = clienteDTO.ToEntityInsert(clienteDTO);
		repository.save(cliente);
		FichaDTO fichaDTO = new FichaDTO();
		fichaDTO.setNomeCliente(nomeCliente);
		fichaDTO.setCPF(CPF);
		fichaDTO.setId(cliente.getId());
		fichaService.InsertFicha(fichaDTO);
		return cliente;
	}
	
	public ClienteDTO buscarClientePorId(Long id) {
		Cliente clienteRef= SearchById(id);
    return new ClienteDTO(clienteRef);
	}
	
}
