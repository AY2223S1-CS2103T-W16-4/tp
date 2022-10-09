package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.DeleteMeetingCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteMeetingCommand object
 */
public class DeleteMeetingCommandParser implements Parser<DeleteMeetingCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteMeetingCommand
     * and returns a DeleteMeetingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteMeetingCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INDEX);

        Index index;
        try {
            index = ParserUtil.parseIndex(argumentMultimap.getValue(PREFIX_INDEX).get());
        } catch (IllegalValueException ive) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteMeetingCommand.MESSAGE_USAGE),
                    ive
            );
        }

        return new DeleteMeetingCommand(index);
    }
}
