public class CursoGuitarra extends Curso {

    private String tipoGuitarra;
    private int numeroAcordes;

    public CursoGuitarra(String nomeCurso, int duracao, int numeroAlunos, String tipoGuitarra) {
        super(nomeCurso, duracao, numeroAlunos);
        this.tipoGuitarra = tipoGuitarra;
        this.numeroAcordes = 0;
    }

    @Override
    public String avaliar() {
        if (!this.isIniciado()) {
            return "Erro: Curso não iniciado. Não é possível avaliar.";
        }

        double notaAcordes = (numeroAcordes / 12.0) * 10;
        double notaFinal = Math.min(notaAcordes, 10);

        return String.format(
            "Avaliação Guitarra (%s): Acordes dominados: %d/12 | Nota: %.2f",
            tipoGuitarra,
            numeroAcordes,
            notaFinal
        );
    }

    @Override
    public String obterDetalhes() {
        return super.obterDetalhes() + " | Tipo: " + tipoGuitarra + " | Acordes aprendidos: " + numeroAcordes;
    }

    public String getTipoGuitarra() {
        return tipoGuitarra;
    }

    public void setTipoGuitarra(String tipoGuitarra) {
        this.tipoGuitarra = tipoGuitarra;
    }

    public int getNumeroAcordes() {
        return numeroAcordes;
    }

    public void adicionarAcorde() {
        if (numeroAcordes < 12) {
            numeroAcordes++;
            System.out.println("Novo acorde aprendido! Total: " + numeroAcordes + "/12");
        } else {
            System.out.println("Máximo de acordes já foi atingido!");
        }
    }
}
