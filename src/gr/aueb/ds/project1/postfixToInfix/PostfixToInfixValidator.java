package gr.aueb.ds.project1.postfixToInfix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Validates format of Postfix Expression</p>
 */
public class PostfixToInfixValidator {

    private String postFixExpression;

    public PostfixToInfixValidator(String postFixExpression) {
        this.postFixExpression = postFixExpression;
    }

    /**
     * <p>Validates whether a Postfix Expression is valid or not</p>
     * <br/>
     * <p>If Validation error occur a {@link PostfixExpressionValidationException} is thrown</p>
     */
    public void validatePostfixExp() {
        if (!postfixExpIsValid(this.postFixExpression)) {
            throw new PostfixExpressionValidationException();
        }
    }

    /**
     * <p>Validates format of Postfix Expression</p>
     *
     * <p>Postfix expression is valid when all of the above exists:</p>
     * <br/>
     *
     * <ul>
     *     <li>Expression does not contain letters</li>
     *     <li>Expression ends with operator</li>
     *     <li>Number of Operators is less than number of Operands by 1</li>
     * </ul>
     *
     * @param postfixExp - The Postfix Expression
     * @return - True if expression is valid else false
     */
    private static boolean postfixExpIsValid(String postfixExp) {
        boolean containsLetters = postfixExp.matches("(.)*[a-zA-Z](.)*");
//        boolean containsSymbols = postfixExp.matches("(.)*[^(\\+|\\-|\\*|\\/)]*(.)*");
        boolean endsWithOperator = postfixExp.matches("(.*)(\\+|-|\\*|/)$");

        int numberOfOperands = countOperands(postfixExp);
        int numberOfOperators = countOperators(postfixExp);

        return !containsLetters && endsWithOperator && (numberOfOperators == numberOfOperands - 1);
    }

    /**
     * <p>Counts the number of operands in postfix expression</p>
     *
     * @param expression - The Postfix Expression
     * @return - The number of Operands
     */
    private static int countOperands(String expression) {
        int numberOfOperands = 0;

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(expression);

        while (digitMatcher.find()) {
            numberOfOperands++;
        }

        return numberOfOperands;
    }

    /**
     * <p>Counts the number of operators in postfix expression</p>
     *
     * @param expression - The Postfix Expression
     * @return - The number of Operators
     */
    private static int countOperators(String expression) {
        int numOfOperators = 0;
        Pattern operatorPattern = Pattern.compile("(\\+|-|\\*|/)");
        Matcher operatorMatcher = operatorPattern.matcher(expression);

        while (operatorMatcher.find()) {
            numOfOperators++;
        }

        return numOfOperators;
    }
}
