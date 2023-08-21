import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double numero1;
        double numero2;
        double resultado;

        Scanner opcoes = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);

        System.out.print("Digite 1 para somar, 2 para subtrair, 3 para multiplicar, 4 para dividir e 5 para exponenciar: ");

        int opcao = opcoes.nextInt();

        switch(opcao){

            case 1:
                System.out.print("Digite os dois numeros em sequencia: ");
                numero1 = numeros.nextInt();
                numero2 = numeros.nextInt();
                resultado = numero1 + numero2;
                System.out.println("O resultado é: "+resultado);
                break;

            case 2:
                System.out.print("Digite os dois numeros em sequencia: ");
                numero1 = numeros.nextInt();
                numero2 = numeros.nextInt();
                resultado = numero1 - numero2;
                System.out.println("O resultado é: "+resultado);
                break;

            case 3:
                System.out.print("Digite os dois numeros em sequencia: ");
                numero1 = numeros.nextInt();
                numero2 = numeros.nextInt();
                resultado = numero1 * numero2;
                System.out.println("O resultado é: "+resultado);
                break;

            case 4:
                System.out.print("Digite os dois numeros em sequencia: ");
                numero1 = numeros.nextInt();
                numero2 = numeros.nextInt();
                resultado = numero1 / numero2;
                System.out.println("O resultado é: "+resultado);
                break;

            case 5:
                System.out.print("Digite os dois numeros em sequencia: ");
                numero1 = numeros.nextInt();
                numero2 = numeros.nextInt();
                resultado = Math.pow(numero1,numero2);
                System.out.println("O resultado é: "+resultado);
                break;

            default:
                System.out.println("Opção invalida!");
                break;
        }

    }

}
