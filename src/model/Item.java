package model;

import java.io.Serializable;

public class Item{
    private int id;
    private Produto prod;
    private int qtde;

    private Item(int id, Produto prod, int qtde) {
        this.id = id;
        this.prod = prod;
        this.qtde = qtde;
    }

    public static Item cirarItem(int id, Produto prod, int qtde){
        return new Item(id, prod, qtde);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Produto getProd() {
        return prod;
    }
    public void setProd(Produto prod) {
        this.prod = prod;
    }
    public int getQtde() {
        return qtde;
    }
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    @Override
    public String toString() {
        return "\nid= " + id + ", prod= " + prod + ", qtde= " + qtde;
    }


    
}
