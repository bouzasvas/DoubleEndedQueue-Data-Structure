package gr.aueb.ds.project1.dnaPalindrome;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * <p>Main class of DNA Complemented Palindrome Decider</p>
 * <p>The below steps are performed:</p>
 * <ul>
 *     <li>Receive DNA Sequence from user input</li>
 *     <li>Validate DNA Sequence</li>
 *     <li>Decider whether or not DNA Sequence is Complemented Palindrome and inform user</li>
 * </ul>
 */
public class DNAPalindrome {

    private static final String RED_COLOR = "\u001B[31m";
    private static final String GREEN_COLOR = "\u001B[32m";

    private static final String SEPARATOR =   "######################################################################";
    private static final String WELCOME_MSG = "###### Welcome to DNA Complemented Palindrome Sequence Decider #######";
    private static final String NEW_LINE = "\n";

    private static final String TRUE_RESULT_MSG  = "DNA Sequence '%s' is Complemented Palindrome!";
    private static final String FALSE_RESULT_MSG = "DNA Sequence '%s' is NOT Complemented Palindrome!";

    public static void main (String... args) {
        printWelcomeMsg(System.out);

        String dnaSequence = promptUserToEnterDnaSequence(System.out);

        DNAPalindromeValidator validator = new DNAPalindromeValidator(dnaSequence);
        validator.validateDNASequence();

        DNAPalindromeDecider decider = new DNAPalindromeDecider(dnaSequence);
        boolean isComplementedPalindrome = decider.isSequenceComplementedPalindrome();

        printResult(dnaSequence, isComplementedPalindrome, System.out);
    }

    private static void printWelcomeMsg(PrintStream ps) {
        ps.println(SEPARATOR);
        ps.println(WELCOME_MSG);
        ps.println(SEPARATOR + NEW_LINE);
    }

    private static String promptUserToEnterDnaSequence(PrintStream ps) {
        ps.print("Enter DNA Sequence: ");
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }

    private static void printResult(String dnaSequence, boolean isComplementedPalindrome, PrintStream ps) {
        String result;
        if (isComplementedPalindrome) {
            result = GREEN_COLOR + String.format(TRUE_RESULT_MSG, dnaSequence);
        }
        else {
            result = RED_COLOR + String.format(FALSE_RESULT_MSG, dnaSequence);
        }

        ps.println();
        ps.println(result);
    }
}
