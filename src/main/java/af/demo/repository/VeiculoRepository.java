package af.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import af.demo.model.Veiculo;

@Component
public class VeiculoRepository {
    
    private List<Veiculo> veiculos;
    private int nextCode;

    @PostConstruct
    public void criarVeiculos() {
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();
        Veiculo v3 = new Veiculo();

        v1.setCodigo(1);
        v1.setModelo("Onix");
        v1.setDiaria(10);

        v2.setCodigo(2);
        v2.setModelo("Fiesta");
        v2.setDiaria(7);

        v3.setCodigo(3);
        v3.setModelo("Corolla");
        v3.setDiaria(2.5);

        nextCode = 4;

        veiculos = new ArrayList<Veiculo>();
        veiculos.add(v1);
        veiculos.add(v2);
        veiculos.add(v3);
    }

    public List<Veiculo> getAllVeiculos() {
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoByCodigo(int codigo) {
        for(Veiculo aux : veiculos) {
            if(aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Veiculo save(Veiculo veiculo){
        veiculo.setCodigo(nextCode++);
        veiculos.add(veiculo);
        return veiculo;
    }

	public void remove(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }
    
    public Veiculo update(Veiculo veiculo) {
        Veiculo aux = getVeiculoByCodigo(veiculo.getCodigo()).get();

        if(aux != null) {
            aux.setDiaria(veiculo.getDiaria());
            aux.setModelo(veiculo.getModelo());
        }
        return aux;
    }
}
