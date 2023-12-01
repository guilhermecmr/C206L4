import br.com.lojaGames.DAO.UserDAO;
import br.com.lojaGames.dadoscadastrais.Cliente;
import br.com.lojaGames.dadoscadastrais.Vendedor;
import br.com.lojaGames.produtos.Boneco;
import br.com.lojaGames.produtos.Colecionador;
import br.com.lojaGames.produtos.Digital;
import br.com.lojaGames.produtos.Fisico;
import br.com.lojaGames.produtos.Produto;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        int opcao;

        do
        {
            //exibicao das opcoes
            System.out.println("\nMenu:");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Atualizar estoque");
            System.out.println("3 - Mostrar informações de um produto");
            System.out.println("4 - Deletar produto");
            System.out.println("5 - Cadastrar produto");
            System.out.println("6 - Cadastrar cliente");
            System.out.println("0 - Sair\n");

            //selecao da opcao
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            //chamada dos submenus
            switch (opcao)
            {
                case 1: //realizar venda
                    venda();
                    break;

                case 2: //atualizar estoque
                    atualizarEstoque();
                    break;

                case 3: //mostrar informacoes
                    mostraInfos();
                    break;

                case 4: //deletar produto
                    deletarProduto();
                    break;

                case 5: //cadastrar produto
                    cadastrarProduto();
                    break;

                case 6: //cadastrar cliente
                    cadastrarCliente();
                    break;

                case 0: //sair do programa
                    System.out.println("\nDesligando o sistema...");
                    break;

                default: //padrao
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);
    }

    private static void cadastrarCliente()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //declaracao de variaveis
        int idVendedor;
        boolean erro;
        String nome, telefone;

        //coleta de dados do cliente e vendedor
        System.out.print("\nID do vendedor associado ao cliente: ");
        idVendedor =  sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do cliente: ");
        nome =  sc.nextLine();
        System.out.print("Telefone do cliente: ");
        telefone =  sc.nextLine();

        //criacao de nova instancia de boneco, passando os parametros para o construtor
        Cliente cliente = new Cliente(nome, telefone, idVendedor);

        //insercao do cliente no banco de dados
        erro = !userDAO.insertCliente(cliente);

        if (erro)
        {
            System.out.println("\nErro ao cadastrar cliente! Cadastro cancelado.");

            //encerra o metodo
            return;
        }

        System.out.println("\nCliente cadastrado com sucesso!");
    }

    private static void venda()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //declaracao de variaveis
        Cliente cliente;
        Vendedor vendedor;
        Produto produto;
        int opcao, nUnidades, estoqueAnterior, novoEstoque, idVendedor;
        float bonus;
        String codigo, telefone;

        //leitura do telefone do cliente
        System.out.print("\nTelefone do cliente cadastrado: ");
        telefone = sc.nextLine();

        //verifica se o cliente esta cadastrado
        cliente = userDAO.selectCliente(telefone);

        if (cliente == null)
        {
            System.out.println("\nErro! Cliente não encontrado. Venda cancelada!");
            return;
        }

        //acha o vendedor associado ao cliente
        idVendedor = cliente.getIdVendedor();

        //busca o vendedor no banco de dados
        vendedor = userDAO.selectVendedor(idVendedor);

        if (vendedor == null)
        {
            System.out.println("\nErro! O vendedor associado ao cliente não foi encontrado. Venda cancelada!");
            return;
        }

        //selecao do produto
        System.out.print("\nCódigo de barras: ");
        codigo = sc.nextLine();

        //seleciona o produto
        produto = userDAO.selectProduto(codigo);

        //imprime o nome e o preco do produto
        userDAO.selectProdutoNomePreco(codigo);

        //puxa o estoque do item do banco de dados
        estoqueAnterior = userDAO.selectEstoque(codigo);

        //checar se esta esgotado ou se o produto nao existe
        if(estoqueAnterior == -1)
            System.out.println("Erro na operação!");

        //em caso de sucesso ao achar um produto com estoque
        else
        {
            //apos exibir o produto, confirma se aquele é o produto correto
            System.out.println("\n1 - Confirmar produto");
            System.out.println("2 - Cancelar");

            //le a escolha do usuario
            System.out.print("\nOpção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            //prosseguir com a venda
            if (opcao == 1)
            {
                System.out.print("\nNúmero de unidades a serem vendidas: ");
                nUnidades = sc.nextInt();
                sc.nextLine();

                //se o estoque for insuficiente
                if (estoqueAnterior < nUnidades)
                    System.out.println("Erro! Estoque insuficiente.");

                //se houver estoque suficiente
                else
                {
                    bonus = vendedor.getBonus() + 0.02f * nUnidades * produto.getPreco();

                    System.out.println("\nNovo bonus do vendedor " + vendedor.getNome() + ": R$" + bonus);

                    //atualiza o bonus do vendedor no banco de dados
                    userDAO.updateBonus(idVendedor, bonus);

                    //decrementa o estoque
                    novoEstoque = estoqueAnterior - nUnidades;

                    //atualiza o estoque no banco de dados
                    userDAO.updateEstoque(codigo, novoEstoque);

                    System.out.println("\nVenda realizada com sucesso!");
                }
            }

            //cancelar venda
            else
                System.out.println("Venda cancelada");
        }
    }

    static void cadastrarProduto()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //declaracao de variaveis
        int opcaoProduto, ano, tamanho, estoque;
        byte classificacaoIndicativa;
        float preco;
        boolean usado, figure, steelBook, ost, duplicado;
        String nome, codigo, estudio, console;

        //exibicao dos tipos de produto
        System.out.println("\nTipo do produto:");
        System.out.println("1 - Jogo Fisico");
        System.out.println("2 - Jogo Digital");
        System.out.println("3 - Jogo - Edição de Colecionador");
        System.out.println("4 - Boneco");
        System.out.println("0 - Voltar\n");
        System.out.print("Opcao: ");

        //selecao do tipo de produto
        opcaoProduto = sc.nextInt();
        sc.nextLine();

        System.out.print("\nNome: "); //caracteristica geral de todos os produtos
        nome = sc.nextLine();

        switch(opcaoProduto)
        {
            case 1: //jogo fisico

                System.out.print("Classificação indicativa: ");
                classificacaoIndicativa = sc.nextByte();
                sc.nextLine();
                System.out.print("Estudio: ");
                estudio = sc.nextLine();
                System.out.print("Console: ");
                console = sc.nextLine();
                System.out.print("Usado(1 - Sim, 2 - Não): ");
                usado = sc.nextInt() == 1;
                sc.nextLine();
                System.out.print("Código de barras: ");
                codigo = sc.nextLine();
                System.out.print("Preço: ");
                preco = sc.nextFloat();
                System.out.print("Quantidade em estoque: ");
                estoque = sc.nextInt();
                sc.nextLine();

                //criacao de nova instancia de jogo fisico, passando os parametros para o construtor
                Fisico fisico = new Fisico(nome, codigo, estoque, preco, classificacaoIndicativa, estudio, console, usado);

                //insercao do jogo no banco de dados
                duplicado = !userDAO.insertJogoFisico(fisico);

                break;

            case 2: //jogo digital

                System.out.print("Classificação indicativa: ");
                classificacaoIndicativa = sc.nextByte();
                sc.nextLine();
                System.out.print("Estudio: ");
                estudio = sc.nextLine();
                System.out.print("Console: ");
                console = sc.nextLine();
                System.out.print("Ano de expiração: ");
                ano = sc.nextInt();
                sc.nextLine();
                System.out.print("Código de barras: ");
                codigo = sc.nextLine();
                System.out.print("Preço: ");
                preco = sc.nextFloat();
                System.out.print("Quantidade em estoque: ");
                estoque = sc.nextInt();
                sc.nextLine();

                //criacao de nova instancia de jogo de colecionador, passando os parametros para o construtor
                Digital digital = new Digital(nome, codigo, estoque, preco, classificacaoIndicativa, estudio, console, ano);

                //insercao do jogo no banco de dados
                duplicado = !userDAO.insertJogoDigital(digital);

                break;

            case 3: //edicao de colecionador

                System.out.print("Classificação indicativa: ");
                classificacaoIndicativa = sc.nextByte();
                sc.nextLine();
                System.out.print("Estudio: ");
                estudio = sc.nextLine();
                System.out.print("Console: ");
                console = sc.nextLine();
                System.out.print("Possui action figure(1 - Sim, 2 - Não): ");
                figure = sc.nextInt() == 1;
                System.out.print("Possui SteelBook(1 - Sim, 2 - Não): ");
                steelBook = sc.nextInt() == 1;
                System.out.print("Possui trilha sonora(1 - Sim, 2 - Não): ");
                ost = sc.nextInt() == 1;
                sc.nextLine();
                System.out.print("Código de barras: ");
                codigo = sc.nextLine();
                System.out.print("Preço: ");
                preco = sc.nextFloat();
                System.out.print("Quantidade em estoque: ");
                estoque = sc.nextInt();
                sc.nextLine();

                //criacao de nova instancia de jogo de colecionador, passando os parametros para o construtor
                Colecionador colecionador = new Colecionador(nome, codigo, estoque, preco, classificacaoIndicativa, estudio, console, figure, steelBook, ost);

                //insercao do jogo no banco de dados
                duplicado = !userDAO.insertJogoColecionador(colecionador);

                break;

            case 4: //boneco

                System.out.print("Altura: ");
                tamanho = sc.nextInt();
                sc.nextLine();
                System.out.print("Código de barras: ");
                codigo = sc.nextLine();
                System.out.print("Preço: ");
                preco = sc.nextFloat();
                System.out.print("Quantidade em estoque: ");
                estoque = sc.nextInt();
                sc.nextLine();

                //criacao de nova instancia de boneco, passando os parametros para o construtor
                Boneco boneco = new Boneco(nome, codigo, estoque, preco, tamanho);

                //insercao do boneco no banco de dados
                duplicado = !userDAO.insertBoneco(boneco);

                break;

            default: //padrao

                System.out.println("Voltando.\n");

                //encerra o metodo
                return;
        }

        //se o item nao for duplicado
        if (!duplicado)
            System.out.println("\nProduto cadastrado com sucesso!");
    }

    private static void atualizarEstoque()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //declaracao de variaveis
        int opcao, aux, estoqueAnterior, novoEstoque;
        String codigo;

        //selecao do produto
        System.out.print("\nCódigo de barras do produto a ser atualizado: ");
        codigo = sc.nextLine();
        System.out.print("\n");

        //checa se o produto existe e exibe o nome e preco
        if(!userDAO.selectProdutoNomePreco(codigo))
        {
            //em caso de erro
            System.out.println("Erro! Produto não encontrado.");

            //encerra o metodo
            return;
        }

        //exibicao das opcoes
        System.out.println("\n1 - Adicionar itens ao estoque");
        System.out.println("2 - Remover itens do estoque");
        System.out.println("3 - Escolher estoque manualmente");
        System.out.println("0 - Voltar\n");

        //escolha da opcao
        System.out.print("Opção: ");
        opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao)
        {
            case 1: //incrementar

                System.out.println("\nQuantas unidades deseja adicionar ao estoque deste produto?");
                aux = sc.nextInt();
                sc.nextLine();

                //puxa o estoque do item do banco de dados
                estoqueAnterior = userDAO.selectEstoque(codigo);

                //checa se esta esgotado ou se o produto nao existe
                if(estoqueAnterior == -1)
                    System.out.println("Erro na operação!");

                //se o produto foi encontrado com sucesso
                else
                {
                    //incrementa o estoque
                    novoEstoque = estoqueAnterior + aux;

                    //atualiza o estoque no banco de dados
                    userDAO.updateEstoque(codigo, novoEstoque);
                }

                break;

            case 2: //decrementar

                System.out.println("\nQuantas unidades deseja remover do estoque deste produto?");
                aux = sc.nextInt();
                sc.nextLine();

                //puxa o estoque do item do banco de dados
                estoqueAnterior = userDAO.selectEstoque(codigo);

                //checa se esta esgotado ou se o produto nao existe
                if(estoqueAnterior == -1)
                    System.out.println("Erro na operação!");

                //se o produto foi encontrado com sucesso
                else
                {
                    //decrementa o estoque
                    novoEstoque = estoqueAnterior - aux;

                    //impede valores negativos no estoques
                    if (novoEstoque < 0)
                        novoEstoque = 0;

                    //atualiza o estoque no banco de dados
                    userDAO.updateEstoque(codigo, novoEstoque);
                }

                break;

            case 3: //sobrescrever

                //permite que o usuario sobreescreva a quantidade de itens no estoque
                System.out.println("\nQuantas unidades este produto possui?");
                novoEstoque = sc.nextInt();

                //impede que valores negativos sejam aceitos
                while(novoEstoque < 0)
                {
                    System.out.println("Valor inválido! Digite um número positivo.");
                    System.out.println("Quantas unidades este produto possui?");
                    novoEstoque = sc.nextInt();
                }

                sc.nextLine();

                //atualiza o estoque no banco de dados
                userDAO.updateEstoque(codigo, novoEstoque);

                break;

            case 0: //voltar

                System.out.println("\nVoltando.\n");

                //encerra o metodo
                return;

            default: //padrao

                System.out.println("\nOpção inválida! Operação cancelada.\n");

                //encerra o metodo
                return;
        }

        System.out.println("Estoque atualizado com sucesso!");
    }

    private static void deletarProduto()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //variável para a leitura do código de barras
        String codigo;

        //lê o código de barras
        System.out.print("\nDigite o código de barras: ");
        codigo = sc.nextLine();

        //deleta o produto do banco de dados
        userDAO.deleteProduto(codigo);

        System.out.println("\nProduto excluido com sucesso!");
    }

    private static void mostraInfos()
    {
        Scanner sc = new Scanner(System.in); //para a entrada de dados
        UserDAO userDAO = new UserDAO(); //para a integracao com o banco de dados

        //variável para a leitura do código de barras
        String codigo;
        int tipo;

        //le o codigo de barras
        System.out.print("\nDigite o código de barras: ");
        codigo = sc.nextLine();
        System.out.print("");

        //realiza a busca
        userDAO.selectProdutoPrint(codigo);
    }
}