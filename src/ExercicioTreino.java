public class ExercicioTreino {

    private Long id;
    private int repeticoes;
    private double carga;
    private int series;
    private int descanso;
    private int ordem;

    private Exercicio exercicio;

    public ExercicioTreino() {
    }

    public ExercicioTreino(Long id, Exercicio exercicio,
                           int series, int repeticoes,
                           double carga, int descanso,
                           int ordem) {

        this.id = id;
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
        this.descanso = descanso;
        this.ordem = ordem;
    }

    public double getVolume() {
        return series * repeticoes * carga;
    }

    public void ajustarCarga(double percentual) {
        carga += carga * (percentual / 100);
    }

    public int getTempoEstimadoMinutos() {
        int tempoExecucao = series * repeticoes * 2;
        int tempoDescanso = (series - 1) * descanso;

        return (tempoExecucao + tempoDescanso) / 60;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getDescanso() {
        return descanso;
    }

    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
