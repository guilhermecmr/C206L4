package br.com.lojaGames.produtos;

public class Colecionador extends Jogo
{
    //declaracao do membros da classe
    private boolean figure, steelBook, ost;

    //construtor com parametros
    public Colecionador(String nome, String codigoDeBarra, int estoque, float preco, byte classificacaoIndicativa, String estudio, String console, boolean figure, boolean steelBook, boolean ost)
    {
        //para os membros da superclasse
        super(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console);

        //para os membros da subclasse
        this.figure = figure;
        this.steelBook = steelBook;
        this.ost = ost;
    }

    //getters booleanos
    public boolean isFigure()
    {
        return figure;
    }

    public boolean isSteelBook()
    {
        return steelBook;
    }

    public boolean isOst()
    {
        return ost;
    }
}