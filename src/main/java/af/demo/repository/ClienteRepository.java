package af.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import af.demo.model.Cliente;

@Component
public class ClienteRepository {
    private List<Cliente> clientes;
    private int nextCode;

    @PostConstruct
    public void criarClientes() {
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("José");
        c1.setEndereco("Minha Casa");
        c1.setCpf("41986978842");

        c2.setCodigo(2);
        c2.setNome("Luiza");
        c2.setEndereco("Rua da Casa dela");
        c2.setCpf("47530764829");

        c3.setCodigo(3);
        c3.setNome("Rafael");
        c3.setEndereco("Rua da Casa dele");
        c3.setCpf("45204958819");
       
        nextCode = 4;

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }

    public List<Cliente> getAllClientes() {
        return clientes;
    }

    public Optional<Cliente> getClienteByCodigo(int codigo) {
        for(Cliente aux : clientes) {
            if(aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Cliente save(Cliente cliente){
        cliente.setCodigo(nextCode++);
        clientes.add(cliente);
        return cliente;
    }

	public void remove(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    public Cliente update(Cliente cliente) {
        Cliente aux = getClienteByCodigo(cliente.getCodigo()).get();

        if(aux != null) {
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
            aux.setCpf(cliente.getCpf());
        }
        return aux;
    }
}
