package matriculasabstract;

import java.util.HashMap;

public abstract class Matriculavel<T> {
    protected String nome;
    protected HashMap<String, T> matriculas;

    public String getNome() {
        return nome;
    }

    public void matricular(String chave, T instancia) throws Exception {
        if (matriculas.get(chave) == null) {
            matriculas.put(chave, instancia);
            System.out.println("Matriculando " + chave + " no "+ this.getClass().getSimpleName() + 
                    " " + this.getNome());
        } else {
            System.out.println( "O " + instancia.getClass().getSimpleName() + " " + chave + 
                    " já está matriculado no " + this.getNome()+ " " + this.getNome());
        }
    }
    public void cancelarMatricula(String chave) {
        if (matriculas.get(chave) != null) {
            matriculas.remove(chave);
            System.out.println("Cancelando matricula de " + chave + " no "+ this.getClass().getSimpleName() + 
                    " " + this.getNome());
        } else {
            System.out.println( "O " + chave + " não está matriculado no " + this.getNome() + 
                    " " + this.getNome());
        }
    }
}
