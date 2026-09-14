import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

    private Objetivo objetivo;
    private NivelExperiencia nivelExperiencia;
    private StatusMatricula statusMatricula;
    private LocalDate dataMatricula;
    private String restricoes;

    private final List<FichaDeTreino> fichas = new ArrayList<>();
    private final List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    private final List<HistoricoTreino> historico = new ArrayList<>();

    private PersonalTrainer personalTrainer;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String email,
                 String senha, String telefone,
                 Objetivo objetivo,
                 NivelExperiencia nivelExperiencia,
                 StatusMatricula statusMatricula,
                 LocalDate dataMatricula,
                 String restricoes) {

        super(id, nome, email, senha, telefone);

        this.objetivo = objetivo;
        this.nivelExperiencia = nivelExperiencia;
        this.statusMatricula = statusMatricula;
        this.dataMatricula = dataMatricula;
        this.restricoes = restricoes;
    }

    public void adicionarFicha(FichaDeTreino ficha) {
        fichas.add(ficha);
    }

    public void registrarAvaliacaoFisica(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void registrarHistorico(HistoricoTreino treino) {
        historico.add(treino);
    }

    public List<FichaDeTreino> getFichas() {
        return fichas;
    }

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public List<HistoricoTreino> getHistorico() {
        return historico;
    }

    public PersonalTrainer getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(PersonalTrainer personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    @Override
    public String getPerfil() {
        return "Aluno";
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public NivelExperiencia getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(NivelExperiencia nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }
}
