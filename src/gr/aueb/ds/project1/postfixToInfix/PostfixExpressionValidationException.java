package gr.aueb.ds.project1.postfixToInfix;

/**
 * <p>Exception thrown when Postfix expression has not valid Format</p>
 */
public class PostfixExpressionValidationException extends RuntimeException {

    private final static String EXCEPTION_MSG = "Postfix Expression is not valid!";

    public PostfixExpressionValidationException() {
        super(EXCEPTION_MSG);
    }
}
