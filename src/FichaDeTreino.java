import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FichaDeTreino {

    private Long id;
    private String nome;
    private TipoTreino tipo;
    private LocalDate dataCriacao;

    private final List<ExercicioTreino> exercicios = new ArrayList<>();

    public FichaDeTreino() {
    }

    public FichaDeTreino(Long id, String nome,
                         TipoTreino tipo,
                         LocalDate dataCriacao) {

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
    }

    public void adicionarExercicio(ExercicioTreino exercicio) {
        exercicios.add(exercicio);
    }

    public void removerExercicio(ExercicioTreino exercicio) {
        exercicios.remove(exercicio);
    }

    public double gerarVolumeTotal() {
        double total = 0;

        for (ExercicioTreino exercicio : exercicios) {
            total += exercicio.getVolume();
        }

        return total;
    }

    public int getTempoEstimadoMinutos() {
        int total = 0;

        for (ExercicioTreino exercicio : exercicios) {
            total += exercicio.getTempoEstimadoMinutos();
        }

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoTreino getTipo() {
        return tipo;
    }

    public void setTipo(TipoTreino tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<ExercicioTreino> getExercicios() {
        return exercicios;
    }
}
