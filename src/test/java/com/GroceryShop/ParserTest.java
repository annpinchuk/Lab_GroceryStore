package com.GroceryShop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void ProductInfoShouldBeCorrect() {
        Parser parser = new Parser();

        var resultProduct = parser.parseProduct("Yogurt Molokiya 40.5 1233123123");

        assertEquals(resultProduct.name, "Yogurt Molokiya ");
        assertEquals(resultProduct.price, 40.5, 0.01);
        assertEquals(resultProduct.barcode, 1233123123);
    }

    @Test (expected = NotParsableException.class)
    public void FailToParseWithoutBarcode() {
        Parser parser = new Parser();

        parser.parseProduct("Yogurt Molokiya 40.5");
    }

    @Test (expected = NotParsableException.class)
    public void FailToParseIfTwoArguments() {
        Parser parser = new Parser();

        parser.parseProduct("Yogurt 40.5");
    }
}
