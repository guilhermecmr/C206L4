import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int np1;
        int np2;
        int media;

        Scanner notas = new Scanner(System.in);

        System.out.print("Digite a NP1 seguida da NP2: ");

        np1 = notas.nextInt();
        np2 = notas.nextInt();

        media = (np1+np2)/2;

        System.out.println("A media e: " + media);

    }

}
