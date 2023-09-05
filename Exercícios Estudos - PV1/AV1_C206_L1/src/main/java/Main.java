import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        Supermercado alvorada = new Supermercado();
        alvorada.nome = "Alvorada";
        alvorada.cnpj = "54587898965/8";
        alvorada.endereco = "Rua Jorge";
        alvorada.numTelefone = "3512345678";

        while(opcao != 5) {
            System.out.println("Digite 1 para adicionar produtos ao mercado, 2 para mostrar informacoes, 3 para a quantidade de cada categoria, 4 para informacoes do produto mais caro e barato e 5 para sair.");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    Produto novoProduto = new Produto();
                    System.out.print("Insira o codigo de serie: ");
                    novoProduto.codigoSerie = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Insira o nome: ");
                    novoProduto.nome = sc.nextLine();
                    System.out.print("Insira a categoria: ");
                    novoProduto.categoria = sc.nextLine();
                    System.out.print("Insira a quantidade: ");
                    novoProduto.quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Insira o valor: ");
                    novoProduto.valor = sc.nextDouble();
                    sc.nextLine();
                    alvorada.addProduto(novoProduto);
                    break;

                case 2:
                    alvorada.mostrarInfos();
                    break;

                case 3:
                    alvorada.contarCategorias();
                    break;

                case 4:
                    alvorada.mostrarMaisCaroBarato();
                    break;

                case 5:
                    System.out.println("Até mais.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
    }

}
