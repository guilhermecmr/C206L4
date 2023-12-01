package br.com.lojaGames.produtos;

public class Digital extends Jogo
{
    //declaracao do membro da classe
    private int anoExpiracao;

    //construtor com parametros
    public Digital(String nome, String codigoDeBarra, int estoque, float preco, byte classificacaoIndicativa, String estudio, String console, int anoExpiracao)
    {
        //para os membros da superclasse
        super(nome, codigoDeBarra, estoque, preco, classificacaoIndicativa, estudio, console);

        //para o membro da subclasse
        this.anoExpiracao = anoExpiracao;
    }

    //getter
    public int getAnoExpiracao()
    {
        return anoExpiracao;
    }
}