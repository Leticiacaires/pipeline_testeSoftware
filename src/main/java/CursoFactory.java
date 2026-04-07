public class CursoFactory {

    public static Curso criarCurso(String tipo, String nomeCurso, int duracao, int numeroAlunos)
            throws IllegalArgumentException {

        if (tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Erro: Tipo de curso não pode ser nulo ou vazio!");
        }

        String tipoNormalizado = tipo.toLowerCase().trim();

        switch (tipoNormalizado) {
            case "guitarra":
                return new CursoGuitarra(nomeCurso, duracao, numeroAlunos, "Acústica");

            case "piano":
                return new CursoPiano(nomeCurso, duracao, numeroAlunos);

            case "bateria":
                return new CursoBateria(nomeCurso, duracao, numeroAlunos);

            default:
                throw new IllegalArgumentException(
                    "Erro: Tipo de curso '" + tipo + "' não reconhecido! " +
                    "Use: guitarra, piano ou bateria."
                );
        }
    }

    public static CursoGuitarra criarCursoGuitarra(String nomeCurso, int duracao,
                                                    int numeroAlunos, String tipoGuitarra) {
        return new CursoGuitarra(nomeCurso, duracao, numeroAlunos, tipoGuitarra);
    }

    public static void listarTiposDisponiveis() {
        System.out.println("\n- Tipos de Cursos Disponíveis -");
        System.out.println("1. guitarra - Curso de Guitarra");
        System.out.println("2. piano - Curso de Piano");
        System.out.println("3. bateria - Curso de Bateria");
        System.out.println("----------------------------------\n");
    }
}
