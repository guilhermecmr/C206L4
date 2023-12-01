package br.com.lojaGames.produtos;

public class Boneco extends Produto
{
    //declaracao do membro da classe
    private int tamanho;

    //construtor com parametros
    public Boneco(String nome, String codigoDeBarra, int estoque, float preco, int tamanho)
    {
        //para os membros da superclasse
        super(nome, codigoDeBarra, estoque, preco);

        //para o membro da subclasse
        this.tamanho = tamanho;
    }

    //getter
    public int getTamanho()
    {
        return tamanho;
    }
}