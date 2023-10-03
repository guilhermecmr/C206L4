public class Violinista extends Musico{

    String marcaBreu;
    boolean usaEspaleira;

    @Override
    public void tocar() {
        System.out.println("Tocando o violino.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("Marca Breu: " + marcaBreu);
        if(usaEspaleira){
            System.out.println("Usando a espaleira.");
        }else{
            System.out.println("Não usando a espaleira.");
        }
    }

    public Violinista(int codigo, String nome, int idade, String musica, int pontuacao, String marcaBreu, boolean usaEspaleira) {
        super(codigo, nome, idade, musica, pontuacao);
        this.marcaBreu = marcaBreu;
        this.usaEspaleira = usaEspaleira;
        int cont = getContador();
        setContador(cont++);
    }

}
