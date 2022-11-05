package seedu.myinsurec.logic.commands;

import static seedu.myinsurec.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.myinsurec.logic.commands.CommandTestUtil.showClientAtIndex;
import static seedu.myinsurec.testutil.TypicalClients.getTypicalMyInsuRec;
import static seedu.myinsurec.testutil.TypicalIndexes.INDEX_FIRST_ELEMENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.ModelManager;
import seedu.myinsurec.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListClientCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalMyInsuRec(), new UserPrefs());
        expectedModel = new ModelManager(model.getMyInsuRec(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListClientCommand(),
                model, ListClientCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showClientAtIndex(model, INDEX_FIRST_ELEMENT);
        assertCommandSuccess(new ListClientCommand(),
                model, ListClientCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
