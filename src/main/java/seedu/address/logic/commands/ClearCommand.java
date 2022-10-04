package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.MyInsuRec;
import seedu.address.model.Model;

/**
 * Clears MyInsuRec.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "MyInsuRec has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setMyInsuRec(new MyInsuRec());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
