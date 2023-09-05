public class Produto {

    int codigoSerie;
    String nome;
    String categoria;
    int quantidade;
    double valor;

    void mostrarInfos(){
        System.out.println("Código de série: " + codigoSerie);
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor: " + valor);
    }

}
