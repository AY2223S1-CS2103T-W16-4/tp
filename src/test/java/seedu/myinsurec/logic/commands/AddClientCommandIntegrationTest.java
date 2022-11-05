package seedu.myinsurec.logic.commands;

import static seedu.myinsurec.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.myinsurec.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.myinsurec.testutil.TypicalClients.getTypicalMyInsuRec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.ModelManager;
import seedu.myinsurec.model.UserPrefs;
import seedu.myinsurec.model.client.Client;
import seedu.myinsurec.testutil.ClientBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddClientCommand}.
 */
public class AddClientCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalMyInsuRec(), new UserPrefs());
    }

    @Test
    public void execute_newClient_success() {
        Client validClient = new ClientBuilder().build();

        Model expectedModel = new ModelManager(model.getMyInsuRec(), new UserPrefs());
        expectedModel.addClient(validClient);

        assertCommandSuccess(new AddClientCommand(validClient), model,
                String.format(AddClientCommand.MESSAGE_SUCCESS, validClient), expectedModel);
    }

    @Test
    public void execute_duplicateClient_throwsCommandException() {
        Client personInList = model.getMyInsuRec().getClientList().get(0);
        assertCommandFailure(new AddClientCommand(personInList), model, AddClientCommand.MESSAGE_DUPLICATE_CLIENT);
    }

}
