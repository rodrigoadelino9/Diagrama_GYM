import java.time.LocalDate;

public class AvaliacaoFisica {

    private Long id;
    private double peso;
    private double altura;
    private double imc;
    private double percentualGordura;
    private LocalDate dataAvaliacao;

    public AvaliacaoFisica() {
    }

    public AvaliacaoFisica(Long id, double peso, double altura,
                           double percentualGordura,
                           LocalDate dataAvaliacao) {

        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        this.dataAvaliacao = dataAvaliacao;

        calcularIMC();
    }

    public void calcularIMC() {
        if (altura > 0) {
            imc = peso / (altura * altura);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        calcularIMC();
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        calcularIMC();
    }

    public double getImc() {
        return imc;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }
}
