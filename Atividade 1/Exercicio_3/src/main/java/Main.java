import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String combustivel;
        int litros;
        double valor = 0;

        Scanner combustiveis = new Scanner(System.in);
        Scanner volume = new Scanner(System.in);

        System.out.print("Digite o A para alcool e G para gasolina: ");
        combustivel = combustiveis.nextLine();
        System.out.print("Digite o volume adquirido: ");
        litros = volume.nextInt();


        if(combustivel.equals("A") || combustivel.equals("a")){
            if (litros <= 20){
                valor = 0.97*litros*4.9;
            }else{
                valor = 0.95*litros*4.9;
            }
        }else if(combustivel.equals("G") || combustivel.equals("g")){
            if (litros <= 20){
                valor = 0.96*litros*6;
            }else{
                valor = 0.94*litros*6;
            }
        }

        System.out.printf("O valor final é R$%.2f",valor);

    }

}
