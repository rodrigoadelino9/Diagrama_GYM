import java.time.LocalDate;
import java.util.List;

public class MontadorEmagrecimento implements IMontadorDeTreino {

    private static final GrupoMuscular[] GRUPOS = {
        GrupoMuscular.PERNAS,
        GrupoMuscular.GLUTEOS,
        GrupoMuscular.ABDOMEN,
        GrupoMuscular.COSTAS,
        GrupoMuscular.PEITO
    };

    private static final int SERIES = 3;
    private static final int REPETICOES = 15;
    private static final int DESCANSO_SEGUNDOS = 45;

    private final IExercicioRepositorio exercicioRepositorio;

    public MontadorEmagrecimento(IExercicioRepositorio exercicioRepositorio) {
        this.exercicioRepositorio = exercicioRepositorio;
    }

    @Override
    public boolean atendeObjetivo(Objetivo objetivo) {
        return objetivo == Objetivo.EMAGRECIMENTO;
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
                "Treino de Emagrecimento - " + aluno.getNome(),
                TipoTreino.B,
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
