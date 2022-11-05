package seedu.myinsurec.testutil;

import seedu.myinsurec.model.MyInsuRec;
import seedu.myinsurec.model.client.Client;

/**
 * A utility class to help with building MyInsuRec objects.
 * Example usage: <br>
 *     {@code MyInsuRec ab = new MyInsuRecBuilder().withClient("John", "Doe").build();}
 */
public class MyInsuRecBuilder {

    private MyInsuRec myInsuRec;

    public MyInsuRecBuilder() {
        myInsuRec = new MyInsuRec();
    }

    public MyInsuRecBuilder(MyInsuRec myInsuRec) {
        this.myInsuRec = myInsuRec;
    }

    /**
     * Adds a new {@code Client} to the {@code MyInsuRec} that we are building.
     */
    public MyInsuRecBuilder withClient(Client client) {
        myInsuRec.addClient(client);
        return this;
    }

    public MyInsuRec build() {
        return myInsuRec;
    }
}
