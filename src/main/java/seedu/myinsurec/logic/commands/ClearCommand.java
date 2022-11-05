package seedu.myinsurec.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.MyInsuRec;

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
        return new CommandResult(MESSAGE_SUCCESS, CommandSpecific.CLIENT);
    }
}
