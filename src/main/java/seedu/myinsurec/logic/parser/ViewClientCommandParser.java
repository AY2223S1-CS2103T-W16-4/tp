package seedu.myinsurec.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_INDEX;

import seedu.myinsurec.commons.core.index.Index;
import seedu.myinsurec.logic.commands.ViewClientCommand;
import seedu.myinsurec.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewClientCommand object
 */
public class ViewClientCommandParser implements Parser<ViewClientCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ViewMeetingCommand
     * and returns a ViewMeetingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewClientCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_INDEX);

        if (!ParserUtil.arePrefixesPresent(argumentMultimap, PREFIX_INDEX)
                || !argumentMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewClientCommand.MESSAGE_USAGE));
        }

        Index index = ParserUtil.parseIndex(argumentMultimap.getValue(PREFIX_INDEX).get());
        return new ViewClientCommand(index);
    }
}
