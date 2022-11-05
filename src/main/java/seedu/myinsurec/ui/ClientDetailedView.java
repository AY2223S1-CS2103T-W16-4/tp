package seedu.myinsurec.ui;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.myinsurec.commons.core.LogsCenter;
import seedu.myinsurec.model.client.Address;
import seedu.myinsurec.model.client.Birthday;
import seedu.myinsurec.model.client.Client;
import seedu.myinsurec.model.client.Email;
import seedu.myinsurec.model.meeting.Meeting;

/**
 * Panel containing a detailed view of a client.
 */
public class ClientDetailedView extends UiPart<Region> {
    private static final String FXML = "ClientDetailedView.fxml";

    public final Client client;

    private final Logger logger = LogsCenter.getLogger(ClientDetailedView.class);

    @FXML
    private Label clientName;

    @FXML
    private Label phoneNumber;

    @FXML
    private Label email;

    @FXML
    private Label address;

    @FXML
    private Label birthday;

    @FXML
    private VBox meetings;

    @FXML
    private FlowPane products;

    /**
     * Creates a {@code ClientDetailedView} with the given {@code Client}.
     */
    public ClientDetailedView(Client client) {
        super(FXML);
        this.client = client;
        clientName.setText(client.getName().toString());
        phoneNumber.setText(client.getPhone().toString());
        email.setText(client.getEmail().map(Email::toString).orElse(""));
        address.setText(client.getAddress().map(Address::toString).orElse(""));
        Optional<Birthday> clientBirthday = client.getBirthday();
        if (clientBirthday.isEmpty()) {
            birthday.setText("");
        } else {
            birthday.setText(clientBirthday.get().formattedDate());
        }
        client.getProducts().stream()
                .forEach(product -> products.getChildren().add(new Label(product.productName)));
        List<Meeting> clientMeetings = client.getMeetings();
        for (Meeting meeting : clientMeetings) {
            meetings.getChildren().add(new MeetingCondensedView(meeting).getRoot());
        }
    }
}
