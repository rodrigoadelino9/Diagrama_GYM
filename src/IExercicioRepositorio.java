import java.util.List;

public interface IExercicioRepositorio extends IRepositorio<Exercicio> {

    List<Exercicio> listarPorGrupoMuscular(GrupoMuscular grupoMuscular);
}
