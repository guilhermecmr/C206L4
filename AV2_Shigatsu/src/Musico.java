public abstract class Musico {

    private static int contador;
    private int codigo;
    private String nome;
    private int idade;
    private String musica;
    protected int pontuacao;

    public abstract void tocar();

    public void mostraInfo() {
        System.out.println("Contador: " + contador);
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Musica: " + musica);
        System.out.println("Pontuacao: " + pontuacao);
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Musico.contador = contador;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Musico(int codigo, String nome, int idade, String musica, int pontuacao) {
        contador++;
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.musica = musica;
        this.pontuacao = pontuacao;
    }
}