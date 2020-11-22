package gr.aueb.ds.project1.postfixToInfix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostfixToInfixValidator {

    private String postFixExpression;

    public PostfixToInfixValidator(String postFixExpression) {
        this.postFixExpression = postFixExpression;
    }

    public void validatePostfixExp() {
        if (!postfixExpIsValid(this.postFixExpression)) {
            throw new PostfixExpressionValidationException();
        }
    }

    private static boolean postfixExpIsValid(String postfixExp) {
        boolean containsLetters = postfixExp.matches("(.)*[a-zA-Z](.)*");
//        boolean containsSymbols = postfixExp.matches("(.)*[^(\\+|\\-|\\*|\\/)]*(.)*");
        boolean endsWithOperator = postfixExp.matches("(.*)(\\+|-|\\*|/)$");

        int numberOfOperands = countOperands(postfixExp);
        int numberOfOperators = countOperators(postfixExp);

        return !containsLetters && endsWithOperator && (numberOfOperators == numberOfOperands - 1);
    }

    private static int countOperands(String expression) {
        int numberOfOperands = 0;

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(expression);

        while (digitMatcher.find()) {
            numberOfOperands++;
        }

        return numberOfOperands;
    }

    private static int countOperators(String expresion) {
        int numOfOperators = 0;
        Pattern operatorPattern = Pattern.compile("(\\+|-|\\*|/)");
        Matcher operatorMatcher = operatorPattern.matcher(expresion);

        while (operatorMatcher.find()) {
            numOfOperators++;
        }

        return numOfOperators;
    }
}
