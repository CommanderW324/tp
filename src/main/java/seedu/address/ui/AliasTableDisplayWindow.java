package seedu.address.ui;

import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Controller for window showing alias mapping
 */
public class AliasTableDisplayWindow extends UiPart<Stage> {
    private static final String FXML = "AliasTableDisplayWindow.fxml";
    @FXML
    private TableView<Map.Entry<String, String>> aliasTableView;
    private HashMap<String, String> aliasTable;

    /**
     * Constructor for the controller of Alias Mapping Display Window
     */
    public AliasTableDisplayWindow(HashMap<String, String> aliasTable) {
        super(FXML, new Stage());
        this.aliasTable = aliasTable;
        this.fillTable(aliasTable);
    }

    /**
     * Shows the window containing alias mapping
     */
    public void show() {
        getRoot().show();
        getRoot().centerOnScreen();
        getRoot().requestFocus();
    }

    /**
     * Hides the alias window
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Fill the table with given hashmap
     */
    public void fillTable(HashMap<String, String> aliasTable) {
        //@@author CommanderW324-reused
        //Code Reuse adapted from tutorial of http://tutorials.jenkov.com/javafx/tableview.html
        TableColumn<Map.Entry<String, String>, String> col1 = new TableColumn<> ("Alias");

        col1.setCellValueFactory((
                TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) -> new SimpleStringProperty(
                p.getValue().getKey()));

        TableColumn<Map.Entry<String, String>, String> col2 = new TableColumn<>("Command");

        col2.setCellValueFactory((
                TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) -> new SimpleStringProperty(
                p.getValue().getValue()));
        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(aliasTable.entrySet());

        aliasTableView.setItems(items);
        aliasTableView.getColumns().add(col1);
        aliasTableView.getColumns().add(col2);
        //@@author
    }

    /**
     * Refreshes the alias table display window
     */
    public void refresh(HashMap<String, String> aliasTable) {
        aliasTableView.getColumns().clear();
        aliasTableView.getItems().clear();
        fillTable(aliasTable);
    }

    /**
     * Returns true if the alias window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }
}
