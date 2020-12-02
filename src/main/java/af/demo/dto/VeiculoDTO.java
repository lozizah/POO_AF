package af.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class VeiculoDTO {

    @NotBlank(message = "Modelo do veículo obrigatório!")
    private String modelo;

    @Min(0)
    private double diaria;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
}
