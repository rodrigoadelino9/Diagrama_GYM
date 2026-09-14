import java.time.LocalDate;

public class PersonalTrainer extends Usuario implements Autenticavel {

    private String cref;
    private String especialidade;
    private LocalDate dataCadastro;
    private String bio;

    public PersonalTrainer() {
    }

    public PersonalTrainer(Long id, String nome, String email,
                           String senha, String telefone,
                           String cref, String especialidade,
                           LocalDate dataCadastro, String bio) {

        super(id, nome, email, senha, telefone);

        this.cref = cref;
        this.especialidade = especialidade;
        this.dataCadastro = dataCadastro;
        this.bio = bio;
    }

    @Override
    public boolean login(String email, String senha) {
        return getEmail().equals(email) && getSenha().equals(senha);
    }

    @Override
    public void recuperarSenha() {
        System.out.println("Recuperação de senha enviada para: "
                + getEmail());
    }

    @Override
    public String getPerfil() {
        return "Personal Trainer";
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
