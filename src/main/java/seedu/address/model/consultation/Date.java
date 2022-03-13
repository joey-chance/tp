package seedu.address.model.consultation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Date {

    public static final String MESSAGE_CONSTRAINTS =
            "Date should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";

    public LocalDate date;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid name.
     */
    public Date(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);

        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && date.equals(((Date) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

}
