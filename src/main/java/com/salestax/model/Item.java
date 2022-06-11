package main.java.com.salestax.model;

import java.util.regex.Pattern;

public class Item {
	private int quantity;
	private String name;
    private double basePrice;
    private double priceWithTax;
	private boolean isImported;
    private boolean isExempted;
	
    public Item(int quantity, String name, double basePrice){
        this.quantity = quantity;
        this.name = name;
        this.basePrice = basePrice;
        setSaleType(name);
    }
    
    private void setSaleType(String name){
        Pattern exemptPattern = Pattern.compile("book|chocolate|pill");
        Pattern importPattern = Pattern.compile("imported");
        if (exemptPattern.matcher(name).find()) {
            this.isExempted = true;
        }
        if (importPattern.matcher(name).find()) {
            this.isImported = true;
        }
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isExempted() {
		return isExempted;
	}

	public void setExempted(boolean isExempted) {
		this.isExempted = isExempted;
	}

}
