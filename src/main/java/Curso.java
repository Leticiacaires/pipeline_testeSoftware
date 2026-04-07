public abstract class Curso implements IGestaoCurso {

    private String nomeCurso;
    private int duracao;
    private int numeroAlunos;
    private boolean iniciado;
    private boolean encerrado;

    public Curso(String nomeCurso, int duracao, int numeroAlunos) {
        this.nomeCurso = nomeCurso;
        this.duracao = duracao;
        this.numeroAlunos = numeroAlunos;
        this.iniciado = false;
        this.encerrado = false;
    }

    @Override
    public void iniciarCurso() throws IllegalStateException {
        if (iniciado || encerrado) {
            throw new IllegalStateException("Erro: O curso " + nomeCurso + " já foi iniciado ou encerrado!");
        }
        this.iniciado = true;
        System.out.println("Curso '" + nomeCurso + "' iniciado com sucesso!");
    }

    @Override
    public void encerrarCurso() throws IllegalStateException {
        if (!iniciado || encerrado) {
            throw new IllegalStateException("Erro: O curso " + nomeCurso + " não foi iniciado ou já foi encerrado!");
        }
        this.encerrado = true;
        System.out.println("Curso '" + nomeCurso + "' encerrado com sucesso!");
    }

    @Override
    public abstract String avaliar();

    @Override
    public String obterDetalhes() {
        return String.format(
            "Curso: %s | Duração: %d horas | Alunos: %d | Status: %s",
            nomeCurso,
            duracao,
            numeroAlunos,
            iniciado ? (encerrado ? "Encerrado" : "Em andamento") : "Não iniciado"
        );
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getNumeroAlunos() {
        return numeroAlunos;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public boolean isEncerrado() {
        return encerrado;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        if (numeroAlunos > 0) {
            this.numeroAlunos = numeroAlunos;
        } else {
            System.out.println("Erro: Número de alunos deve ser maior que zero!");
        }
    }

    public void setDuracao(int duracao) {
        if (duracao > 0) {
            this.duracao = duracao;
        } else {
            System.out.println("Erro: Duração deve ser maior que zero!");
        }
    }
}
