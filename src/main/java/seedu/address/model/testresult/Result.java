package seedu.address.model.testresult;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Test's result in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidResult(String)}
 */
public class Result {

    public static final String MESSAGE_CONSTRAINTS = "Results can take any values, and it should not be blank";

    /*
     * The first character of the result must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Result}.
     *
     * @param result A valid result.
     */
    public Result(String result) {
        requireNonNull(result);
        checkArgument(isValidResult(result), MESSAGE_CONSTRAINTS);
        value = result;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidResult(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Result // instanceof handles nulls
                && value.equals(((Result) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
