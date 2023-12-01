package br.com.lojaGames.produtos;

public abstract class Jogo extends Produto
{
    //declaracao do membros da classe
    private byte classificacaoIndicativa;
    private String estudio, console;

    //construtor com parametros
    public Jogo(String nome, String codigoDeBarra, int estoque, float preco, byte classificacaoIndicativa, String estudio, String console)
    {
        //para os membros da superclasse
        super(nome, codigoDeBarra, estoque, preco);

        //para os membros da subclasse
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.estudio = estudio;
        this.console = console;
    }

    //getters
    public byte getClassificacaoIndicativa()
    {
        return classificacaoIndicativa;
    }

    public String getEstudio()
    {
        return estudio;
    }

    public String getConsole()
    {
        return console;
    }
}