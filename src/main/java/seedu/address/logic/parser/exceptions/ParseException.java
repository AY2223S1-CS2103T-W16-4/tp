package seedu.address.logic.parser.exceptions;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a parse error encountered by a parser.
 */
public class ParseException extends IllegalValueException {

    public ParseException(String message) {
        super(message);
    }

    /**
     * Constructor for parse exceptions that are caused by invalid
     * values. Prints a message as well as the invalid value.
     * @param message
     * @param invalidValue
     */
    public ParseException(String message, String invalidValue) {
        super(message + ".\n\"" + invalidValue + "\" is invalid!");
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
