package matriculasabstract;

import java.util.HashMap;

public class Curso extends Matriculavel<Aluno> {
    private final String sigla;
    private final HashMap<String, Semestre> semestres;

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.matriculas = new HashMap<>();
        this.semestres = new HashMap<>();
    }

    public String getSigla() {
        return sigla;
    }

    public HashMap<String, Semestre> getSemestres() {
        return semestres;
    }

    public HashMap<String, Aluno> getAlunos() {
        return matriculas;
    }

    Aluno getAluno(String matricula) {
        return matriculas.get(matricula);
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

    public void cadastrarDisciplina(String nomeSemestre, Disciplina disciplina) throws Exception {
        Semestre semestre = semestres.get(nomeSemestre);
        
        semestre.matricular(disciplina.getCodigo(), disciplina);
    }

    public void listarAlunos() {
        System.out.println("Alunos do curso " + this.getNome() + "(" + this.getSigla() + "):");
        for (Aluno aluno : matriculas.values()) {
            System.out.println(aluno.getNome() + "(" + aluno.getMatricula() + ")");
        }
    }

    public void listarSemestres() {
        for (String semestre : semestres.keySet()) {
            System.out.println(semestre);
        }
    }
}
