package br.com.lojaGames.dadoscadastrais;

public class Cliente
{
    //declaracao do membros da classe
    private String nome;
    private String telefone;
    private int idVendedor;

    //construtor com parametros
    public Cliente(String nome, String telefone, int idVendedor)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.idVendedor = idVendedor;
    }

    //getters
    public String getNome()
    {
        return nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public int getIdVendedor()
    {
        return idVendedor;
    }
}