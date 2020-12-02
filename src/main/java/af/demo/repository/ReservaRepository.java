package af.demo.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Component;

import af.demo.model.Reserva;

@Component
public class ReservaRepository {
    private List<Reserva> reservas;
    private int nextCode = 0;

    // @PostConstruct
    // public void criarReservas() {
    //     Reserva r1 = new Reserva();
    //     Reserva r2 = new Reserva();

    //     r1.setCodigo(1);
    //     r1.setCliente(cliente);

    //     reservas = new ArrayList<Reserva>();
    //     reservas.add(r1);
    //     reservas.add(r2);
    // }

    public List<Reserva> getAllReservas() {
        return reservas;
    }

    public Optional<Reserva> getReservaByCodigo(int codigo) {
        for(Reserva aux : reservas) {
            if(aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }

        return Optional.empty();
    }

    public Reserva save(Reserva reserva){
        reserva.setCodigo(nextCode++);
        reservas.add(reserva);
        return reserva;
    }

    public void remove(Reserva reserva) {
        reservas.remove(reserva);
    }
}
