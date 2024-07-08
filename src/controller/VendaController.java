package controller;

import java.util.List;

import model.Cliente;
import model.Venda;
import util.Dados;

public class VendaController {
    private List<Venda> vendas;
    

    public VendaController() {
        this.vendas = Factory.criarListaVenda();
        carregarDados();
    }

    public void registrarVenda(Venda venda) throws Exception{
        try {
            vendas.add(venda);

            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao realizar o cadastro");
        }
    }

    public Venda abrirVenda(Cliente cliente){
        return Venda.criarVenda(gerarId(), cliente);
    }

    private int gerarId(){
        return vendas.stream()
            .mapToInt(Venda::getId)
            .max()
            .orElse(0) + 1;
    }

    public List<Venda> listar() throws Exception{
        try {

        if(vendas.isEmpty()) throw new Exception("Não existem Vendas cadastrados");
        return vendas;

        } catch (Exception e) {
            throw new Exception("Erro ao listar o cadastro");
        }
    }
    
    private void carregarDados(){
        try {
            vendas = Dados.ler("Venda");
        } catch (Exception e) {
            System.err.println("Dados de venda não podem ser carregados");
        }
    }

    private void salvarDados(){
        try {
            Dados.salvar(vendas, "Venda");
        } catch (Exception e) {
            System.err.println("Dados de Venda não podem ser salvos " + e.getMessage());
        }
    }

    
}
