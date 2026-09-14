import java.time.LocalDate;
import java.util.List;

public class MontadorHipertrofia implements IMontadorDeTreino {

    private static final GrupoMuscular[] GRUPOS = {
        GrupoMuscular.PEITO,
        GrupoMuscular.COSTAS,
        GrupoMuscular.OMBROS,
        GrupoMuscular.BICEPS,
        GrupoMuscular.TRICEPS,
        GrupoMuscular.PERNAS
    };

    private static final int SERIES = 4;
    private static final int REPETICOES = 10;
    private static final int DESCANSO_SEGUNDOS = 90;

    private final IExercicioRepositorio exercicioRepositorio;

    public MontadorHipertrofia(IExercicioRepositorio exercicioRepositorio) {
        this.exercicioRepositorio = exercicioRepositorio;
    }

    @Override
    public boolean atendeObjetivo(Objetivo objetivo) {
        return objetivo == Objetivo.HIPERTROFIA;
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
                "Treino de Hipertrofia - " + aluno.getNome(),
                TipoTreino.A,
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
