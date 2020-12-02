package gr.aueb.ds.project1.dnaPalindrome;

public class DNAPalindromeValidator {

    private static final String VALID_REGEX = "[ATCG]*";

    private String dnaSequence;

    public DNAPalindromeValidator(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    /**
     * <p>Checks if DNA Sequence is valid or not</p>
     *
     * <p>A DNA Sequence is not Valid if Contains Letters other than A, T, C, G or empty spaces!</p>
     *
     * @throws DNASequenceNotValidException If DNA Sequence is not Valid
     */
    public void validateDNASequence() {
        if (!this.dnaSequence.matches(VALID_REGEX)) {
            throw new DNASequenceNotValidException(this.dnaSequence);
        }
    }
}
