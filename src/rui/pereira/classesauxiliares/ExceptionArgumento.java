package rui.pereira.classesauxiliares;

public class ExceptionArgumento extends RuntimeException {
    public ExceptionArgumento(String message) {
        super(message);
    }
    @Deprecated public ExceptionArgumento() {
        super();
    }

    public void printStackTrace(String msg) {
        getLocalizedMessage();
        this.printStackTrace(msg);
    }
}
