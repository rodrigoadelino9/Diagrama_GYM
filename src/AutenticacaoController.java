public class AutenticacaoController {

    private final ServicoAutenticacao servicoAutenticacao;

    public AutenticacaoController(ServicoAutenticacao servicoAutenticacao) {
        this.servicoAutenticacao = servicoAutenticacao;
    }

    public Usuario login(String email, String senha) {
        return servicoAutenticacao.autenticar(email, senha);
    }

    public void solicitarRecuperacaoSenha(String email) {
        servicoAutenticacao.gerarTokenRecuperacao(email);
    }
}
