package matriculasinterfaces;

import java.util.HashMap;

public class Disciplina implements Matriculavel<Aluno> {
    private final String nome;
    private final String codigo;
    private final int cargaHoraria;
    private final HashMap<String, Aluno> alunos;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.alunos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void listarAlunos() {
        System.out.println("Alunos da disciplina " + this.getNome() + "(" + this.getCodigo() + "):");
        for (Aluno aluno : alunos.values()) {
            System.out.println(aluno.getNome() + "(" + aluno.getMatricula() + ")");
        }
    }

    @Override
    public void matricular(Aluno aluno) {
        String matricula = aluno.getMatricula();

        if (alunos.get(matricula) == null) {
            alunos.put(matricula, aluno);
            System.out.println("Matriculando " + aluno.getNome() + " na disciplina " + this.nome + "(" + this.codigo + ")");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " já está matriculado na disciplina " + this.nome + "(" + this.codigo + ")");
        }        
    }

    @Override
    public void cancelarMatricula(Aluno aluno) {
        String matricula = aluno.getMatricula();

        if (alunos.get(matricula) != null) {
            alunos.remove(matricula);
            System.out.println("Cancelando matrícula de " + aluno.getNome() + " na disciplina " + this.nome + "(" + this.codigo + ")");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não está matriculado na disciplina " + this.nome + "(" + this.codigo + ")");
        }
    }
}
