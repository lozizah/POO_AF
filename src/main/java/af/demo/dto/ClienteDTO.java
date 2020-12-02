package af.demo.dto;

import javax.validation.constraints.NotBlank;

public class ClienteDTO {

    @NotBlank(message = "Nome obrigatório!")
    private String nome;

    @NotBlank(message = "String obrigatório!")
    private String endereco;

    @NotBlank(message = "CPF obrigatório!")
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cPF) {
        cpf = cPF;
    }

    //teste
}
