package af.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import af.demo.model.Reserva;
import af.demo.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repositorio;


    public List<Reserva> getAllReservas() {
		return repositorio.getAllReservas();
    }
    
    public Reserva getReservaByCodigo(int codigo) {
        Optional<Reserva> op = repositorio.getReservaByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,"Reserva nao cadastrado"
                                ) );
    }

    public Reserva save(Reserva reserva) {
		return repositorio.save(reserva);
	}

	public void removeByCodigo(int codigo) {
        repositorio.remove(getReservaByCodigo(codigo));
        getReservaByCodigo(codigo).getVeiculo().removeReserva(getReservaByCodigo(codigo));
	}
}
