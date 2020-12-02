package gr.aueb.ds.project1.dnaPalindrome;

import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;
import gr.aueb.ds.project1.queue.impl.DoubleEndedQueueImpl;

/**
 * Decider whether or not a DNA Sequence is Complemented Palindrome utilizing {@link DoubleEndedQueue}
 */
public class DNAPalindromeDecider {

    private final static String NOT_VALID_NUCLEOTIDE = "Could not find Complemented Nucleotide for Nucleotide '%s'";

    private String dnaSequence;
    private DoubleEndedQueue<Character> queue;

    public DNAPalindromeDecider(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        this.queue = convertSequenceToQueue();
    }

    /**
     * <p>Decides whether a DNA Sequence is Complemented Palindrome or not</p>
     * <p>The Decision depends on the below:</p>
     * <ul>
     *     <li>If DNA Sequence is empty then is Complemented Palindrome</li>
     *     <li>If DNA Sequence size is not even then is NOT Complemented Palindrome</li>
     *     <li>Else check pair of nucleotides removing from start and end simultaneously</li>
     * </ul>
     * @return The Decision
     */
    public boolean isSequenceComplementedPalindrome() {
        // If DNA Sequence is Empty (like '') is Complemented Palindrome
        if (queue.isEmpty()) return true;

        // If DNA Sequence size is not Even number
        if (queue.size() % 2 != 0) return false;

        // Iterate over Queue while is not empty
        while(!this.queue.isEmpty()) {
            char nucleotideFirst = this.queue.removeFirst();
            char nucleotideLast = this.queue.removeLast();

            boolean isComplemented = checkIfNucleotidesAreComplemented(nucleotideFirst, nucleotideLast);

            if (!isComplemented) return false;
        }

        return true;
    }

    /**
     * <p>Converts the String DNA Palindrome to a DoubleEndedQueue of Characters</p>
     * @return The DoubleEndedQueue of DNA Nucleotides
     * @see DoubleEndedQueue
     */
    private DoubleEndedQueue<Character> convertSequenceToQueue() {
        DoubleEndedQueue<Character> sequence = new DoubleEndedQueueImpl<>();

        for (char c : dnaSequence.toCharArray()) {
            sequence.addLast(c);
        }

        return sequence;
    }

    /**
     * <p>Checks if 2 Nucleotides are Complemented using {@link DNAPalindromeDecider#findComplementedNucleotide}</p>
     * @param nucleotide1 The first nucleotide
     * @param nucleotide2 The second nucleotide
     * @return Whether or not 2 Nucleotides are Complemented
     */
    private boolean checkIfNucleotidesAreComplemented(char nucleotide1, char nucleotide2) {
        char nucleotide1Complement = findComplementedNucleotide(nucleotide1);
        char nucleotide2Complement = findComplementedNucleotide(nucleotide2);

        return nucleotide1 == nucleotide2Complement && nucleotide2 == nucleotide1Complement;
    }

    /**
     * <p>Finds the Complemented Nucleotide of a Nucleotide</p>
     * @param nucleotide The nucleotide for which the Search is performed
     * @return The Complemented Nucleotide
     * @throws RuntimeException If Nucleotide is not Valid
     */
    private char findComplementedNucleotide(char nucleotide) {
        char complementedNucleotide = ' ';

        switch (nucleotide) {
            case 'A':
                complementedNucleotide = 'T';
                break;
            case 'T':
                complementedNucleotide = 'A';
                break;
            case 'C':
                complementedNucleotide = 'G';
                break;
            case 'G':
                complementedNucleotide = 'C';
                break;
            default:
                throw new RuntimeException(String.format(NOT_VALID_NUCLEOTIDE, nucleotide));
        }

        return complementedNucleotide;
    }
}
