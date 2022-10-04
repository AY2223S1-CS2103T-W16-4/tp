package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.MyInsuRec;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyMyInsuRec;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.client.Client;
import seedu.address.testutil.PersonBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Client validPerson = new PersonBuilder().build();

        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPerson), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Client validPerson = new PersonBuilder().build();
        AddCommand addCommand = new AddCommand(validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_CLIENT, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Client alice = new PersonBuilder().withName("Alice").build();
        Client bob = new PersonBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different client -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getMyInsuRecFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMyInsuRecFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addClient(Client person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMyInsuRec(ReadOnlyMyInsuRec newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyMyInsuRec getMyInsuRec() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasClient(Client person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteClient(Client target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClient(Client target, Client editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Client> getFilteredClientList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredClientList(Predicate<Client> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single client.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Client person;

        ModelStubWithPerson(Client person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasClient(Client person) {
            requireNonNull(person);
            return this.person.isSameClient(person);
        }
    }

    /**
     * A Model stub that always accept the client being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Client> personsAdded = new ArrayList<>();

        @Override
        public boolean hasClient(Client person) {
            requireNonNull(person);
            return personsAdded.stream().anyMatch(person::isSameClient);
        }

        @Override
        public void addClient(Client person) {
            requireNonNull(person);
            personsAdded.add(person);
        }

        @Override
        public ReadOnlyMyInsuRec getMyInsuRec() {
            return new MyInsuRec();
        }
    }

}
