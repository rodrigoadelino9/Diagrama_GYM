import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendaController {

    private final IAgendaRepositorio agendaRepositorio;
    private final IAlunoRepositorio alunoRepositorio;
    private final IRepositorio<PersonalTrainer> personalRepositorio;

    public AgendaController(IAgendaRepositorio agendaRepositorio,
                            IAlunoRepositorio alunoRepositorio,
                            IRepositorio<PersonalTrainer> personalRepositorio) {

        this.agendaRepositorio = agendaRepositorio;
        this.alunoRepositorio = alunoRepositorio;
        this.personalRepositorio = personalRepositorio;
    }

    public Agenda abrirHorario(Long idPersonal, LocalDate data,
                               LocalTime inicio, LocalTime fim) {

        PersonalTrainer personal = personalRepositorio.buscarPorId(idPersonal);

        if (personal == null) {
            throw new IllegalArgumentException(
                    "Personal não encontrado: " + idPersonal
            );
        }

        if (!inicio.isBefore(fim)) {
            throw new IllegalArgumentException(
                    "O horário inicial deve ser anterior ao final."
            );
        }

        Agenda novaAgenda = new Agenda(null, data, inicio, fim, true);

        List<Agenda> agendasDoDia =
                agendaRepositorio.listarDisponiveis(idPersonal, data);

        for (Agenda agenda : agendasDoDia) {
            if (agenda.conflito(novaAgenda)) {
                throw new IllegalStateException(
                        "O horário informado conflita com outro já aberto."
                );
            }
        }

        return agendaRepositorio.salvar(novaAgenda);
    }

    public void reservarHorario(Long idAgenda, Long idAluno) {

        Agenda agenda = agendaRepositorio.buscarPorId(idAgenda);

        if (agenda == null) {
            throw new IllegalArgumentException(
                    "Agenda não encontrada: " + idAgenda
            );
        }

        Aluno aluno = alunoRepositorio.buscarPorId(idAluno);

        if (aluno == null) {
            throw new IllegalArgumentException(
                    "Aluno não encontrado: " + idAluno
            );
        }

        agenda.reservar(aluno);

        agendaRepositorio.salvar(agenda);
    }
}
