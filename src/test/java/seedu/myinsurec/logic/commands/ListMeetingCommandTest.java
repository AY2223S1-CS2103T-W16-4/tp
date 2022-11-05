package seedu.myinsurec.logic.commands;

import static seedu.myinsurec.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.myinsurec.model.Model.PREDICATE_SHOW_ALL_MEETING;
import static seedu.myinsurec.testutil.TypicalMeetings.MEETING1;
import static seedu.myinsurec.testutil.TypicalMeetings.MEETING2;
import static seedu.myinsurec.testutil.TypicalMeetings.MEETING3;
import static seedu.myinsurec.testutil.TypicalMeetings.getTypicalMyInsuRec;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.myinsurec.logic.parser.DateKeyword;
import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.ModelManager;
import seedu.myinsurec.model.UserPrefs;
import seedu.myinsurec.model.meeting.Meeting;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListMeetingCommand.
 */
public class ListMeetingCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalMyInsuRec(), new UserPrefs());
        expectedModel = new ModelManager(model.getMyInsuRec(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListMeetingCommand(), model, ListMeetingCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listFilteredToTomorrow_showsFilteredList() {
        List<Meeting> expectedMeetingList = Arrays.asList(MEETING1);
        expectedModel.updateFilteredMeetingList(meeting -> expectedMeetingList.contains(meeting));
        assertCommandSuccess(new ListMeetingCommand(DateKeyword.TOMORROW), model,
                ListMeetingCommand.MESSAGE_SUCCESS, expectedModel);
        expectedModel.updateFilteredMeetingList(PREDICATE_SHOW_ALL_MEETING);
    }

    @Test
    public void execute_listFilteredToWeek_showsFilteredList() {
        List<Meeting> expectedMeetingList = Arrays.asList(MEETING1, MEETING2);
        expectedModel.updateFilteredMeetingList(meeting -> expectedMeetingList.contains(meeting));
        assertCommandSuccess(new ListMeetingCommand(DateKeyword.THIS_WEEK), model,
                ListMeetingCommand.MESSAGE_SUCCESS, expectedModel);
        expectedModel.updateFilteredMeetingList(PREDICATE_SHOW_ALL_MEETING);
    }

    @Test
    public void execute_listFilteredToMonth_showsFilteredList() {
        List<Meeting> expectedMeetingList = Arrays.asList(MEETING1, MEETING2, MEETING3);
        expectedModel.updateFilteredMeetingList(meeting -> expectedMeetingList.contains(meeting));
        assertCommandSuccess(new ListMeetingCommand(DateKeyword.THIS_MONTH), model,
                ListMeetingCommand.MESSAGE_SUCCESS, expectedModel);
        expectedModel.updateFilteredMeetingList(PREDICATE_SHOW_ALL_MEETING);
    }

}
