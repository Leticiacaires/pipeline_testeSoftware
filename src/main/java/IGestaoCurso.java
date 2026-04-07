public interface IGestaoCurso {
    void iniciarCurso() throws IllegalStateException;
    void encerrarCurso() throws IllegalStateException;
    String avaliar();
    String obterDetalhes();
}
