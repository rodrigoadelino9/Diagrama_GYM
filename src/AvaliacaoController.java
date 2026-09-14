import java.time.LocalDate;
import java.util.List;

public class AvaliacaoController {

    private final IAlunoRepositorio alunoRepositorio;

    public AvaliacaoController(IAlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    public AvaliacaoFisica registrarAvaliacao(Long idAluno,
                                              double peso,
                                              double altura) {

        Aluno aluno = buscarAluno(idAluno);

        AvaliacaoFisica avaliacao = new AvaliacaoFisica(
                null, peso, altura, 0, LocalDate.now()
        );

        aluno.registrarAvaliacaoFisica(avaliacao);

        alunoRepositorio.salvar(aluno);

        return avaliacao;
    }

    public List<AvaliacaoFisica> listarEvolucao(Long idAluno) {
        return buscarAluno(idAluno).getAvaliacoes();
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
