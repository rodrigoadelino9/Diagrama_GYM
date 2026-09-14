import java.time.LocalDate;
import java.util.List;

public class MontadorReabilitacao implements IMontadorDeTreino {

    private static final GrupoMuscular[] GRUPOS = {
        GrupoMuscular.ABDOMEN,
        GrupoMuscular.COSTAS,
        GrupoMuscular.GLUTEOS
    };

    private static final int SERIES = 2;
    private static final int REPETICOES = 12;
    private static final int DESCANSO_SEGUNDOS = 120;

    private final IExercicioRepositorio exercicioRepositorio;

    public MontadorReabilitacao(IExercicioRepositorio exercicioRepositorio) {
        this.exercicioRepositorio = exercicioRepositorio;
    }

    @Override
    public boolean atendeObjetivo(Objetivo objetivo) {
        return objetivo == Objetivo.REABILITACAO;
    }

    @Override
    public FichaDeTreino montar(Aluno aluno) {

        if (!atendeObjetivo(aluno.getObjetivo())) {
            throw new IllegalArgumentException(
                    "Este montador não atende ao objetivo do aluno."
            );
        }

        FichaDeTreino ficha = new FichaDeTreino(
                null,
                "Treino de Reabilitacao - " + aluno.getNome(),
                TipoTreino.D,
                LocalDate.now()
        );

        int ordem = 1;

        for (GrupoMuscular grupo : GRUPOS) {

            List<Exercicio> exercicios =
                    exercicioRepositorio.listarPorGrupoMuscular(grupo);

            for (Exercicio exercicio : exercicios) {

                if (!exercicio.ehAdequadoPara(aluno.getNivelExperiencia())) {
                    continue;
                }

                ficha.adicionarExercicio(new ExercicioTreino(
                        null,
                        exercicio,
                        SERIES,
                        REPETICOES,
                        0,
                        DESCANSO_SEGUNDOS,
                        ordem++
                ));
            }
        }

        return ficha;
    }
}
