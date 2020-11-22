package gr.aueb.ds.project1.postfixToInfix;

import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;
import gr.aueb.ds.project1.queue.impl.DoubleEndedQueueImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostfixToInfixConverter {
    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSE_PARENTHESIS = ")";

    private String postFixExpression;
    private String infixExpresion;

    public PostfixToInfixConverter(String postFixExpression) {
        this.postFixExpression = postFixExpression;
    }

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

        this.infixExpresion = infixExpQueue.toString();
    }

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

    private static boolean isDigit(String s) {
        final String digitRegex = "\\d";
        return s.matches(digitRegex);
    }

    public String getInfixExpresionResult() {
        return this.infixExpresion;
    }

    // Helper Methods
    private DoubleEndedQueue<Character> convertStringToQueue(String postfixExp) {
        DoubleEndedQueue<Character> queue = new DoubleEndedQueueImpl<>();

        char[] expressionChars = postfixExp.toCharArray();
        for (char expChar : expressionChars) {
            queue.addLast(expChar);
        }

        return queue;
    }
}
