package model;

import java.io.Serializable;
import java.util.List;

import controller.Factory;



public class Venda implements Serializable{
    public int id;
    public Cliente cliente;
    public List<Item> itens;
    public float total;

    private Venda(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = Factory.criarListaItem();
    }

    public static Venda criarVenda(int id, Cliente cliente){
        return new Venda(id, cliente);
    }

    public void adicionarItem(Produto produto, int qtde) throws Exception{
        if (produto.getEstoque() > qtde) {
            throw new Exception("Quantidade insuficiente no estoque");
        }

        itens.add(Item.cirarItem(gerarId(), produto, qtde)); 
        atualizaVenda();   
    }

    private int gerarId(){
        return itens.stream()
            .mapToInt(Item::getId)
            .max()
            .orElse(0) + 1;
    }

    private void atualizaVenda(){
        total = (float) itens.stream()
            .mapToDouble(item -> item.getProd().getPreco() * item.getQtde())
            .sum();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    @Override
    public String toString() {
        return "\nVenda id = " + id + cliente + ", itens = " + itens + "\n Total = R$ " + total + "\n";
    }
}