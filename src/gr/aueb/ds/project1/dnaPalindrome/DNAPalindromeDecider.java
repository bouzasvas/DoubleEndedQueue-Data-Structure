package gr.aueb.ds.project1.dnaPalindrome;

import gr.aueb.ds.project1.queue.api.DoubleEndedQueue;
import gr.aueb.ds.project1.queue.impl.DoubleEndedQueueImpl;

public class DNAPalindromeDecider {

    private final static String NOT_VALID_NUCLEOTIDE = "Could not find Complemented Nucleotide for Nucleotide '%s'";

    private String dnaSequence;
    private DoubleEndedQueue<Character> queue;

    public DNAPalindromeDecider(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        this.queue = convertSequenceToQueue();
    }

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

    private DoubleEndedQueue<Character> convertSequenceToQueue() {
        DoubleEndedQueue<Character> sequence = new DoubleEndedQueueImpl<>();

        for (char c : dnaSequence.toCharArray()) {
            sequence.addLast(c);
        }

        return sequence;
    }

    private boolean checkIfNucleotidesAreComplemented(char nucleotide1, char nucleotide2) {
        char nucleotide1Complement = findComplementedNucleotide(nucleotide1);
        char nucleotide2Complement = findComplementedNucleotide(nucleotide2);

        return nucleotide1 == nucleotide2Complement && nucleotide2 == nucleotide1Complement;
    }

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
