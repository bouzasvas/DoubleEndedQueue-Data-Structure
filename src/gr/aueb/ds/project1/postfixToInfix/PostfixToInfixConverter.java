package gr.aueb.ds.project1.postfixToInfix;

import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;
import gr.aueb.ds.project1.queue.impl.DoubleEndedQueueImpl;

import java.util.Optional;

/**
 * <p>Converts Postfix expression to Infix expression</p>
 * <p>Uses {@link PostfixToInfixValidator} to validate expression correctness</p>
 */
public class PostfixToInfixConverter {
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";

    private String postFixExpression;
    private String infixExpression;

    private PostfixToInfixValidator validator;

    /**
     * <p>Creates a {@link PostfixToInfixConverter} object after Postfix Expression Validation</p>
     *
     * <p>If Validation fails a {@link PostfixExpressionValidationException} is thrown</p>
     *
     * @param postFixExpression - The postfix expression from user input
     */
    public PostfixToInfixConverter(String postFixExpression) {
        this.validator = new PostfixToInfixValidator(postFixExpression);
        validator.validatePostfixExp();

        this.postFixExpression = postFixExpression;
    }

    /**
     * Converts Postfix Expression to Infix Expression
     */
    public void convertPostfixToInfix() {
        DoubleEndedQueue<Character> postfixExprQueue = convertStringToQueue(postFixExpression);
        DoubleEndedQueue<String> infixExpQueue = new DoubleEndedQueueImpl<>();
        while(!postfixExprQueue.isEmpty()) {
            // Remove first symbol of User Input and check if it is Operand or Operator
            String symbol = String.valueOf(postfixExprQueue.removeFirst());

            // Is Operand
            if (isDigit(symbol)) {
                String operand = symbol;
                infixExpQueue.addLast(operand);
            }
            // Is Operator
            else {
                createExpression(symbol, infixExpQueue);
            }
        }

        this.infixExpression = infixExpQueue.toString();
    }

    /**
     * @return The Converted infix expression or {@link NullPointerException} if null
     */
    public String getInfixExpressionResult() {
        return Optional.of(this.infixExpression).get();
    }

    /**
     * <p>Creates Mathematical Expression using the last 2 Operands of Queue</p>
     * <br/>
     * <p>Also adds parenthesis around expression and updates Queue Contents</p
     * @param symbol - The Operator being iterated at the moment
     * @param infixExpQueue - The Queue containing all infix mathematical operations
     */
    private static void createExpression(String symbol, DoubleEndedQueue<String> infixExpQueue) {
        String operator = symbol;

        // Remove 2 last items from Queue
        String operand2 = infixExpQueue.removeLast();
        String operand1 = infixExpQueue.removeLast();

        // Create Mathematical Expression in Infix format
        String expression = OPEN_PARENTHESIS + operand1 + operator + operand2 + CLOSE_PARENTHESIS;

        // Add Expression in Queue
        infixExpQueue.addLast(expression);
    }

    /**
     * <p>Checks if current postfix expression Character is Digit or not</p>
     * @param s - The current expression character being processed
     * @return Whether or not character is digit (operand) or symbol (operator)
     */
    private static boolean isDigit(String s) {
        final String digitRegex = "\\d";
        return s.matches(digitRegex);
    }

    // Helper Methods
    /**
     * <p>Converts a {@link String} to {@link DoubleEndedQueue}</p>
     * <p>Each String char is being inserted as Queue item</p>
     * @param postfixExp - The postfix Expression as String
     * @return The postfix Expression as Queue
     */
    private DoubleEndedQueue<Character> convertStringToQueue(String postfixExp) {
        DoubleEndedQueue<Character> queue = new DoubleEndedQueueImpl<>();

        char[] expressionChars = postfixExp.toCharArray();
        for (char expChar : expressionChars) {
            queue.addLast(expChar);
        }

        return queue;
    }
}
