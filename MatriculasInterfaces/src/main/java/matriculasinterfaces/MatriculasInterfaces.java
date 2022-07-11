package matriculasinterfaces;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class MatriculasInterfaces {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Integer comando;
            Integer sequencialMatricula = 100;
            Curso curso = new Curso("Tecnólogo em Sistemas para Internet", "TSI");
            
            System.out.println("Bem vindo ao gerenciador de matriculas do curso " + curso.getNome() + "(" + curso.getSigla() + ")");
            
            do {
                System.out.println("Digite um comando:\n");
                System.out.println("1 - Matricular aluno");
                System.out.println("2 - Cancelar matricula de aluno");
                System.out.println("3 - Cadastrar semestre");
                System.out.println("4 - Remover semestre");
                System.out.println("5 - Cadastrar disciplina");
                System.out.println("6 - Remover disciplina");
                System.out.println("7 - Matricular aluno em disciplina");
                System.out.println("8 - Cancelar matricula de aluno em disciplina");
                System.out.println("9 - Listar alunos");
                System.out.println("10 - Listar semestres");
                System.out.println("11 - Listar disciplinas de um semestre");
                System.out.println("12 - Listar alunos de uma disciplina");
                
                comando = Integer.parseInt(scanner.nextLine());
                limparTela();
                String nomeAluno, matriculaAluno, nomeSemestre, nomeDisciplina, codigoDisciplina;
                Semestre semestre;
                Disciplina disciplina;
                
                switch (comando) {
                    case 1:  // Matricular aluno
                        System.out.println("Digite o nome do aluno:");
                        nomeAluno = scanner.nextLine();
                        LocalDate hoje = LocalDate.now();
                        DecimalFormat decFormat = new DecimalFormat("000");
                        matriculaAluno = hoje.getYear() + "128480" + decFormat.format(sequencialMatricula++);
                        
                        curso.matricular(new Aluno(nomeAluno, matriculaAluno));
                        break;
                    case 2: // Cancelar matricula de aluno
                        System.out.println("Digite a matricula do aluno:");
                        curso.listarAlunos();
                        matriculaAluno = scanner.nextLine();
                        curso.cancelarMatricula(curso.getAluno(matriculaAluno));
                        break;
                    case 3:  // Cadastrar semestre
                        System.out.println("Digite o nome do semestre:");
                        nomeSemestre = scanner.nextLine();
                        curso.cadastrarSemestre(new Semestre(nomeSemestre));
                        break;
                    case 4: // Remover semestre
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        curso.removerSemestre(curso.getSemestre(nomeSemestre));
                    case 5: // Cadastrar disciplina
                        if (curso.getSemestres().isEmpty()) {
                            System.out.println("Não há semestres cadastrados no curso " + curso.getNome() + "(" + curso.getSigla() + ")");
                            break;
                        }
                        System.out.println("Digite o nome da disciplina:");
                        nomeDisciplina = scanner.nextLine();
                        System.out.println("Digite o código da disciplina:");
                        codigoDisciplina = scanner.nextLine();
                        System.out.println("Digite a carga horária da disciplina:");
                        Integer cargaHoraria = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        String nomeSemestreDisciplina = scanner.nextLine();
                        curso.cadastrarDisciplina(nomeSemestreDisciplina, new Disciplina(nomeDisciplina, codigoDisciplina, cargaHoraria));
                        break;
                    case 6: // Remover disciplina
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        semestre = curso.getSemestre(nomeSemestre);
                        System.out.println("Digite o nome da disciplina:");
                        semestre.listarDisciplinas();
                        nomeDisciplina = scanner.nextLine();
                        semestre.cancelarMatricula(semestre.getDisciplina(nomeDisciplina));
                    case 7: // Matricular aluno em disciplina
                        if (curso.getAlunos().isEmpty()) {
                            System.out.println("Não há alunos cadastrados no curso " + curso.getNome() + "(" + curso.getSigla() + ")");
                            break;
                        }
                        
                        if (curso.getSemestres().isEmpty()) {
                            System.out.println("Não há semestres cadastrados no curso " + curso.getNome() + "(" + curso.getSigla() + ")");
                            break;
                        }
                        
                        System.out.println("Digite a matricula do aluno:");
                        curso.listarAlunos();
                        matriculaAluno = scanner.nextLine();
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        System.out.println("Digite o codigo da disciplina:");
                        semestre = curso.getSemestre(nomeSemestre);
                        
                        if (semestre.getDisciplinas().isEmpty()) {
                            System.out.println("Não há disciplinas cadastradas no semestre " + semestre.getNome());
                            break;
                        }
                        
                        semestre.listarDisciplinas();
                        codigoDisciplina = scanner.nextLine();
                        semestre.getDisciplina(codigoDisciplina).matricular(curso.getAluno(matriculaAluno));
                        break;
                    case 8: // Cancelar matricula de aluno em disciplina
                        System.out.println("Digite a matricula do aluno:");
                        curso.listarAlunos();
                        matriculaAluno = scanner.nextLine();
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        semestre = curso.getSemestre(nomeSemestre);
                        System.out.println("Digite o codigo da disciplina:");
                        semestre.listarDisciplinas();
                        codigoDisciplina = scanner.nextLine();
                        disciplina = semestre.getDisciplina(codigoDisciplina);
                        disciplina.cancelarMatricula(curso.getAluno(matriculaAluno));
                    case 9: // Listar alunos
                        curso.listarAlunos();
                        break;
                    case 10: // Listar semestres
                        curso.listarSemestres();
                        break;
                    case 11: // Listar disciplinas de um semestre
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        curso.getSemestre(nomeSemestre).listarDisciplinas();
                    case 12: // Listar alunos de uma disciplina
                        System.out.println("Digite o nome do semestre:");
                        curso.listarSemestres();
                        nomeSemestre = scanner.nextLine();
                        semestre = curso.getSemestre(nomeSemestre);
                        System.out.println("Digite o codigo da disciplina:");
                        semestre.listarDisciplinas();
                        codigoDisciplina = scanner.nextLine();
                        semestre.getDisciplina(codigoDisciplina).listarAlunos();
                    default: break;
                }
                
            } while(comando != 0);
        }
    }

    private static void limparTela() throws Exception {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }
}
