package seedu.myinsurec.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.myinsurec.commons.core.LogsCenter;
import seedu.myinsurec.model.client.Client;

/**
 * Panel containing the detailed view of a single client.
 */
public class ClientDetailedViewPanel extends UiPart<Region> {
    private static final String FXML = "ClientDetailedViewPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ClientDetailedViewPanel.class);

    @FXML
    private ListView<Client> detailedClientListView;

    /**
     * Creates a {@code ClientDetailedViewPanel} with the given {@code ObservableList}.
     */
    public ClientDetailedViewPanel(ObservableList<Client> detailedClientList) {
        super(FXML);
        detailedClientListView.setItems(detailedClientList);
        detailedClientListView.setCellFactory(listView -> new ClientDetailedViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Client} using a {@code ClientDetailedView}.
     */
    class ClientDetailedViewCell extends ListCell<Client> {
        @Override
        protected void updateItem(Client client, boolean empty) {
            super.updateItem(client, empty);

            if (empty || client == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ClientDetailedView(client).getRoot());
            }
        }
    }

}
