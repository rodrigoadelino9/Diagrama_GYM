import java.time.LocalDate;

public class TreinoController {

    private final IAlunoRepositorio alunoRepositorio;
    private final IFichaTreinoRepositorio fichaRepositorio;
    private final IExercicioRepositorio exercicioRepositorio;
    private final IRepositorio<PersonalTrainer> personalRepositorio;

    public TreinoController(IAlunoRepositorio alunoRepositorio,
                            IFichaTreinoRepositorio fichaRepositorio,
                            IExercicioRepositorio exercicioRepositorio,
                            IRepositorio<PersonalTrainer> personalRepositorio) {

        this.alunoRepositorio = alunoRepositorio;
        this.fichaRepositorio = fichaRepositorio;
        this.exercicioRepositorio = exercicioRepositorio;
        this.personalRepositorio = personalRepositorio;
    }

    public FichaDeTreino gerarFicha(Long idAluno, Long idPersonal,
                                    IMontadorDeTreino montador) {

        Aluno aluno = buscarAluno(idAluno);

        PersonalTrainer personal = personalRepositorio.buscarPorId(idPersonal);

        if (personal == null) {
            throw new IllegalArgumentException(
                    "Personal não encontrado: " + idPersonal
            );
        }

        if (!montador.atendeObjetivo(aluno.getObjetivo())) {
            throw new IllegalArgumentException(
                    "O montador escolhido não atende ao objetivo do aluno."
            );
        }

        FichaDeTreino ficha = fichaRepositorio.salvar(montador.montar(aluno));

        aluno.adicionarFicha(ficha);

        return ficha;
    }

    public void adicionarExercicio(Long idFicha, Long idExercicio,
                                   int series, int repeticoes,
                                   double carga) {

        FichaDeTreino ficha = fichaRepositorio.buscarPorId(idFicha);

        if (ficha == null) {
            throw new IllegalArgumentException(
                    "Ficha não encontrada: " + idFicha
            );
        }

        Exercicio exercicio = exercicioRepositorio.buscarPorId(idExercicio);

        if (exercicio == null) {
            throw new IllegalArgumentException(
                    "Exercício não encontrado: " + idExercicio
            );
        }

        ficha.adicionarExercicio(new ExercicioTreino(
                null,
                exercicio,
                series,
                repeticoes,
                carga,
                60,
                ficha.getExercicios().size() + 1
        ));

        fichaRepositorio.salvar(ficha);
    }

    public HistoricoTreino registrarExecucao(Long idAluno, Long idFicha) {

        Aluno aluno = buscarAluno(idAluno);

        if (aluno.getStatusMatricula() != StatusMatricula.ATIVA) {
            throw new IllegalStateException(
                    "Aluno sem matrícula ativa não pode treinar."
            );
        }

        FichaDeTreino ficha = fichaRepositorio.buscarPorId(idFicha);

        if (ficha == null) {
            throw new IllegalArgumentException(
                    "Ficha não encontrada: " + idFicha
            );
        }

        HistoricoTreino historico = new HistoricoTreino(
                null,
                LocalDate.now(),
                false,
                "",
                ficha
        );

        aluno.registrarHistorico(historico);

        return historico;
    }

    private Aluno buscarAluno(Long idAluno) {

        Aluno aluno = alunoRepositorio.buscarPorId(idAluno);

        if (aluno == null) {
            throw new IllegalArgumentException(
                    "Aluno não encontrado: " + idAluno
            );
        }

        return aluno;
    }
}
