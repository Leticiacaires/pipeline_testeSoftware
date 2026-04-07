public class CursoPiano extends Curso {

    private int numeroOitavas;
    private boolean teclaCoisas;

    public CursoPiano(String nomeCurso, int duracao, int numeroAlunos) {
        super(nomeCurso, duracao, numeroAlunos);
        this.numeroOitavas = 0;
        this.teclaCoisas = false;
    }

    @Override
    public String avaliar() {
        if (!this.isIniciado()) {
            return "Erro: Curso não iniciado. Não é possível avaliar.";
        }

        double notaOitavas = (numeroOitavas / 8.0) * 7;
        double notaBimanual = teclaCoisas ? 3 : 0;
        double notaFinal = Math.min(notaOitavas + notaBimanual, 10);

        return String.format(
            "Avaliação Piano: Oitavas: %d/8 | Coordenação bimanual: %s | Nota: %.2f",
            numeroOitavas,
            teclaCoisas ? "Sim" : "Não",
            notaFinal
        );
    }

    @Override
    public String obterDetalhes() {
        return super.obterDetalhes() + " | Oitavas dominadas: " + numeroOitavas + "/8" +
               " | Toca com as duas mãos: " + (teclaCoisas ? "Sim" : "Não");
    }

    public int getNumeroOitavas() {
        return numeroOitavas;
    }

    public void adicionarOitava() {
        if (numeroOitavas < 8) {
            numeroOitavas++;
            System.out.println("Nova oitava dominada! Total: " + numeroOitavas + "/8");
        } else {
            System.out.println("Máximo de oitavas já foi atingido!");
        }
    }

    public boolean isTeclaCoisas() {
        return teclaCoisas;
    }

    public void desbloquearBimanual() {
        if (!teclaCoisas) {
            this.teclaCoisas = true;
            System.out.println("Desbloqueou coordenação bimanual!");
        } else {
            System.out.println("Já tem coordenação bimanual desbloqueada!");
        }
    }
}
