package test.java.com.salestax;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.com.salestax.model.Purchase;
import main.java.com.salestax.model.ReceiptCalculator;

public class SalesTaxApplicationTest {

	private Purchase purchase;
    private ReceiptCalculator calculator;
    private double expectedTaxTotal;
    private double expectedSaleTotal;
    private double taxTotal;
    private double saleTotal;


    @Before
    public void setUp() throws Exception {
        purchase = new Purchase();
    }

    @Test
    public void test1()throws Exception {
        purchase.addItem(1, "book", 12.49);
        purchase.addItem(1, "music CD", 14.99);
        purchase.addItem(1, "chocolate bar", 0.85);
        calculator = new ReceiptCalculator(purchase.getCatalog());
        expectedSaleTotal = 29.83;
        expectedTaxTotal = 1.50;

        taxTotal  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotal = (double) Math.round(calculator.getSaleTotal() * 100) / 100;

        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedSaleTotal, saleTotal, 0);
    }


    @Test
    public void test2()throws Exception {
        purchase.addItem(1, "imported box of chocolates", 10.00);
        purchase.addItem(1, "imported bottle of perfume", 47.50);
        calculator = new ReceiptCalculator(purchase.getCatalog());
        expectedSaleTotal = 65.15;
        expectedTaxTotal = 7.65;

        taxTotal  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotal = (double) Math.round(calculator.getSaleTotal() * 100) / 100;
        
        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedSaleTotal, saleTotal, 0);
    }

    @Test
    public void test3()throws Exception {
        purchase.addItem(1, "imported bottle of perfume", 27.99);
        purchase.addItem(1, "bottle of perfume", 18.99);
        purchase.addItem(1, "packet of headache pills", 9.75);
        purchase.addItem(1, "box of imported chocolates", 11.25);
        calculator = new ReceiptCalculator(purchase.getCatalog());
        expectedSaleTotal = 74.68;
        expectedTaxTotal = 6.70;

        taxTotal  = (double) Math.round(calculator.getTaxTotal() * 100) / 100;
        saleTotal = (double) Math.round(calculator.getSaleTotal() * 100) / 100;

        assertEquals(expectedTaxTotal, taxTotal, 0);
        assertEquals(expectedSaleTotal, saleTotal, 0);
    }

}
