package main.koparanski.model;

import java.util.List;

public class Discount {

    public double applyDiscount(List<Book> books) {
        double totalPrice = 0.0;
        for(Book book: books) {

            if (book.getYear() > 2000) {
                Book tempBook = new Book();
                tempBook.setPrice(book.getPrice()*0.90);
                totalPrice += tempBook.getPrice();
            } else {
                totalPrice += book.getPrice();
            }
        }
        if (totalPrice > 29.59) {
            totalPrice = totalPrice*0.95;
        }
        return totalPrice;
    }
}
