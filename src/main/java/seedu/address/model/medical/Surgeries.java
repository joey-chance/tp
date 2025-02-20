package seedu.address.model.medical;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's surgeries in the MedBook.
 * Guarantees: immutable; is valid as declared in {@link #isValidSurgeries(String)}
 */
public class Surgeries {

    public static final String MESSAGE_CONSTRAINTS = "Surgeries can take any values, and it should not be blank";

    /*
     * The first character of the surgery must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Surgeries}.
     *
     * @param surgery Information about the patient's surgeries.
     */
    public Surgeries(String surgery) {
        requireNonNull(surgery);
        checkArgument(isValidSurgeries(surgery), MESSAGE_CONSTRAINTS);
        value = surgery;
    }

    /**
     * Returns true if given string is valid.
     */
    public static boolean isValidSurgeries(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Surgeries // instanceof handles nulls
                && value.equals(((Surgeries) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
