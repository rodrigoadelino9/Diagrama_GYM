public class NotificadorWhatsApp implements INotificador {

    @Override
    public void enviar(Usuario usuario, String mensagem) {
        System.out.println("[WhatsApp] para " + usuario.getTelefone()
                + ": " + mensagem);
    }
}
