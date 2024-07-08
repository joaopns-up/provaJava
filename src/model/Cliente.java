package model;


public class Cliente extends Pessoa{
    protected String cpf;

    private Cliente(int id, String nome, String email, Endereco endereco, String cpf) {
        super(id, nome, email, endereco);
        this.cpf = cpf;
    }

    public static Cliente criarCliente(int id, String nome, String email, Endereco endereco, String cpf){
        return new Cliente(id, nome, email, endereco, cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nCliente id = " + id + ", nome = " + nome + ", email = " + email + ",  Cnpj = " + cpf + endereco + "\n" ;
    }
    
}
