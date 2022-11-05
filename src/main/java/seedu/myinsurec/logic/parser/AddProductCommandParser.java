package seedu.myinsurec.logic.parser;

import static seedu.myinsurec.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_PRODUCT;

import seedu.myinsurec.logic.commands.AddProductCommand;
import seedu.myinsurec.logic.parser.exceptions.ParseException;
import seedu.myinsurec.model.product.Product;

/**
 * Parses input arguments and creates a new AddProductCommand object.
 */
public class AddProductCommandParser implements Parser<AddProductCommand> {

    @Override
    public AddProductCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_PRODUCT);

        if (!ParserUtil.arePrefixesPresent(argMultimap, PREFIX_PRODUCT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddProductCommand.MESSAGE_USAGE));
        }

        Product product = ParserUtil.parseProduct(argMultimap.getValue(PREFIX_PRODUCT).get());
        return new AddProductCommand(product);
    }
}
