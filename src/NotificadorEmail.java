public class NotificadorEmail implements INotificador {

    @Override
    public void enviar(Usuario usuario, String mensagem) {
        System.out.println("[E-mail] para " + usuario.getEmail()
                + ": " + mensagem);
    }
}
