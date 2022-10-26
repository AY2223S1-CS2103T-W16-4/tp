package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_ELEMENT;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.DeleteProductCommand;

public class DeleteProductCommandParserTest {

    private DeleteProductCommandParser parser = new DeleteProductCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, " i/1", new DeleteProductCommand(INDEX_FIRST_ELEMENT));
    }

    @Test
    public void parse_validArgs_throwsParseException() {
        assertParseFailure(
                parser,
                " i/a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteProductCommand.MESSAGE_USAGE));
    }
}
