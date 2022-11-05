package seedu.myinsurec.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.logic.parser.CliSyntax.PREFIX_INDEX;

import java.util.List;

import seedu.myinsurec.commons.core.Messages;
import seedu.myinsurec.commons.core.index.Index;
import seedu.myinsurec.logic.commands.exceptions.CommandException;
import seedu.myinsurec.model.Model;
import seedu.myinsurec.model.product.Product;

/**
 * Deletes a product identified using its displayed index from MyInsuRec.
 * Deleting a product removes its association from all clients.
 */
public class DeleteProductCommand extends Command {

    public static final String COMMAND_WORD = "delProduct";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the product identified by its index number.\n"
            + "Parameters: " + PREFIX_INDEX + "INDEX\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_INDEX + "1";

    public static final String MESSAGE_DELETE_PRODUCT_SUCCESS = "Deleted Product: %1$s";

    private final Index targetIndex;

    public DeleteProductCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Product> lastShownList = model.getFilteredProductList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PRODUCT_DISPLAYED_INDEX);
        }

        Product productToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteProduct(productToDelete);
        return new CommandResult(
                String.format(MESSAGE_DELETE_PRODUCT_SUCCESS, productToDelete), CommandSpecific.PRODUCT);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteProductCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteProductCommand) other).targetIndex)); // state check
    }
}
