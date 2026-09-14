import java.util.UUID;

public class ServicoAutenticacao {

    private final ICriptografiaSenha criptografia;
    private final INotificador notificador;
    private final IAlunoRepositorio alunoRepositorio;

    public ServicoAutenticacao(ICriptografiaSenha criptografia,
                               INotificador notificador,
                               IAlunoRepositorio alunoRepositorio) {

        this.criptografia = criptografia;
        this.notificador = notificador;
        this.alunoRepositorio = alunoRepositorio;
    }

    public Usuario autenticar(String email, String senha) {

        Usuario usuario = alunoRepositorio.buscarPorEmail(email);

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não encontrado: " + email
            );
        }

        if (!criptografia.verificar(senha, usuario.getSenha())) {
            throw new IllegalArgumentException("Senha inválida.");
        }

        return usuario;
    }

    public String gerarTokenRecuperacao(String email) {

        Usuario usuario = alunoRepositorio.buscarPorEmail(email);

        if (usuario == null) {
            throw new IllegalArgumentException(
                    "Usuário não encontrado: " + email
            );
        }

        String token = UUID.randomUUID().toString();

        notificador.enviar(usuario,
                "Seu código de recuperação de senha é: " + token);

        return token;
    }
}
