package seedu.myinsurec.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import seedu.myinsurec.logic.commands.ViewMeetingCommand;
import seedu.myinsurec.logic.parser.exceptions.ParseException;


public class ViewMeetingCommandParserTest {

    private ViewMeetingCommandParser vmcp = new ViewMeetingCommandParser();

    @Test
    public void parse_negativeIndexGiven_throwsParseException() {
        String args = "viewMeeting i/-1";
        Assertions.assertThrows(ParseException.class, () -> vmcp.parse(args));
    }

    @Test
    public void parse_allArgumentsValid_returnsCommandWithoutError() {
        String args = "viewMeeting i/1";
        try {
            assertTrue(vmcp.parse(args) instanceof ViewMeetingCommand);
        } catch (ParseException e) {
            fail();
        }
    }

}
