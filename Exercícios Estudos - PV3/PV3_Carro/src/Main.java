import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcao = 0;
        int counterRR = 0;
        int counterBe = 0;
        Arquivo novoArquivo = new Arquivo();
        ArrayList<Veiculo> listaCarros = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(opcao != 5) {

            System.out.println();
            System.out.println("Menu:");
            System.out.println("Digite 1 para adicionar um carro.");
            System.out.println("Digite 2 para visualizar os veiculos salvos.");
            System.out.println("Digite 3 para visualizar os veiculos em ordem decrescente do ano.");
            System.out.println("Digite 4 para visualizar a quantidade de veiculos de cada marca.");
            System.out.println("Digite 5 para sair.");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    Veiculo novoVeiculo = new Veiculo();
                    Motor novoMotor = new Motor();

                    System.out.print("Digite a marca do veiculo: ");
                    novoVeiculo.setMarca(sc.nextLine());
                    try{
                        if(!(novoVeiculo.getMarca().equalsIgnoreCase("Rolls-Royce") || novoVeiculo.getMarca().equalsIgnoreCase("Bentley")))
                            throw new ValorInvalidoException();
                    }catch(ValorInvalidoException e){
                        System.out.println(e);
                        break;
                    }

                    System.out.print("Digite o modelo do veiculo: ");
                    novoVeiculo.setModelo(sc.nextLine());

                    System.out.print("Digite o ano do veiculo: ");
                    novoVeiculo.setAno(sc.nextInt());
                    sc.nextLine();
                    try{
                        if(novoVeiculo.getAno() < 1960 || novoVeiculo.getAno() > 2024)
                            throw new ValorInvalidoException();
                    }catch(ValorInvalidoException e){
                        System.out.println(e);
                        break;
                    }

                    System.out.print("Digite a kilometragem do veiculo: ");
                    novoVeiculo.setKmRodados(sc.nextDouble());
                    try{
                        if(novoVeiculo.getKmRodados() < 0)
                            throw new ValorInvalidoException();
                    }catch(ValorInvalidoException e){
                        System.out.println(e);
                        break;
                    }

                    System.out.print("Digite a potencia do motor: ");
                    novoMotor.setPotencia(sc.nextDouble());
                    sc.nextLine();
                    try{
                        if(novoMotor.getPotencia() <= 0)
                            throw new ValorInvalidoException();
                    }catch(ValorInvalidoException e){
                        System.out.println(e);
                        break;
                    }

                    System.out.print("Digite o numero de cilindros do motor: ");
                    novoMotor.setNumCilindros(sc.nextInt());
                    sc.nextLine();
                    try{
                        if(novoMotor.getNumCilindros() <= 0)
                            throw new ValorInvalidoException();
                    }catch(ValorInvalidoException e){
                        System.out.println(e);
                        break;
                    }

                    novoVeiculo.setMotor(novoMotor);
                    novoArquivo.escrever(novoVeiculo);
                    break;

                case 2:
                    listaCarros = novoArquivo.ler();
                    for (Veiculo listaCarro : listaCarros) {
                        listaCarro.mostraInfos();
                    }
                    break;

                case 3:
                    listaCarros = novoArquivo.ler();
                    Collections.sort(listaCarros);
                    for(int i = listaCarros.size() - 1; i >= 0; i--){
                        listaCarros.get(i).mostraInfos();
                    }
                    break;

                case 4:
                    listaCarros = novoArquivo.ler();
                    for(int i = 0; i < listaCarros.size(); i++){
                        if(listaCarros.get(i).getMarca().equalsIgnoreCase("Rolls-Royce"))
                            counterRR++;
                        if(listaCarros.get(i).getMarca().equalsIgnoreCase("Bentley"))
                            counterBe++;
                    }
                    System.out.println("Há " + counterRR + " carros Rolls-Royce e " + counterBe + " carros Bentley.");
                    break;

                case 5:
                    System.out.println("Desligando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }
}
