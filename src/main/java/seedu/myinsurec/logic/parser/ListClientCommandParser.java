package seedu.myinsurec.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.myinsurec.logic.commands.ListClientCommand.MESSAGE_USAGE;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_BIRTHDAY;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_PRODUCT;

import seedu.myinsurec.logic.commands.ListClientCommand;
import seedu.myinsurec.logic.parser.exceptions.ParseException;
import seedu.myinsurec.model.product.Product;

/**
 * Parses input arguments and creates a new ListClientCommand object
 */
public class ListClientCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewMeetingCommand
     * and returns a ViewMeetingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListClientCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_PRODUCT, PREFIX_BIRTHDAY);

        if (ParserUtil.arePrefixesPresent(argumentMultimap, PREFIX_PRODUCT, PREFIX_BIRTHDAY)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
        } else if (ParserUtil.arePrefixesPresent(argumentMultimap, PREFIX_PRODUCT)) {
            Product product = ParserUtil.parseProduct(argumentMultimap.getValue(PREFIX_PRODUCT).get());
            return new ListClientCommand(product);
        } else if (ParserUtil.arePrefixesPresent(argumentMultimap, PREFIX_BIRTHDAY)) {
            DateKeyword dateKeyword = ParserUtil.parseDateKeyword(argumentMultimap.getValue(PREFIX_BIRTHDAY).get());
            return new ListClientCommand(dateKeyword);
        } else {
            return new ListClientCommand();
        }
    }
}
