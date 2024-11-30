package rui.pereira.classesauxiliares;

public class ExceptionArgumento extends RuntimeException {
    public ExceptionArgumento(String message) {
        super(message);
    }
    public ExceptionArgumento() {
        super();
    }

    public void printStackTrace(String msg) {
        this.printStackTrace(msg);
        getLocalizedMessage();
    }
}
