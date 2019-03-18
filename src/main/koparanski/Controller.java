package main.koparanski;


import main.koparanski.model.Book;
import main.koparanski.model.Datasource;
import main.koparanski.model.Discount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Asen Koparanski
 * Purpose: GUI controller to manage user actions.
 * Date: 17.03.2019
 */

public class Controller {

    @FXML
    private Label finalPrice;

    @FXML
    private TableView<Book> bookTable;

    
    public void initialize() {
        bookTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    @FXML
    public void refreshTable() {
        bookTable.getSelectionModel().clearSelection();
        finalPrice.setText("");

    }
    @FXML
    public void getAllBooks() {

        Task<ObservableList<Book>> task = new GetAllBooksTask();
        bookTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
    @FXML
    public void buyBooksButton() {
        List<Book> books = new ArrayList<>();
        books = bookTable.getSelectionModel().getSelectedItems();
        Discount discount = new Discount();
        double totalPrice = discount.applyDiscount(books);
        finalPrice.setText(String.format("%.2f", totalPrice));
    }
}
/*
Helper class to run a potentially longer task on a background thread.
Calls the method to query the database for all the books and returns an observable ArrayList.
 */
class GetAllBooksTask extends Task {
    @Override
    public ObservableList<Book> call() {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryBooks());

    }
}