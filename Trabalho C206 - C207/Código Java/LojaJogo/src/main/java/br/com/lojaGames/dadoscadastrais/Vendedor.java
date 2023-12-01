package br.com.lojaGames.dadoscadastrais;

public class Vendedor
{
    //declaracao do membros da classe
    private String nome;
    private int id;
    private float bonus;

    //construtor
    public Vendedor(String nome, int id, float bonus)
    {
        this.nome = nome;
        this.id = id;
        this.bonus = bonus;
    }

    //getters
    public String getNome()
    {
        return nome;
    }

    public int getId()
    {
        return id;
    }

    public float getBonus()
    {
        return bonus;
    }
}