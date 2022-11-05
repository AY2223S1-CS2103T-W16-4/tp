package seedu.myinsurec.logic.commands;

import static seedu.myinsurec.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.myinsurec.testutil.TypicalClients.getTypicalMyInsuRec;

import org.junit.jupiter.api.Test;

import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.ModelManager;
import seedu.myinsurec.model.MyInsuRec;
import seedu.myinsurec.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyMyInsuRec_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyMyInsuRec_success() {
        Model model = new ModelManager(getTypicalMyInsuRec(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalMyInsuRec(), new UserPrefs());
        expectedModel.setMyInsuRec(new MyInsuRec());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
