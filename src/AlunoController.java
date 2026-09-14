import java.time.LocalDate;

public class AlunoController {

    private final IAlunoRepositorio alunoRepositorio;
    private final IRepositorio<PersonalTrainer> personalRepositorio;

    public AlunoController(IAlunoRepositorio alunoRepositorio,
                           IRepositorio<PersonalTrainer> personalRepositorio) {

        this.alunoRepositorio = alunoRepositorio;
        this.personalRepositorio = personalRepositorio;
    }

    public Aluno matricularAluno(String nome, String email, String senha,
                                 String telefone, Objetivo objetivo,
                                 NivelExperiencia nivelExperiencia,
                                 String restricoes) {

        if (alunoRepositorio.buscarPorEmail(email) != null) {
            throw new IllegalArgumentException(
                    "Já existe um aluno com o e-mail " + email
            );
        }

        Aluno aluno = new Aluno(
                null, nome, email, senha, telefone,
                objetivo, nivelExperiencia,
                StatusMatricula.ATIVA,
                LocalDate.now(),
                restricoes
        );

        return alunoRepositorio.salvar(aluno);
    }

    public void suspenderMatricula(Long idAluno) {

        Aluno aluno = buscarAluno(idAluno);

        aluno.setStatusMatricula(StatusMatricula.SUSPENSA);

        alunoRepositorio.salvar(aluno);
    }

    public void vincularPersonal(Long idAluno, Long idPersonal) {

        Aluno aluno = buscarAluno(idAluno);

        PersonalTrainer personal = personalRepositorio.buscarPorId(idPersonal);

        if (personal == null) {
            throw new IllegalArgumentException(
                    "Personal não encontrado: " + idPersonal
            );
        }

        aluno.setPersonalTrainer(personal);

        alunoRepositorio.salvar(aluno);
    }

    private Aluno buscarAluno(Long idAluno) {

        Aluno aluno = alunoRepositorio.buscarPorId(idAluno);

        if (aluno == null) {
            throw new IllegalArgumentException(
                    "Aluno não encontrado: " + idAluno
            );
        }

        return aluno;
    }
}
