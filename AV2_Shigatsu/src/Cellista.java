public class Cellista extends Musico implements Som{

    private boolean sentado;

    @Override
    public void tocar() {
        System.out.println("Tocando o Cello.");
    }

    @Override
    public void mostraInfo(){
        super.mostraInfo();
        if(sentado){
            System.out.println("Está sentado.");
        }else{
            System.out.println("Não está sentado.");
        }
    }

    public boolean isSentado() {
        return sentado;
    }

    public Cellista(int codigo, String nome, int idade, String musica, int pontuacao,boolean sentado) {
        super(codigo, nome, idade, musica, pontuacao);
        this.sentado = sentado;
        int cont = getContador();
        setContador(cont++);
    }

    @Override
    public void desafiar() {
        pontuacao = pontuacao - 5;
    }
}