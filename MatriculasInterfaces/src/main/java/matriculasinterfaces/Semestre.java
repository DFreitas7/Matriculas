package matriculasinterfaces;
import java.util.HashMap;

public class Semestre implements Matriculavel<Disciplina> {
    private final String nome;
    private final HashMap<String, Disciplina> disciplinas;

    public Semestre(String nome) {
        this.nome = nome;
        this.disciplinas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }
    
    public HashMap<String, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    @Override
    public void matricular(Disciplina disciplina) {
        String codigo = disciplina.getCodigo();

        if (disciplinas.get(codigo) == null) {
            disciplinas.put(codigo, disciplina);
            System.out.println("Adicionando disciplina " + disciplina.getNome() + " no semestre " + this.nome);
        } else {
            System.out.println("Disciplina " + disciplina.getNome() + " já está cadastrada no semestre " + this.nome);
        }
    }

    @Override
    public void cancelarMatricula(Disciplina disciplina) {
        String codigo = disciplina.getCodigo();

        if (disciplinas.get(codigo) != null) {
            disciplinas.remove(codigo);
            System.out.println("Removendo disciplina " + disciplina.getNome() + " do semestre " + this.nome);
        } else {
            System.out.println("Disciplina " + disciplina.getNome() + " não está cadastrada no semestre " + this.nome);
        }
    }

    public void listarDisciplinas() {
        System.out.println("Disciplinas do semestre " + this.nome + ":");
        for (Disciplina disciplina : disciplinas.values()) {
            System.out.println(disciplina.getNome() + "(" + disciplina.getCodigo() + ")");
        }
    }
}
