package af.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import af.demo.dto.ClienteDTO;
import af.demo.model.Cliente;
import af.demo.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repositorio;

    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEndereco(dto.getEndereco());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

	public List<Cliente> getAllClientes() {
		return repositorio.getAllClientes();
	}

	public Cliente getClienteByCodigo(int codigo) {
                Optional<Cliente> op = repositorio.getClienteByCodigo(codigo);
                return op.orElseThrow( () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"Cliente nao cadastrado"
                             ) );
	}

	public Cliente save(Cliente cliente) {
		return repositorio.save(cliente);
	}

	public void removeByCodigo(int codigo) {
                repositorio.remove(getClienteByCodigo(codigo));
	}

	public Cliente update(Cliente cliente) {
                getClienteByCodigo(cliente.getCodigo());
                return repositorio.update(cliente);
	}
}
