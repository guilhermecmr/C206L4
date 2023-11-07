public class Veiculo implements Comparable<Veiculo>{

    private String marca;
    private String modelo;
    private int ano;
    private double kmRodados;
    private Motor motor;

    public void mostraInfos(){

        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Kilometros rodados: " + kmRodados);
        System.out.println("Potência do motor: " + motor.getPotencia());
        System.out.println("Numero de cilindros do motor: " + motor.getNumCilindros());
        System.out.println();

    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getKmRodados() {
        return kmRodados;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public int compareTo(Veiculo v) {
        return Integer.compare(this.ano,v.getAno());
    }
}
