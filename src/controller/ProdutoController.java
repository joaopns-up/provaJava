package controller;

import java.util.List;
import java.util.Optional;

import model.Produto;
import util.Dados;

public class ProdutoController {
 private List<Produto> produtos;
    
    public ProdutoController() {
        this.produtos = Factory.criarListaProduto();
       // carregarDados();
    }

    public void cadastrar(String nome, float preco, int estoque) throws Exception{
        try {

        } catch (Exception e) {
            throw new Exception("Erro ao realizar o cadastro");
        }
    }

    private int gerarId(){
        return produtos.stream()
            .mapToInt(Produto::getId)
            .max()
            .orElse(0) + 2;
    }

    public void alterar(Produto novoProduto) throws Exception{
        try {
            Optional<Produto> produtoOpt = buscarPorId(novoProduto.getId());

            if(produtoOpt.isEmpty()) throw new Exception("Produto não encontrado");

            Produto Produto = produtoOpt.get();

            if (!novoProduto.getNome().isEmpty()) {
                Produto.setNome(novoProduto.getNome());
            }
            
            if (novoProduto.getPreco() > 0) {
                Produto.setPreco(novoProduto.getPreco());
            }
            
            if (novoProduto.getEstoque() > 0) {
                Produto.setEstoque(novoProduto.getEstoque());
            }

            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o cadastro");
        }  
    }

    public void deletar(int id) throws Exception{
        try {
            Optional<Produto> produtoOpt = buscarPorId(id);
            if(produtoOpt.isEmpty()) throw new Exception("Produto não encontrado");

            produtos.remove(produtoOpt.get());
            
            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o cadastro");
        }
    }

    public List<Produto> listar() throws Exception{

        if(produtos.isEmpty()) throw new Exception("Não existem produtos cadastrados");
        return produtos;
    }

    public Optional<Produto> buscarPorId(int id) throws Exception{
        try {
            return produtos.stream()
            .filter(c -> c.getId() == id)
            .findFirst(); 

        } catch (Exception e) {
            throw new Exception("Erro ao buscar o cadastro");
        }
    }
    
    public Optional<Produto> buscarPorNome(String nome) throws Exception{
        try {
            return produtos.stream()
                .filter(c -> c.getNome()
                .equals(nome))
                .findFirst();   

        } catch (Exception e) {
            throw new Exception("Erro ao buscar o cadastro");
        }       
    }
    
    private void carregarDados(){
        try {
            produtos = Dados.ler("Produto");
        } catch (Exception e) {
            System.err.println("Dados de produto não podem ser carregados");
        }
    }

    private void salvarDados(){
        try {
            Dados.salvar(produtos, "Produto");
        } catch (Exception e) {
            System.err.println("Dados de produto não podem ser salvos");
        }
    }   
}
