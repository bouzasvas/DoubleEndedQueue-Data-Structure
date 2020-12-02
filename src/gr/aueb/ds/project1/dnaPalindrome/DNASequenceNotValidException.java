package gr.aueb.ds.project1.dnaPalindrome;

public class DNASequenceNotValidException extends RuntimeException {

    private static final String NOT_VALID_DNA_SEQUENCE_MSG = "The DNA Sequence \"%s\" is not valid. Only letters A, T, C, G are allowed (case sensitive)!";

    public DNASequenceNotValidException(String dnaSequence) {
        super(String.format(NOT_VALID_DNA_SEQUENCE_MSG, dnaSequence));
    }
}
