package seedu.address.model.consultation;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Represents a Consultation's date in the address book.
 */
public class Date {

    public static final String MESSAGE_CONSTRAINTS =
            "Date should not be blank, and should be in the format dd-MM-yyyy";

    private LocalDate date;

    /**
     * Constructs a {@code Date}.
     *
     * @param date A valid date.
     */
    public Date(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate value() {
        return date;
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDate(String test) {
        try {
            LocalDate.parse(test, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
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
