public class Pianista extends Musico{

    float alturaBanco;

    @Override
    public void tocar() {
        System.out.println("Tocando o piano.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        System.out.println("A altura do banco é: " + alturaBanco);
    }

    public Pianista(int codigo, String nome, int idade, String musica, int pontuacao, float alturaBanco) {
        super(codigo, nome, idade, musica, pontuacao);
        this.alturaBanco = alturaBanco;
        int cont = getContador();
        setContador(cont++);
    }

}
