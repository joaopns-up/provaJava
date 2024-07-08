package controller;

import java.util.List;
import java.util.Optional;

import model.Cliente;
import model.Endereco;
import util.Dados;

public class ClienteController {
    private List<Cliente> clientes;
    
    public ClienteController() {
        carregarDados();
    }

    public void cadastrar(String nome, String email, String rua, String cidade, String estado, String cpf) throws Exception{
        try {
            Optional<Cliente> clienteOpt = buscarPorNome(nome);
            if(clienteOpt.isPresent()) throw new Exception("Cliente já cadastrado");

            Endereco endereco = Endereco.ciraEndereco(rua, cidade, estado);

            Cliente cliente = Cliente.criarCliente(gerarId(), nome, email, endereco, cpf);
            clientes.add(cliente);
            salvarDados();
        } catch (Exception e) {
            throw new Exception("Erro ao realizar o cadastro");
        }
    }

    private int gerarId(){
        return 1;
    }

    public void alterar(Cliente novoCliente) throws Exception{

            Optional<Cliente> clienteOpt = buscarPorId(novoCliente.getId());

            if(clienteOpt.isEmpty()) System.out.println("Cliente não encontrado");

            Cliente cliente = clienteOpt.get();
            cliente.setCpf(novoCliente.getCpf());
            
            
            if (!novoCliente.getEmail().isEmpty()) {
                cliente.setEmail(novoCliente.getEmail());
            }
            
            cliente.setEndereco(novoCliente.getEndereco());
            salvarDados();
 
    }

    public void deletar(int id){

            Optional<Cliente> clienteOpt = buscarPorId(id);
            if(clienteOpt.isEmpty()) System.out.println("Cliente não encontrado");

            clientes.remove(clienteOpt.get());
            salvarDados();
            
            throw new Exception("Erro ao alterar o cadastro");
    }

    public List<Cliente> listar() throws Exception{

        if(clientes.isEmpty()) throw new Exception("Não existem clientes cadastrados");
        return clientes;
    }

    public Optional<Cliente> buscarPorId(int id) throws Exception{
        return clientes.stream()
            .filter(c -> c.getId() == id)
            .findFirst(); 
    }

    public Optional<Cliente> buscarPorNome(String nome) throws Exception{
        try {
            return clientes.stream()
                .filter(c -> c.getNome()
                .equals(nome))
                .findFirst();  

        } catch (Exception e) {
            throw new Exception("Erro ao buscar o cadastro");
        }       
    }

    private void carregarDados(){
        try {
            clientes = Dados.ler("Cliente");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Dados de cliente não podem ser carregados" + e.getMessage());
        }
    }

    private void salvarDados(){
        try {
            Dados.salvar(clientes, "Cliente");
        } catch (Exception e) {
            System.err.println("Dados de cliente não podem ser salvos");
        }
    }
    
}
