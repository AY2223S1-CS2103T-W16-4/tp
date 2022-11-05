package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Meeting's date in MyInsuRec.
 */
public class MeetingDate implements Comparable<MeetingDate> {

    public static final String MESSAGE_CONSTRAINTS =
            "Meeting dates should be in the format DDMMYYYY and should be a valid day of the year";
    public static final String MESSAGE_INVALID_DATE = "Date should not be in the past!";
    public static final String VALIDATION_REGEX = "\\d{8}";
    private final LocalDate date;

    /**
     * Constructs a {@code MeetingDate}.
     *
     * @param meetingDate A valid meeting date.
     */
    public MeetingDate(LocalDate meetingDate) {
        requireNonNull(meetingDate);
        date = meetingDate;
    }

    /**
     * Returns true is a given string is a valid meeting date.
     */
    public static boolean isValidMeetingDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof MeetingDate
                && date.equals(((MeetingDate) other).date));
    }

    @Override
    public int compareTo(MeetingDate other) {
        return date.compareTo(other.date);
    }

    public static boolean isBeforeToday(MeetingDate meetingDate) {
        return meetingDate.date.isBefore(LocalDate.now());
    }
}
