public class Conta {

    private double saldo;

    private static int qtdClientes;

    void deposita(double valor){
        this.saldo += valor;
    }

    void saca(double valor){
        this.saldo -= valor;
    }

    void extrato(){
        System.out.println("Extrato: " + saldo);
    }

    public Conta() {
        qtdClientes++;
    }

}
