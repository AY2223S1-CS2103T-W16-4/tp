package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.client.Client;
import seedu.address.model.client.UniqueClientList;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.NoConflictMeetingList;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueProductList;

/**
 * Wraps all data at the client-book level
 * Duplicates are not allowed (by .isSameClient comparison)
 */
public class MyInsuRec implements ReadOnlyMyInsuRec {

    private final UniqueClientList clients;
    private final NoConflictMeetingList meetings;
    private final UniqueProductList products;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        clients = new UniqueClientList();
        meetings = new NoConflictMeetingList();
        products = new UniqueProductList();
    }

    public MyInsuRec() {}

    /**
     * Creates a MyInsuRec using the Clients in the {@code toBeCopied}
     */
    public MyInsuRec(ReadOnlyMyInsuRec toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the client list with {@code clients}.
     * {@code clients} must not contain duplicate clients.
     */
    public void setClients(List<Client> clients) {
        this.clients.setClients(clients);
    }

    /**
     * Replaces the contents of the client list with {@code meetings}.
     * {@code meetings} must not contain duplicate meetings.
     */
    public void setMeetings(List<Meeting> meetings) {
        this.meetings.setMeetings(meetings);
    }

    /**
     * Replaces the contents of the product list with {@code products}.
     * {@code products} must not contain duplicate products.
     */
    public void setProducts(List<Tag> products) {
        this.products.setProducts(products);
    }

    /**
     * Resets the existing data of this {@code MyInsuRec} with {@code newData}.
     */
    public void resetData(ReadOnlyMyInsuRec newData) {
        requireNonNull(newData);

        setClients(newData.getClientList());
        setMeetings(newData.getMeetingList());
        setProducts(newData.getProductList());
    }

    //// client-level operations

    /**
     * Returns true if a client with the same identity as {@code client} exists in the client book.
     */
    public boolean hasClient(Client client) {
        requireNonNull(client);
        return clients.contains(client);
    }

    /**
     * Adds a client to the client book.
     * The client must not already exist in the client book.
     */
    public void addClient(Client p) {
        clients.add(p);
    }

    /**
     * Replaces the given client {@code target} in the list with {@code editedClient}.
     * {@code target} must exist in the client book.
     * The client identity of {@code editedClient} must not be the same as another existing client in the client book.
     */
    public void setClient(Client target, Client editedClient) {
        requireNonNull(editedClient);

        clients.setClient(target, editedClient);
    }

    /**
     * Removes {@code key} from this {@code MyInsuRec}.
     * {@code key} must exist in MyInsuRec.
     */
    public void removeClient(Client key) {
        clients.remove(key);
    }

    //// meeting-level operations

    /**
     * Adds a meeting to the meeting list.
     * There must not be any timing conflicts with any other meeting on the list.
     */
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    /**
     * Removes meeting.
     * The meeting must exist in MyInsuRec.
     * @param meeting
     */
    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    /**
     * Returns true if a meeting with the same identity as {@code meeting} exists in the meetings book.
     */
    public boolean hasMeeting(Meeting meeting) {
        return meetings.contains(meeting);
    }

    //// product-level operations
    /**
     * Adds a product to the product list.
     * There must not be any naming conflicts with any other product on the list.
     */
    public void addProduct(Tag product) {
        products.add(product);
    }

    /**
     * Removes product.
     * The meeting must exist in the product list in MyInsuRec.
     */
    public void removeProduct(Tag product) {
        products.remove(product);
    }

    /**
     * Returns true if a product with the same identity as {@code product} exists in the products book.
     */
    public boolean hasProduct(Tag product) {
        return products.contains(product);
    }

    //// util methods

    @Override
    public String toString() {
        return clients.asUnmodifiableObservableList().size() + " clients";
        // TODO: refine later
    }

    @Override
    public ObservableList<Client> getClientList() {
        return clients.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Meeting> getMeetingList() {
        return meetings.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Tag> getProductList() {
        return products.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MyInsuRec // instanceof handles nulls
                && clients.equals(((MyInsuRec) other).clients));
    }

    @Override
    public int hashCode() {
        return clients.hashCode();
    }
}
