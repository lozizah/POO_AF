package af.demo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reserva {
    
    private int codigo;
    private Cliente cliente;
    private Veiculo veiculo;
    
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime inicio;

    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm:ss")
    private LocalDateTime fim;
    private double valor;

    public Reserva(){}
    
    public Reserva(int codigo, Cliente cliente, Veiculo veiculo, LocalDateTime inicio, LocalDateTime fim, double valor) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }  
}
