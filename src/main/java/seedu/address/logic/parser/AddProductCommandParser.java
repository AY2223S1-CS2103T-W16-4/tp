package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_END_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRODUCT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_TIME;

import seedu.address.logic.commands.AddProductCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.product.Product;

/**
 * Parses input arguments and creates a new AddProductCommand object.
 */
public class AddProductCommandParser implements Parser<AddProductCommand> {

    @Override
    public AddProductCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PRODUCT);
        boolean areRequiredPrefixesPresent = ParserUtil.arePrefixesPresent(argMultimap, PREFIX_PRODUCT);

        if (!areRequiredPrefixesPresent || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddProductCommand.MESSAGE_USAGE));
        }

        Product product = ParserUtil.parseProduct(argMultimap.getValue(PREFIX_PRODUCT).get());
        return new AddProductCommand(product);
    }
}
