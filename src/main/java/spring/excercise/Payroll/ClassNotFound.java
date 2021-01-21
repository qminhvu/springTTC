package spring.excercise.Payroll;

public class ClassNotFound extends RuntimeException {
    public ClassNotFound(int id) {
        super("Could not find class " + id);
    }
}
