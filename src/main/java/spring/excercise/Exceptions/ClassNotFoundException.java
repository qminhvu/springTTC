package spring.excercise.Exceptions;

public class ClassNotFoundException extends RuntimeException {
    public ClassNotFoundException(int id) {
        super("Could not find class " + id);
    }
}
