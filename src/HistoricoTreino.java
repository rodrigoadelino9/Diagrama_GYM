import java.time.LocalDate;

public class HistoricoTreino {

    private Long id;
    private LocalDate dataExecucao;
    private boolean concluido;
    private String observacoes;

    private FichaDeTreino ficha;

    public HistoricoTreino() {
    }

    public HistoricoTreino(Long id, LocalDate dataExecucao,
                           boolean concluido,
                           String observacoes,
                           FichaDeTreino ficha) {

        this.id = id;
        this.dataExecucao = dataExecucao;
        this.concluido = concluido;
        this.observacoes = observacoes;
        this.ficha = ficha;
    }

    public void marcarConcluido() {
        concluido = true;
    }

    public double getVolumeExecutado() {
        if (ficha == null) {
            return 0;
        }

        return ficha.gerarVolumeTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(LocalDate dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public FichaDeTreino getFicha() {
        return ficha;
    }

    public void setFicha(FichaDeTreino ficha) {
        this.ficha = ficha;
    }
}
