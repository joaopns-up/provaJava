package model;

import java.io.Serializable;


public class Produto implements Serializable{
    public int id;
    public String nome;
    public float preco;
    public int estoque;

    private Produto(int id, String nome, float preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static Produto criaProduto(int id, String nome, float preco, int estoque){
        return new Produto(id, nome, preco, estoque);
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    @Override
    public String toString() {
        return "Produto id = " + id + ", nome = " + nome + ", preco = " + preco + ", estoque = " + estoque;
    }
}
