package matriculasinterfaces;

public interface Matriculavel<T> {
    public void matricular(T instancia);
    public void cancelarMatricula(T instancia);
}
