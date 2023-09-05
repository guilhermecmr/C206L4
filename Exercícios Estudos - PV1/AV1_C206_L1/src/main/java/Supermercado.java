public class Supermercado {

    String nome;
    String cnpj;
    String endereco;
    String numTelefone;
    Produto [] produtos = new Produto[30];



    void addProduto(Produto p){
        for(int i = 0; i < produtos.length; i++){
            if(produtos[i] == null) {
                produtos[i] = p;
                break;
            }
        }
    }

    void mostrarMaisCaroBarato(){
        double menorValor = produtos[0].valor;
        int posicaoMenor = 0;
        double maiorValor = 0;
        int posicaoMaior = 0;

        for(int i = 0; i < produtos.length; i++){
            if(produtos[i].valor > maiorValor){
                maiorValor = produtos[i].valor;
                posicaoMaior = i;
            }
            if (produtos[i].valor < menorValor){
                menorValor = produtos[i].valor;
                posicaoMenor = i;
            }
        }
        System.out.println("Dados do produto de menor valor: ");
        produtos[posicaoMenor].mostrarInfos();
        System.out.println("Dados do produto de maior valor: ");
        produtos[posicaoMaior].mostrarInfos();
    }

    void contarCategorias(){
        int qtdHigiene = 0;
        int qtdUtensilios = 0;
        int qtdAlimenticios = 0;

        for(int i = 0; i < produtos.length; i++){
            if(produtos[i].categoria.equalsIgnoreCase("higiene"))
                qtdHigiene++;
            if(produtos[i].categoria.equalsIgnoreCase("utensilios"))
                qtdUtensilios++;
            if(produtos[i].categoria.equalsIgnoreCase("alimenticios"))
                qtdAlimenticios++;
        }
        System.out.println("Itens de higiene: " + qtdHigiene);
        System.out.println("Itens de utensilios: " + qtdUtensilios);
        System.out.println("Itens alimenticios: " + qtdAlimenticios);
    }

    void mostrarInfos(){
        System.out.println(nome);
        System.out.println(cnpj);
        System.out.println(endereco);
        System.out.println(numTelefone);
        for(Produto prod : produtos){
            if(prod != null)
                prod.mostrarInfos();
        }
    }

}
