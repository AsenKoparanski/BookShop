package main.koparanski.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

    private SimpleIntegerProperty id;
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleDoubleProperty price;

    public Book() {
        this.id = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.year = new SimpleIntegerProperty();
        this.price = new SimpleDoubleProperty();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

}
