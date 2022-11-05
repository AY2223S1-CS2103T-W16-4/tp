package seedu.myinsurec.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_INDEX;

import java.util.List;

import seedu.myinsurec.commons.core.Messages;
import seedu.myinsurec.commons.core.index.Index;
import seedu.myinsurec.logic.commands.exceptions.CommandException;
import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.client.Client;

/**
 * Views a client.
 */
public class ViewClientCommand extends Command {
    public static final String COMMAND_WORD = "viewClient";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views the client identified by their index number.\n"
            + "Parameters: " + PREFIX_INDEX + "INDEX\n"
            + "Example: " + COMMAND_WORD + " i/1";

    public static final String MESSAGE_SUCCESS = "Viewed client: %1$s";

    private final Index targetIndex;

    /**
     * Creates an ViewClientCommand to view the specified {@code Client}
     */
    public ViewClientCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Client> lastShownList = model.getFilteredClientList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX);
        }

        Client clientToView = lastShownList.get(targetIndex.getZeroBased());

        model.setDetailedClient(clientToView);

        return new CommandResult(String.format(MESSAGE_SUCCESS, clientToView), CommandSpecific.DETAILED_CLIENT);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewClientCommand // instanceof handles nulls
                && targetIndex.equals(((ViewClientCommand) other).targetIndex)); // state check
    }
}
