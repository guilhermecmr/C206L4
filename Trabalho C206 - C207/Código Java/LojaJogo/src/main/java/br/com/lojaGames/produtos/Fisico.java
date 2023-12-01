package br.com.lojaGames.produtos;

public class Fisico extends Jogo
{
    //declaracao do membro da classe
    private boolean usado;

    //construtor com parametros
    public Fisico(String nome, String codigoDeBarra, int estoque, float preco, byte classificacaoIndicativa, String estudio, String console, boolean usado)
    {
        //para os membros da superclasse
        super(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console);

        //para o membro da subclasse
        this.usado = usado;
    }

    //getter booleano
    public boolean isUsado()
    {
        return usado;
    }
}