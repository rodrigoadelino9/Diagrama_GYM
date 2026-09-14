import java.util.List;

public interface IRepositorio<T> {

    T salvar(T entidade);

    T buscarPorId(Long id);

    List<T> listarTodos();

    void remover(Long id);
}
