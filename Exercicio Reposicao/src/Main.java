import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        double valor = 0;
        Conta Conta1 = new Conta();

        while(opcao != 4){

            System.out.println("Digite 1 para depositar, 2 para sacar, 3 para ver o extrato e 4 para sair.");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    System.out.print("Digite quanto quer depositar: ");
                    valor = sc.nextDouble();
                    sc.nextLine();
                    Conta1.deposita(valor);
                    break;

                case 2:
                    System.out.print("Digite quanto quer sacar: ");
                    valor = sc.nextDouble();
                    sc.nextLine();
                    Conta1.saca(valor);
                    break;

                case 3:
                    Conta1.extrato();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }

    }

}
