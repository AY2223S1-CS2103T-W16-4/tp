package seedu.address.logic.parser;


import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRODUCT;

import java.util.stream.Stream;

import seedu.address.logic.commands.ListClientCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.product.Product;

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
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(args, PREFIX_PRODUCT);

        if (!arePrefixesPresent(argumentMultimap, PREFIX_PRODUCT)) {
            return new ListClientCommand();
        } else {
            Product product = ParserUtil.parseProduct(argumentMultimap.getValue(PREFIX_PRODUCT).get());
            return new ListClientCommand(product);
        }
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
