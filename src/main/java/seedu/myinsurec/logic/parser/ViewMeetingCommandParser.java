package seedu.myinsurec.logic.parser;

import static seedu.myinsurec.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_INDEX;

import seedu.myinsurec.commons.core.index.Index;
import seedu.myinsurec.logic.commands.ViewMeetingCommand;
import seedu.myinsurec.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewMeetingCommand object
 */
public class ViewMeetingCommandParser implements Parser<ViewMeetingCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewMeetingCommand
     * and returns a ViewMeetingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewMeetingCommand parse(String args) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INDEX);
        if (!ParserUtil.arePrefixesPresent(argumentMultimap, PREFIX_INDEX)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewMeetingCommand.MESSAGE_USAGE));
        }

        try {
            Index index = ParserUtil.parseIndex(argumentMultimap.getValue(PREFIX_INDEX).get());
            return new ViewMeetingCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewMeetingCommand.MESSAGE_USAGE), pe);
        }
    }
}
