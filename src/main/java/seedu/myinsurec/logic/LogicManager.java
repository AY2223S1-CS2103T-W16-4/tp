package seedu.myinsurec.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.myinsurec.commons.core.GuiSettings;
import seedu.myinsurec.commons.core.LogsCenter;
import seedu.myinsurec.logic.commands.Command;
import seedu.myinsurec.logic.commands.CommandResult;
import seedu.myinsurec.logic.commands.exceptions.CommandException;
import seedu.myinsurec.logic.parser.MyInsuRecParser;
import seedu.myinsurec.logic.parser.exceptions.ParseException;
import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.ReadOnlyMyInsuRec;
import seedu.myinsurec.model.client.Client;
import seedu.myinsurec.model.meeting.Meeting;
import seedu.myinsurec.model.product.Product;
import seedu.myinsurec.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final MyInsuRecParser myInsuRecParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        myInsuRecParser = new MyInsuRecParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = myInsuRecParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveMyInsuRec(model.getMyInsuRec());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyMyInsuRec getMyInsuRec() {
        return model.getMyInsuRec();
    }

    @Override
    public ObservableList<Client> getFilteredClientList() {
        return model.getFilteredClientList();
    }

    @Override
    public ObservableList<Meeting> getFilteredMeetingList() {
        return model.getFilteredMeetingList();
    }

    @Override
    public ObservableList<Product> getFilteredProductList() {
        return model.getFilteredProductList();
    }

    @Override
    public ObservableList<Meeting> getDetailedMeetingList() {
        return model.getDetailedMeetingList();
    }

    @Override
    public ObservableList<Client> getDetailedClientList() {
        return model.getDetailedClientList();
    }

    @Override
    public Path getMyInsuRecFilePath() {
        return model.getMyInsuRecFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
