package gr.aueb.ds.project1.postfixToInfix;

import java.io.PrintStream;
import java.util.Scanner;

public class PostfixToInfixMain {

    private static final String SEPARATOR =   "#################################################";
    private static final String WELCOME_MSG = "###### Welcome Postfix 2 Infix Conversion #######";
    private static final String NEW_LINE = "\n";
    private static final String RESULT_MSG = "Infix Result: ";

    public static void main(String... args) {
        printWelcomeMsg(System.out);

        String postfixExp = promptUserToEnterPostfixExp(System.out);
//        String postfixExp = "598+46**7+*";

        PostfixToInfixValidator validator = new PostfixToInfixValidator(postfixExp);
        validator.validatePostfixExp();

        PostfixToInfixConverter postfixToInfixConverter = new PostfixToInfixConverter(postfixExp);
        postfixToInfixConverter.convertPostfixToInfix();

        printResult(System.out, postfixToInfixConverter.getInfixExpresionResult());
    }

    private static void printWelcomeMsg(PrintStream ps) {
        ps.println(SEPARATOR);
        ps.println(WELCOME_MSG);
        ps.println(SEPARATOR + NEW_LINE);
    }

    private static String promptUserToEnterPostfixExp(PrintStream ps) {
        ps.print("Enter Mathematical Expression in Postfix format: ");
        Scanner input = new Scanner(System.in);

        return input.next();
    }

    private static void printResult(PrintStream ps, String infixExp) {
        ps.println(RESULT_MSG + infixExp + NEW_LINE);
    }
}
