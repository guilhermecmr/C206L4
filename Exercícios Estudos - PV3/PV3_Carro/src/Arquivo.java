import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arquivo {

    public void escrever(Veiculo veiculo){
        // Criando estruturas que permitirao escrever o arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            // Informando o nome do arquivo a ser ecrito
            os = new FileOutputStream("Carros.txt",true);
            // Ponte que transforma de stream de caracteres para stream de bytes
            osw = new OutputStreamWriter(os);
            // Em BW escrevemos a informação que queremos escrever no arquivo
            bw =  new BufferedWriter(osw);

            // Escreve as informações obtidas
            bw.write("++++ Veiculos ++++");
            bw.newLine();
            bw.write(veiculo.getMarca() + "\n");
            bw.write(veiculo.getModelo() + "\n");
            bw.write(veiculo.getAno() + "\n");
            bw.write(veiculo.getKmRodados() + "\n");
            bw.write(veiculo.getMotor().getPotencia() + "\n");
            bw.write(veiculo.getMotor().getNumCilindros() + "\n");

        }catch(Exception e){
            System.out.println(e);
        }finally {
            {
                try {
                    bw.close();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public ArrayList<Veiculo> ler(){

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        ArrayList<Veiculo> carrosArquivo = new ArrayList<>();

        String linhaLer;

        try{
            is  = new FileInputStream("Carros.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();
            while (linhaLer != null){
                 if(linhaLer.contains("++++ Veiculos ++++")) {
                     Veiculo aux = new Veiculo();
                     Motor auxMotor = new Motor();

                     aux.setMarca(br.readLine());
                     aux.setModelo(br.readLine());
                     aux.setAno(Integer.parseInt(br.readLine()));
                     aux.setKmRodados(Double.parseDouble(br.readLine()));
                     auxMotor.setPotencia(Double.parseDouble(br.readLine()));
                     auxMotor.setNumCilindros(Integer.parseInt(br.readLine()));
                     aux.setMotor(auxMotor);

                     carrosArquivo.add(aux);
                 }
                 linhaLer = br.readLine(); ///// ???????????
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }

        return carrosArquivo;
    }



}
