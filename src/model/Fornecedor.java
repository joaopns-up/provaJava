package model;


public class Fornecedor implements Pessoa{
    private static final String cnpj;

    private Fornecedor(int id, String nome, String email, Endereco endereco, String cnpj) {
        super(id, nome, email, endereco);
        this.cnpj = cnpj;
    }

    public static Fornecedor criaFornecedor(int id, String nome, String email, Endereco endereco, String cnpj){
        return new Fornecedor(id, nome, email, endereco, cnpj);
    }

    public static Fornecedor criaFornecedor(int id, String nome, String email, Endereco endereco, String cnpj){
        return new Fornecedor(0, nome, email, endereco, cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "\nFornecedor id = " + id + ", nome = " + nome + ", email = " + email + ",  Cnpj = " + cnpj + endereco + "\n" ;
    }

}
