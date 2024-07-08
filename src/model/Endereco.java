package model;

import java.io.Serializable;

public class Endereco implements Serializable{
    private String rua, cidade;
    private Estado estado;

    private Endereco(String rua, String cidade, Estado estado) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco ciraEndereco(String rua, String cidade, String estado) throws Exception{
        return new Endereco(
            rua, 
            cidade, 
            (estado.length() == 2)? Estado.buscarEstadoPorSilga(estado) : Estado.buscarEstadoPorNome(estado)
        );
    }
 
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nEndereco: Rua = " + rua + ", Cidade = " + cidade + ", Estado = " + estado.getNome();
    }
}