public class Exercicio {

    private Long id;
    private String nome;
    private GrupoMuscular grupoMuscular;
    private NivelDificuldade nivelDificuldade;
    private String descricao;
    private String equipamento;
    private String imagemUrl;

    public Exercicio() {
    }

    public Exercicio(Long id, String nome,
                     GrupoMuscular grupoMuscular,
                     NivelDificuldade nivelDificuldade,
                     String descricao,
                     String equipamento,
                     String imagemUrl) {

        this.id = id;
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.nivelDificuldade = nivelDificuldade;
        this.descricao = descricao;
        this.equipamento = equipamento;
        this.imagemUrl = imagemUrl;
    }

    public boolean ehAdequadoPara(NivelExperiencia nivel) {
        if (nivel == null || nivelDificuldade == null) {
            return false;
        }

        return switch (nivel) {
            case INICIANTE ->
                    nivelDificuldade == NivelDificuldade.INICIANTE;

            case INTERMEDIARIO ->
                    nivelDificuldade != NivelDificuldade.AVANCADO;

            case AVANCADO ->
                    true;
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public NivelDificuldade getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(NivelDificuldade nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
