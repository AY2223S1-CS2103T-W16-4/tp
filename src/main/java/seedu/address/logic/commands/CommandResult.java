package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** Denotes whether the command is client specific. */
    private final boolean isClient;

    /** Denotes whether the command is meeting specific. */
    private final boolean isMeeting;

    /** Denotes whether the command is detailed meeting specific. */
    private final boolean isDetailedMeeting;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean isClient, boolean isMeeting, boolean isDetailedMeeting) {
        if (isClient && isMeeting) {
            throw new IllegalArgumentException("A command should not be both client and meeting specific.");
        }
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.isClient = isClient;
        this.isMeeting = isMeeting;
        this.isDetailedMeeting = isDetailedMeeting;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean isClient, boolean isMeeting) {
        if (isClient && isMeeting) {
            throw new IllegalArgumentException("A command should not be both client and meeting specific.");
        }
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.isClient = isClient;
        this.isMeeting = isMeeting;
        this.isDetailedMeeting = false;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser}, {@code showHelp}, {@code exit}.
     * Client/meeting specific fields are set to their default value.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, showHelp, exit, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isClientSpecific() {
        return isClient;
    }

    public boolean isMeetingSpecific() {
        return isMeeting;
    }

    public boolean isDetailedMeetingSpecific() {
        return isDetailedMeeting;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit);
    }

}
