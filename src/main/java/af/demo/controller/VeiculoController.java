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

import af.demo.dto.VeiculoDTO;
// import af.demo.model.Cliente;
import af.demo.model.Veiculo;
// import af.demo.service.ClienteService;
import af.demo.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    // @Autowired
    // private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> getVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Veiculo> getVeiculo(@PathVariable int codigo){   
        Veiculo veiculo = veiculoService.getVeiculoByCodigo(codigo);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody VeiculoDTO veiculoDTO,
                                          HttpServletRequest request,
                                          UriComponentsBuilder builder
    ){

        Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
        veiculo  = veiculoService.save(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI() +"/"+veiculo.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){   
        veiculoService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable int codigo, 
                                             @RequestBody VeiculoDTO veiculoDTO){   
        
       
            Veiculo veiculo = veiculoService.fromDTO(veiculoDTO);
            veiculo.setCodigo(codigo);
            veiculo = veiculoService.update(veiculo);
            return ResponseEntity.ok(veiculo);  
    }
}
