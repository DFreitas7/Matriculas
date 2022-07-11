package matriculasabstract;

import java.util.HashMap;

public class Semestre extends Matriculavel<Disciplina> {

    public Semestre(String nome) {
        this.nome = nome;
        this.matriculas = new HashMap<>();
    }
    
    public HashMap<String, Disciplina> getDisciplinas() {
        return matriculas;
    }

    public Disciplina getDisciplina(String codigo) {
        return matriculas.get(codigo);
    }

    public void listarDisciplinas() {
        System.out.println("Disciplinas do semestre " + this.nome + ":");
        for (Disciplina disciplina : matriculas.values()) {
            System.out.println(disciplina.getNome() + "(" + disciplina.getCodigo() + ")");
        }
    }
}
