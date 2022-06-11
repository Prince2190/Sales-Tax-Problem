package main.java.com.salestax.io;

import main.java.com.salestax.model.Item;

public class ReceiptOutput {
	private String format = "%s %.2f %n";

    public void purchaseList(Item item) {
        System.out.format(format, item.getQuantity() + " " + item.getName() + ": ", item.getPriceWithTax());
    }

    public void salesTax(double taxTotal) {
        System.out.format(format, "Sales Taxes: ", taxTotal);
    }

    public void totalSale(Double saleTotal) {
        System.out.format(format, "Total: ", saleTotal);
        System.out.println();
    }
}
