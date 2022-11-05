package seedu.myinsurec.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.myinsurec.commons.exceptions.IllegalValueException;
import seedu.myinsurec.model.MyInsuRec;
import seedu.myinsurec.model.ReadOnlyMyInsuRec;
import seedu.myinsurec.model.client.Client;
import seedu.myinsurec.model.meeting.Meeting;
import seedu.myinsurec.model.product.Product;

/**
 * An Immutable MyInsuRec that is serializable to JSON format.
 */

@JsonRootName(value = "myinsurec")
class JsonSerializableMyInsuRec {

    public static final String MESSAGE_DUPLICATE_CLIENT = "Clients list contains duplicate client(s).";

    private final List<JsonAdaptedClient> clients = new ArrayList<>();
    private final List<JsonAdaptedProduct> products = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableMyInsuRec} with the given clients.
     */
    @JsonCreator
    public JsonSerializableMyInsuRec(@JsonProperty("clients") List<JsonAdaptedClient> clients,
                                     @JsonProperty("products") List<JsonAdaptedProduct> products) {
        this.clients.addAll(clients);
        this.products.addAll(products);
    }

    /**
     * Converts a given {@code ReadOnlyMyInsuRec} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableMyInsuRec}.
     */
    public JsonSerializableMyInsuRec(ReadOnlyMyInsuRec source) {
        clients.addAll(source.getClientList().stream().map(JsonAdaptedClient::new).collect(Collectors.toList()));
        products.addAll(source.getProductList().stream().map(JsonAdaptedProduct::new).collect(Collectors.toList()));
    }

    /**
     * Converts this MyInsuRec into the model's {@code MyInsuRec} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public MyInsuRec toModelType() throws IllegalValueException {
        MyInsuRec myInsuRec = new MyInsuRec();
        for (JsonAdaptedClient jsonAdaptedClient : clients) {
            Client client = jsonAdaptedClient.toModelType();
            if (myInsuRec.hasClient(client)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_CLIENT);
            }
            myInsuRec.addClient(client);
            for (Meeting meeting : client.getMeetings()) {
                myInsuRec.addMeeting(meeting);
            }
        }
        for (JsonAdaptedProduct jsonAdaptedProduct : products) {
            Product product = jsonAdaptedProduct.toModelType();
            myInsuRec.addProduct(product);
        }
        return myInsuRec;
    }

}
