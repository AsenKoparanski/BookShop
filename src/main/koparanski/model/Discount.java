package main.koparanski.model;

import java.util.List;

/**
 * Author: Asen Koparanski
 * Purpose: Provide logic for the discount applied to books.
 * Date: 17.03.2019
 */
public class Discount {
    /**
     * Apply discounts to a given list of books and return the final total price.
     * @param books
     * @return totalPrice
     */
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
