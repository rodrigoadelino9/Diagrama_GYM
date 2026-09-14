import java.time.LocalDate;
import java.time.LocalTime;

public class Agenda {

    private Long id;
    private LocalDate data;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private boolean disponivel;
    private Aluno alunoReservou;

    public Agenda() {
    }

    public Agenda(Long id, LocalDate data,
                  LocalTime horarioInicio,
                  LocalTime horarioFim,
                  boolean disponivel) {

        this.id = id;
        this.data = data;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.disponivel = disponivel;
    }

    public void reservar() {
        if (!disponivel) {
            throw new IllegalStateException(
                    "Este horário não está disponível."
            );
        }

        disponivel = false;
    }

    public void reservar(Aluno aluno) {
        reservar();
        alunoReservou = aluno;
    }

    public void liberar() {
        disponivel = true;
        alunoReservou = null;
    }

    public Aluno getAlunoReservou() {
        return alunoReservou;
    }

    public boolean conflito(Agenda outraAgenda) {

        if (!data.equals(outraAgenda.data)) {
            return false;
        }

        return horarioInicio.isBefore(outraAgenda.horarioFim)
                && horarioFim.isAfter(outraAgenda.horarioInicio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
