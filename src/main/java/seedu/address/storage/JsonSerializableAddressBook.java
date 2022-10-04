package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.MyInsuRec;
import seedu.address.model.ReadOnlyMyInsuRec;
import seedu.address.model.client.Client;

/**
 * An Immutable MyInsuRec that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate client(s).";

    private final List<JsonAdaptedPerson> persons = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("persons") List<JsonAdaptedPerson> persons) {
        this.persons.addAll(persons);
    }

    /**
     * Converts a given {@code ReadOnlyMyInsuRec} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyMyInsuRec source) {
        persons.addAll(source.getClientList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code MyInsuRec} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public MyInsuRec toModelType() throws IllegalValueException {
        MyInsuRec addressBook = new MyInsuRec();
        for (JsonAdaptedPerson jsonAdaptedPerson : persons) {
            Client client = jsonAdaptedPerson.toModelType();
            if (addressBook.hasPerson(client)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            addressBook.addPerson(client);
        }
        return addressBook;
    }

}
