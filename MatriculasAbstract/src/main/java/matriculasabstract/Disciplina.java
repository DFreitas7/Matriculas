package matriculasabstract;

import java.util.HashMap;

public class Disciplina extends Matriculavel<Aluno> {
    private final String codigo;
    private final int cargaHoraria;

    public Disciplina(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.matriculas = new HashMap<>();
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
        for (Aluno aluno : matriculas.values()) {
            System.out.println(aluno.getNome() + "(" + aluno.getMatricula() + ")");
        }
    }
}
