package af.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import af.demo.dto.ClienteDTO;
import af.demo.model.Cliente;
// import af.demo.model.Veiculo;
import af.demo.service.ClienteService;
// import af.demo.service.VeiculoService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // @Autowired
    // private VeiculoService veiculoService;

    @GetMapping()
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int codigo){   
        Cliente cliente = clienteService.getClienteByCodigo(codigo);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO,
                                          HttpServletRequest request,
                                          UriComponentsBuilder builder
    ){

        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente  = clienteService.save(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() +"/"+cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){   
        clienteService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int codigo, 
                                             @RequestBody ClienteDTO clienteDTO){   
        
       
            Cliente cliente = clienteService.fromDTO(clienteDTO);
            cliente.setCodigo(codigo);
            cliente = clienteService.update(cliente);
            return ResponseEntity.ok(cliente);  
    }
}
