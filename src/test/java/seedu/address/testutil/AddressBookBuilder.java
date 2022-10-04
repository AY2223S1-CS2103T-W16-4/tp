package seedu.address.testutil;

import seedu.address.model.MyInsuRec;
import seedu.address.model.client.Client;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code MyInsuRec ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private MyInsuRec addressBook;

    public AddressBookBuilder() {
        addressBook = new MyInsuRec();
    }

    public AddressBookBuilder(MyInsuRec addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Client} to the {@code MyInsuRec} that we are building.
     */
    public AddressBookBuilder withPerson(Client client) {
        addressBook.addClient(client);
        return this;
    }

    public MyInsuRec build() {
        return addressBook;
    }
}
