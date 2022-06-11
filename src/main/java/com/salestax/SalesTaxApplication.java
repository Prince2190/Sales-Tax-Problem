package main.java.com.salestax;

import java.io.File;
import java.io.IOException;

import main.java.com.salestax.io.ReceiptOutput;
import main.java.com.salestax.io.ReceiptParser;
import main.java.com.salestax.model.Item;
import main.java.com.salestax.model.Purchase;
import main.java.com.salestax.model.ReceiptCalculator;

public class SalesTaxApplication {

	public static void main(String[] inputBaskets) throws IOException {
		String[] defaultBaskets = {  // default input files to be used if no file path 
				                     // received from command line argument(s)
                "assets/input1.txt",  
                "assets/input2.txt",
                "assets/input3.txt"
        };

        String[] baskets = (inputBaskets.length > 0) ?
        		inputBaskets : defaultBaskets;

        for (String basket : baskets) {
            if (new File(basket).exists()){
            	// Receive input, parse it and set model objects
                ReceiptParser receiptParser = new ReceiptParser(basket);
                
                // Calculate total sales price along with applicable tax
                Purchase purchase = receiptParser.getPurchase();
                ReceiptCalculator calculator = new ReceiptCalculator(purchase.getCatalog());
                
                // Displays output to the console
                ReceiptOutput console = new ReceiptOutput();
                for(Item item: purchase.getCatalog()){
                	console.purchaseList(item);
                }
                console.salesTax(calculator.getTaxTotal());
                console.totalSale(calculator.getSaleTotal());
            }
        }
	}

}
