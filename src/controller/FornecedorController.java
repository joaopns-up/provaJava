package controller;

import java.util.List;
import java.util.Optional;

import model.Fornecedor;
import util.Dados;
import model.Endereco;

public class FornecedorController {
    private List<Fornecedor> fornecedores;

    public FornecedorController() {
        this.fornecedores = Factory.criarListaFornecedor();
        carregarDados();
    }

    public void cadastrar(String nome, String email, String rua, String cidade, String estado, String cnpj) throws Exception{
        try {

            
            if (email.isEmpty()) {
                throw new Exception("E-mail vazio");
            }

            Endereco endereco = Endereco.ciraEndereco(rua, cidade, estado);

            Fornecedor fornecedor = Fornecedor.criaFornecedor(gerarId(), nome, email, endereco, cnpj);
            fornecedores.add(fornecedor);
            
            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao realizar o cadastro");
        }
    }



    private int gerarId(){
        return fornecedores.stream()
            .mapToInt(Fornecedor::getId)
            .max()
            .orElse(0) + 1;
    }

    public void alterar(Fornecedor novoFornecedor) throws Exception{
        try {
            Optional<Fornecedor> fornecedorOpt = buscarPorId(novoFornecedor.getId());

            if(fornecedorOpt.isEmpty()) throw new Exception("Fornecedor não encontrado");

            Fornecedor fornecedor = fornecedorOpt.get();

            if (!novoFornecedor.getNome().isEmpty()) {
                fornecedor.setNome(novoFornecedor.getNome());
            }
            
            if (!novoFornecedor.getCnpj().isEmpty()) {
                fornecedor.setCnpj(novoFornecedor.getCnpj());
            }
            
            if (!novoFornecedor.getEmail().isEmpty()) {
                fornecedor.setEmail(novoFornecedor.getEmail());
            }
            
            fornecedor.setEndereco(novoFornecedor.getEndereco());

            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o cadastro");
        }  
    }

    public void deletar(int id) throws Exception{
        try {
            Optional<Fornecedor> fornecedorOpt = buscarPorId(id);
            if(fornecedorOpt.isEmpty()) throw new Exception("Fornecedor não encontrado");

            fornecedores.remove(fornecedorOpt.get());

            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao alterar o cadastro");
        }
    }

    public List<Fornecedor> listar() throws Exception{

        if(fornecedores.isEmpty()) throw new Exception("Não existem fornecedores cadastrados");
        return fornecedores;
    }

    public Optional<Fornecedor> buscarPorId(int id) throws Exception{
        try {
            return fornecedores.stream()
            .filter(c -> c.getId() == id)
            .findFirst(); 

        } catch (Exception e) {
            throw new Exception("Erro ao buscar o cadastro");
        }
    }
    
    public Optional<Fornecedor> buscarPorNome(String nome) throws Exception{
        try {
            return fornecedores.stream()
            .filter(c -> c.getNome()
            .equals(nome))
            .findFirst(); 

        } catch (Exception e) {
            throw new Exception("Erro ao buscar o cadastro");
        }       
    } 
    
    private void carregarDados(){
        try {
            fornecedores = Dados.ler("Fornecedor");
        } catch (Exception e) {
            System.err.println("Dados de fornecedor não podem ser carregados");
        }
    }

    private void salvarDados(){
        try {
            Dados.salvar(fornecedores, "Fornecedor");
        } catch (Exception e) {
            System.err.println("Dados de fornecedor não podem ser salvos");
        }
    }
}
