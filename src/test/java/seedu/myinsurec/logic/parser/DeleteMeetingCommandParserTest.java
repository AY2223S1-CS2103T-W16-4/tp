package seedu.myinsurec.logic.parser;

import static seedu.myinsurec.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.myinsurec.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.myinsurec.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.myinsurec.testutil.TypicalIndexes.INDEX_FIRST_ELEMENT;

import org.junit.jupiter.api.Test;

import seedu.myinsurec.logic.commands.DeleteMeetingCommand;

public class DeleteMeetingCommandParserTest {

    private DeleteMeetingCommandParser parser = new DeleteMeetingCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, " i/1", new DeleteMeetingCommand(INDEX_FIRST_ELEMENT));
    }

    @Test
    public void parse_validArgs_throwsParseException() {
        assertParseFailure(
                parser,
                " i/a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteMeetingCommand.MESSAGE_USAGE));
    }
}
