package gr.aueb.ds.project1.dnaPalindrome;

public class DNAPalindromeValidator {

    private static final String VALID_REGEX = "[ATCG]*";

    private String dnaSequence;

    public DNAPalindromeValidator(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public void validateDNASequence() {
        if (!this.dnaSequence.matches(VALID_REGEX)) {
            throw new DNASequenceNotValidException(this.dnaSequence);
        }
    }
}
