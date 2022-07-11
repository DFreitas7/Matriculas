package matriculasinterfaces;

import java.util.HashMap;

public class Curso implements Matriculavel<Aluno> {
    private final String nome;
    private final String sigla;
    private final HashMap<String, Aluno> alunos;
    private final HashMap<String, Semestre> semestres;

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.alunos = new HashMap<>();
        this.semestres = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public HashMap<String, Semestre> getSemestres() {
        return semestres;
    }

    public HashMap<String, Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public void matricular(Aluno aluno) {
        String matricula = aluno.getMatricula();

        if (alunos.get(matricula) == null) {
            alunos.put(matricula, aluno);
            System.out.println("Matriculando " + aluno.getNome() + " no curso " + this.getNome() + "(" + this.getSigla() + ")");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " já está matriculado no curso " + this.getNome() + "(" + this.getSigla() + ")");
        }
    }

    @Override
    public void cancelarMatricula(Aluno aluno) {
        String matricula = aluno.getMatricula();

        if (alunos.get(matricula) != null) {
            alunos.remove(matricula);
            System.out.println("Cancelando matrícula de " + aluno.getNome() + " no curso " + this.getNome() + "(" + this.getSigla() + ")");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não está matriculado no curso " + this.getNome() + "(" + this.getSigla() + ")");
        }
    }

    Aluno getAluno(String matricula) {
        return alunos.get(matricula);
    }

    Semestre getSemestre(String nome) {
        return semestres.get(nome);
    }

    public void cadastrarSemestre(Semestre semestre) {
        if (semestres.get(semestre.getNome()) == null) {
            semestres.put(semestre.getNome(), semestre);
            System.out.println("Cadastrando semestre " + semestre.getNome() + " no curso " + this.getNome() + "(" + this.getSigla() + ")");
        } else {
            System.out.println("Semestre " + semestre.getNome() + " já cadastrado no curso " + this.getNome() + "(" + this.getSigla() + ")");
        }
    }
    public void removerSemestre(Semestre semestre) {
        if (semestres.get(semestre.getNome()) != null) {
            semestres.remove(semestre.getNome());
            System.out.println("Removendo semestre " + semestre.getNome() + " do curso " + this.getNome() + "(" + this.getSigla() + ")");
        } else {
            System.out.println("Semestre " + semestre.getNome() + " não cadastrado no curso " + this.getNome() + "(" + this.getSigla() + ")");
        }
    }

    public void cadastrarDisciplina(String nomeSemestre, Disciplina disciplina) {
        Semestre semestre = semestres.get(nomeSemestre);
        
        semestre.matricular(disciplina);
    }

    public void listarAlunos() {
        System.out.println("Alunos do curso " + this.getNome() + "(" + this.getSigla() + "):");
        for (Aluno aluno : alunos.values()) {
            System.out.println(aluno.getNome() + "(" + aluno.getMatricula() + ")");
        }
    }

    public void listarSemestres() {
        for (String semestre : semestres.keySet()) {
            System.out.println(semestre);
        }
    }
}
