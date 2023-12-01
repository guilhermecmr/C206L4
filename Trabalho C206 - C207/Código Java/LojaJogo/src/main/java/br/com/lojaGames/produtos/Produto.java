package br.com.lojaGames.produtos;

public class Produto
{
    //declaracao do membros da classe
    private int estoque;
    private float preco;
    private String nome, codigoDeBarra;

    //construtor com parametros
    public Produto(String nome, String codigoDeBarra, int estoque, float preco)
    {
        this.nome = nome;
        this.codigoDeBarra = codigoDeBarra;
        this.estoque = estoque;
        this.preco = preco;
    }

    //getters
    public String getNome()
    {
        return nome;
    }

    public String getCodigoDeBarra()
    {
        return codigoDeBarra;
    }

    public int getEstoque()
    {
        return estoque;
    }

    public float getPreco()
    {
        return preco;
    }
}