package asen.koparanski;


import asen.koparanski.model.Book;
import asen.koparanski.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * Author: Asen Koparanski
 * Purpose:
 * Date: 17.03.2019
 */

public class Controller {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private TableView<Book> bookTable;

    public void initialize() {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    @FXML
    public void getAllBooks() {

        Task<ObservableList<Book>> task = new GetAllEmployeesTask();
        bookTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}
// Helper class to run a background thread for a potentially longer task.
class GetAllEmployeesTask extends Task {
    @Override
    public ObservableList<Book> call() {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryBooks());

    }
}