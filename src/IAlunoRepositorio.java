import java.util.List;

public interface IAlunoRepositorio extends IRepositorio<Aluno> {

    Aluno buscarPorEmail(String email);

    List<Aluno> listarPorPersonal(Long idPersonal);
}
