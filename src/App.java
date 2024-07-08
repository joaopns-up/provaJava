import java.util.Optional;

import controller.ClienteController;
import controller.FornecedorController;
import controller.ProdutoController;
import controller.VendaController;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;
import model.Produto;
import model.Venda;
import util.Log;

public class App {
    public static void main(String[] args) throws Exception {
        
        Log.setErro();

        System.out.println( "\n################# Fornecedor ######################\n");

            FornecedorController fornecedorController = new FornecedorController();
        
        System.out.println( "################# Cadastro Fornecedor ######################" );
            try {
                fornecedorController.cadastrar("Lacta", "contato@lacta.com.br", "Rua das flores", "Curitiba", "Paraná", "1234567891");           
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

                fornecedorController.cadastrar("Garoto", "contato@garoto.com.br", "Rua das XV", "Mafra", "Santa Catarina", "987654321");


            Fornecedor fornecedor = Fornecedor.criaFornecedor("Hersheys", "contato@hersheys.com", "987654321");

            try {
                fornecedorController.cadastrar(fornecedor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        System.out.println( "################# Fim Cadastro Fornecedor ######################" );
        
        System.out.println( "################# Listar Fornecedores ######################" );
            
            System.out.println(fornecedorController.listar());
        
            System.out.println( "################# Fim Listar Fornecedores ######################" );
        
        System.out.println( "################# Alteração Fornecedor ######################" );
       
                Fornecedor fornecedor2 =  fornecedorController.buscarPorId(3);
                fornecedor2.setNome("Novo nome");
                fornecedorController.alterar(fornecedor2);
            
            System.out.println(FornecedorController.buscarPorId(3));
        System.out.println( "################# Fim Alteração Fornecedor ######################" );
       
        System.out.println( "################# Deletar Fornecedor ######################" );
        
        try {
            FornecedorController.deletar(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println( "################# Fim Deletar Fornecedor ######################" );  
        
        System.out.println( "################# Listar Fornecedores ######################" );
            System.out.println(fornecedorController.listar());
        System.out.println( "################# Fim Listar Fornecedores ######################" );

        
        System.out.println( "\n################# Cliente ######################\n");
            
            ClienteController clienteController = new ClienteController();

        System.out.println( "################# Cadastro Cliente ######################" );


                clienteController.cadastrar("José", "jose@bol.com.br", "Rua XV de Novembro", "Curitiba", "Paraná", "123456");

                clienteController.cadastrar("José", "jose@yahoo.com.br", "Rodovia das Torres", "São José", "Paraná", "987987");


            Cliente cliente = null;
            Optional<Cliente> clienteOpt = clienteController.buscarPorId(1);
            
            if (clienteOpt.isPresent()) {
                cliente = clienteOpt.get();
                System.out.println(cliente);
            }

        System.out.println( "################# Fim Cadastro Cliente ######################" );
        
        System.out.println( "################# Listar Clientes ######################" );
        
            System.out.println(clienteController.listar());
        
        System.out.println( "################# Fim Listar Clientes ######################" );
        
        System.out.println( "\n################# Produto ######################\n");

            ProdutoController produtoController = new ProdutoController();
        
        System.out.println( "################# Cadastro Produto ######################" );
            ProdutoController.cadastrar("Prod 1", 10, 2);
            ProdutoController.cadastrar("Prod 2", 10, 2);
            ProdutoController.cadastrar("Prod 3", 10, 2);
        System.out.println( "################# Fim Cadastro Produto ######################" );
        
        System.out.println( "################# Listar Produtos ######################" );
        
        System.out.println( "################# Fim Listar Produtos ######################" );

        System.out.println( "\n################# Venda ######################\n");
        
            VendaController vendaController = new VendaController();

        System.out.println( "################# REALIZAR VENDA ######################" );
        
            Venda venda = vendaController.abrirVenda(cliente);

            System.out.println(produtoController.buscarPorId(1));
        
            Optional<Produto> produtoOpt = produtoController.buscarPorId(1);
            try {
                if (produtoOpt.isPresent()) venda.adicionarItem(produtoOpt.get(), 2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
                        
            produtoOpt = produtoController.buscarPorId(2);
            try {
                if (produtoOpt.isPresent()) venda.adicionarItem(produtoOpt.get(), 2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            produtoOpt = produtoController.buscarPorId(3);
            try {
                if (produtoOpt.isPresent()) venda.adicionarItem(produtoOpt.get(), 2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        vendaController.registrarVenda(venda);

        System.out.println( "################# FIM REALIZAR VENDA ######################" );
        
        System.out.println( "################ LISTAR VENDA #######################" );
        
            System.out.println(vendaController.listar());
        
        System.out.println( "################ LISTAR VENDA #######################" );

    }
}
