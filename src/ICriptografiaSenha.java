public interface ICriptografiaSenha {

    String gerarHash(String senha);

    boolean verificar(String senha, String hash);
}
