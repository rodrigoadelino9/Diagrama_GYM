import java.util.List;

public interface IAgendaRepositorio extends IRepositorio<Agenda> {

    List<Agenda> listarDisponiveis(Long idPersonal, java.time.LocalDate data);
}
