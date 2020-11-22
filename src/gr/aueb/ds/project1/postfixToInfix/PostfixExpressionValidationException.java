package gr.aueb.ds.project1.postfixToInfix;

public class PostfixExpressionValidationException extends RuntimeException {

    private final static String EXCEPTION_MSG = "Postfix Expression is not valid!";

    public PostfixExpressionValidationException() {
        super(EXCEPTION_MSG);
    }
}
