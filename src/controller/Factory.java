package controller;

import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Fornecedor;
import model.Item;
import model.Produto;
import model.Venda;

public abstract class Factory {
    
    public static List<Cliente> criarListaCliente(){
        return new ArrayList<Cliente>();
    }

    public static List<Fornecedor> criarListaFornecedor(){
        return new ArrayList<Fornecedor>();
    }

    public static List<Produto> criarListaProduto(){
        return new ArrayList<Produto>();
    }
    
    public static List<Item> criarListaItem(){
        return new ArrayList<Item>();
    }
    
    public static List<Venda> criarListaVenda(){
        return new ArrayList<Venda>();
    }
}
