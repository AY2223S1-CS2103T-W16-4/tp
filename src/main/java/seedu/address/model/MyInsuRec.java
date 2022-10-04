package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.client.Client;
import seedu.address.model.client.UniquePersonList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSameClient comparison)
 */
public class MyInsuRec implements ReadOnlyMyInsuRec {

    private final UniquePersonList persons;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();
    }

    public MyInsuRec() {}

    /**
     * Creates an MyInsuRec using the Persons in the {@code toBeCopied}
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
    public void setPersons(List<Client> clients) {
        this.persons.setPersons(clients);
    }

    /**
     * Resets the existing data of this {@code MyInsuRec} with {@code newData}.
     */
    public void resetData(ReadOnlyMyInsuRec newData) {
        requireNonNull(newData);

        setPersons(newData.getClientList());
    }

    //// client-level operations

    /**
     * Returns true if a client with the same identity as {@code client} exists in the address book.
     */
    public boolean hasPerson(Client client) {
        requireNonNull(client);
        return persons.contains(client);
    }

    /**
     * Adds a client to the address book.
     * The client must not already exist in the address book.
     */
    public void addPerson(Client p) {
        persons.add(p);
    }

    /**
     * Replaces the given client {@code target} in the list with {@code editedClient}.
     * {@code target} must exist in the address book.
     * The client identity of {@code editedClient} must not be the same as another existing client in the address book.
     */
    public void setPerson(Client target, Client editedClient) {
        requireNonNull(editedClient);

        persons.setPerson(target, editedClient);
    }

    /**
     * Removes {@code key} from this {@code MyInsuRec}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Client key) {
        persons.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Client> getClientList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MyInsuRec // instanceof handles nulls
                && persons.equals(((MyInsuRec) other).persons));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }
}
