package seedu.myinsurec.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_INDEX;

import java.util.List;

import seedu.myinsurec.commons.core.Messages;
import seedu.myinsurec.commons.core.index.Index;
import seedu.myinsurec.logic.commands.exceptions.CommandException;
import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.meeting.Meeting;

/**
 * Views a meeting.
 */
public class ViewMeetingCommand extends Command {

    public static final String COMMAND_WORD = "viewMeeting";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views the meeting identified by their index number.\n"
            + "Parameters: " + PREFIX_INDEX + "INDEX\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_INDEX + "1";

    public static final String MESSAGE_SUCCESS = "Viewed meeting: %1$s";

    private final Index targetIndex;

    /**
     * Creates a ViewMeetingCommand to view the specified {@code Meeting}
     */
    public ViewMeetingCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Meeting> lastShownList = model.getFilteredMeetingList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MEETING_DISPLAYED_INDEX);
        }

        Meeting meetingToView = lastShownList.get(targetIndex.getZeroBased());

        model.setDetailedMeeting(meetingToView);

        return new CommandResult(String.format(MESSAGE_SUCCESS, meetingToView), CommandSpecific.DETAILED_MEETING);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewMeetingCommand // instanceof handles nulls
                && targetIndex.equals(((ViewMeetingCommand) other).targetIndex)); // state check
    }
}
