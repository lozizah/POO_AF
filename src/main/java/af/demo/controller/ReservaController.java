package af.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import af.demo.model.Reserva;
import af.demo.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping()
    public List<Reserva> getClientes() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Reserva> getReserva(@PathVariable int codigo){   
        Reserva reserva = reservaService.getReservaByCodigo(codigo);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody Reserva reserva,
                                          HttpServletRequest request,
                                          UriComponentsBuilder builder
    ){
        reserva  = reservaService.save(reserva);
        UriComponents uriComponents = builder.path(request.getRequestURI() +"/"+reserva.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){   
        reservaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }
}
