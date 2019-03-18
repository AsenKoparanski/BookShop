package main.koparanski.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: Asen Koparanski
 * Purpose: Test the logic method in Discount class.
 * Date: 18.03.2019
 */
public class DiscountTest {

    Discount discount = new Discount();

    @org.junit.Test
    public void applyDiscount() {

        // Title = The Terrible Privacy of Maxwell Sim
        Book maxSim = new Book();
        maxSim.setYear(2010);
        maxSim.setPrice(13.14);

        // Title = Still Life With Woodpecker
        Book woodPecker = new Book();
        woodPecker.setYear(1980);
        woodPecker.setPrice(11.05);

        // Title = Three Men in a Boat
        Book menBoat = new Book();
        menBoat.setYear(1889);
        menBoat.setPrice(12.87);

        // Title = Great Expectations
        Book greatExp = new Book();
        greatExp.setYear(1861);
        greatExp.setPrice(13.21);

        List<Book> booksTest1 = new ArrayList<>();
        booksTest1.add(menBoat);
        booksTest1.add(maxSim);

        assertEquals(24.69, discount.applyDiscount(booksTest1), 0.01);

        List<Book> booksTest2 = new ArrayList<>();
        booksTest2.add(woodPecker);
        booksTest2.add(menBoat);
        booksTest2.add(greatExp);

        assertEquals(35.27, discount.applyDiscount(booksTest2), 0.01);

        List<Book> booksTest3 = new ArrayList<>();
        booksTest3.add(maxSim);
        booksTest3.add(menBoat);
        booksTest3.add(greatExp);

        assertEquals(36.01, discount.applyDiscount(booksTest3), 0.01);

    }
}