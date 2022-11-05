package seedu.myinsurec.model;

import javafx.collections.ObservableList;
import seedu.myinsurec.model.client.Client;
import seedu.myinsurec.model.meeting.Meeting;
import seedu.myinsurec.model.product.Product;

/**
 * Unmodifiable view of a MyInsuRec
 */
public interface ReadOnlyMyInsuRec {

    /**
     * Returns an unmodifiable view of the clients list.
     * This list will not contain any duplicate clients.
     */
    ObservableList<Client> getClientList();

    /**
     * Returns an unmodifiable view of the meetings list.
     * This list will not contain meetings with any timing conflicts.
     */
    ObservableList<Meeting> getMeetingList();

    /**
     * Returns an unmodifiable view of the products list.
     * This list will not contain any duplicate products.
     */
    ObservableList<Product> getProductList();
}
