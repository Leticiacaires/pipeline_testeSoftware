public class CursoBateria extends Curso {

    private int tempoAPM;
    private int numeroTecnicas;

    public CursoBateria(String nomeCurso, int duracao, int numeroAlunos) {
        super(nomeCurso, duracao, numeroAlunos);
        this.tempoAPM = 60;
        this.numeroTecnicas = 0;
    }

    @Override
    public String avaliar() {
        if (!this.isIniciado()) {
            return "Erro: Curso não iniciado. Não é possível avaliar.";
        }

        double notaTempo = (tempoAPM / 200.0) * 6;
        double notaTecnicas = (numeroTecnicas / 10.0) * 4;
        double notaFinal = Math.min(notaTempo + notaTecnicas, 10);

        return String.format(
            "Avaliação Bateria: Tempo: %d BPM | Técnicas: %d/10 | Nota: %.2f",
            tempoAPM,
            numeroTecnicas,
            notaFinal
        );
    }

    @Override
    public String obterDetalhes() {
        return super.obterDetalhes() + " | Tempo: " + tempoAPM + " BPM | Técnicas: " + numeroTecnicas + "/10";
    }

    public int getTempoAPM() {
        return tempoAPM;
    }

    public void aumentarTempo(int aumento) {
        if (tempoAPM + aumento <= 200) {
            tempoAPM += aumento;
            System.out.println("Tempo aumentado para " + tempoAPM + " BPM!");
        } else {
            System.out.println("Tempo máximo é 200 BPM!");
        }
    }

    public int getNumeroTecnicas() {
        return numeroTecnicas;
    }

    public void aprenderTecnica() {
        if (numeroTecnicas < 10) {
            numeroTecnicas++;
            System.out.println("Nova técnica aprendida! Total: " + numeroTecnicas + "/10");
        } else {
            System.out.println("Máximo de técnicas já foi atingido!");
        }
    }
}
