package exams.service.login;

public class BadPasswordException extends RuntimeException{
    public BadPasswordException(String message) { super(message);}
}
