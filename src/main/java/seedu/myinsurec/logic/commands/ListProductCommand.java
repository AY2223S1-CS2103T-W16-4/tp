package seedu.myinsurec.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.myinsurec.model.Model.PREDICATE_SHOW_ALL_PRODUCTS;

import seedu.myinsurec.model.Model;

/**
 * Lists all products in MyInsuRec to the user.
 */
public class ListProductCommand extends Command {

    public static final String COMMAND_WORD = "listProduct";

    public static final String MESSAGE_SUCCESS = "Listed all products";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredProductList(PREDICATE_SHOW_ALL_PRODUCTS);
        return new CommandResult(MESSAGE_SUCCESS, CommandSpecific.PRODUCT);
    }

}
