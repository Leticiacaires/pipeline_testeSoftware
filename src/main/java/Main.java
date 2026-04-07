public class Main {

    public static void main(String[] args) {
        System.out.println("  ESCOLA DE MÚSICA ONLINE - SISTEMA DE GERENCIAMENTO");
        System.out.println("-----------------------------------------------------\n");

        try {
            System.out.println("- Criando Cursos via Factory Pattern -\n");

            Curso cursoGuitarra = CursoFactory.criarCurso("guitarra", "Guitarra Básica", 40, 20);
            Curso cursoPiano = CursoFactory.criarCurso("piano", "Piano Intermediário", 60, 15);
            Curso cursoBateria = CursoFactory.criarCurso("bateria", "Bateria Avançada", 50, 10);

            System.out.println("\n- Detalhes dos Cursos -\n");
            exibirDetalhes(cursoGuitarra);
            exibirDetalhes(cursoPiano);
            exibirDetalhes(cursoBateria);

            System.out.println("\n- Iniciando Cursos -\n");
            cursoGuitarra.iniciarCurso();
            cursoPiano.iniciarCurso();
            cursoBateria.iniciarCurso();

            System.out.println("\n- Progresso dos Alunos -\n");
            simularProgressoGuitarra((CursoGuitarra) cursoGuitarra);
            simularProgressoPiano((CursoPiano) cursoPiano);
            simularProgressoBateria((CursoBateria) cursoBateria);

            System.out.println("\n- Detalhes Atualizados dos Cursos -\n");
            exibirDetalhes(cursoGuitarra);
            exibirDetalhes(cursoPiano);
            exibirDetalhes(cursoBateria);

            System.out.println("\n- Avaliações Finais -\n");
            System.out.println(cursoGuitarra.avaliar());
            System.out.println(cursoPiano.avaliar());
            System.out.println(cursoBateria.avaliar());

            System.out.println("\n- Encerrando Cursos -\n");
            cursoGuitarra.encerrarCurso();
            cursoPiano.encerrarCurso();
            cursoBateria.encerrarCurso();

            System.out.println("\n- Testando Tratamento de Exceção -\n");
            tentarEncerrarDuplicado(cursoPiano);

            System.out.println("\n- Testando Tipo de Curso Inválido -\n");
            tentarCriarCursoInvalido();

        } catch (IllegalStateException e) {
            System.out.println("Erro de Estado: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de Argumento: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro Inesperado: " + e.getMessage());
        }

        System.out.println("  FIM DA DEMONSTRAÇÃO");
        System.out.println("-----------------------------------------------------\n");
    }

    private static void exibirDetalhes(Curso curso) {
        System.out.println(curso.obterDetalhes());
    }

    private static void simularProgressoGuitarra(CursoGuitarra curso) {
        System.out.println("Alunos aprendendo Guitarra...");
        for (int i = 0; i < 5; i++) {
            curso.adicionarAcorde();
        }
        System.out.println();
    }

    private static void simularProgressoPiano(CursoPiano curso) {
        System.out.println("Alunos aprendendo Piano...");
        for (int i = 0; i < 4; i++) {
            curso.adicionarOitava();
        }
        curso.desbloquearBimanual();
        System.out.println();
    }

    private static void simularProgressoBateria(CursoBateria curso) {
        System.out.println("Alunos aprendendo Bateria...");
        curso.aumentarTempo(50);
        curso.aumentarTempo(30);
        for (int i = 0; i < 6; i++) {
            curso.aprenderTecnica();
        }
        System.out.println();
    }

    private static void tentarEncerrarDuplicado(Curso curso) {
        try {
            curso.encerrarCurso();
        } catch (IllegalStateException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }

    private static void tentarCriarCursoInvalido() {
        try {
            CursoFactory.criarCurso("violino", "Curso de Violino", 40, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
