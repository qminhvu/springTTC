package Payroll;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(int id) {
        super("Could not find student " + id);
    }
}
