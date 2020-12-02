package af.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import af.demo.dto.VeiculoDTO;
import af.demo.model.Veiculo;
import af.demo.repository.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository repositorio;

    public Veiculo fromDTO(VeiculoDTO dto){
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setDiaria(dto.getDiaria());
        return veiculo;
    }

	public List<Veiculo> getAllVeiculos() {
		return repositorio.getAllVeiculos();
	}

	public Veiculo getVeiculoByCodigo(int codigo) {
        Optional<Veiculo> op = repositorio.getVeiculoByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"Veiculo nao cadastrado"
                             ) );
	}

	public Veiculo save(Veiculo veiculo) {
		return repositorio.save(veiculo);
	}

	public void removeByCodigo(int codigo) {
        repositorio.remove(getVeiculoByCodigo(codigo));
	}

	public Veiculo update(Veiculo veiculo) {
        getVeiculoByCodigo(veiculo.getCodigo());
        return repositorio.update(veiculo);
	}
}
