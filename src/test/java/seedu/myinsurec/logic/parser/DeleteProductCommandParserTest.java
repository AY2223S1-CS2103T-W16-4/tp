package seedu.myinsurec.logic.parser;

import static seedu.myinsurec.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.myinsurec.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.myinsurec.testutil.TypicalIndexes.INDEX_FIRST_ELEMENT;

import org.junit.jupiter.api.Test;

import seedu.myinsurec.logic.commands.DeleteProductCommand;

public class DeleteProductCommandParserTest {

    private DeleteProductCommandParser parser = new DeleteProductCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, " i/1", new DeleteProductCommand(INDEX_FIRST_ELEMENT));
    }

    @Test
    public void parse_validArgs_throwsParseException() {
        assertParseFailure(parser, " i/a", ParserUtil.MESSAGE_INVALID_INDEX);

        // Negative integer
        assertParseFailure(parser, " i/-1", ParserUtil.MESSAGE_INVALID_INDEX);

        // Number with decimal
        assertParseFailure(parser, " i/1.5", ParserUtil.MESSAGE_INVALID_INDEX);
    }
}
