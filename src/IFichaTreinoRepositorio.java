import java.util.List;

public interface IFichaTreinoRepositorio extends IRepositorio<FichaDeTreino> {

    List<FichaDeTreino> listarPorAluno(Long idAluno);
}
