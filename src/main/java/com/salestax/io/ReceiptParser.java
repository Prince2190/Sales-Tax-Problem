package main.java.com.salestax.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.salestax.model.Purchase;

public class ReceiptParser {
	private Purchase purchase;
	
	public ReceiptParser(String basket) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(basket));
            String itemDetails;
            this.purchase = new Purchase();
            while ((itemDetails = reader.readLine()) != null) {
                this.purchase.addItem(
                		scanQuantity(itemDetails),
                        scanName(itemDetails),
                        scanBasePrice(itemDetails)
                );
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    private int scanQuantity(String details) {
        Pattern p = Pattern.compile("^[\\d+]+");
        Matcher m = p.matcher(details);
        m.find();
        return Integer.parseInt(m.group(0));
    }

    private String scanName(String details) {
        Pattern p = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
        Matcher m = p.matcher(details);
        m.find();
        return  m.group(0);
    }

    private double scanBasePrice(String details) {
        Pattern p = Pattern.compile("\\d+.\\d+$");
        Matcher m = p.matcher(details);
        m.find();
        return Double.parseDouble(m.group(0));
    }
}
