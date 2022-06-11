package main.java.com.salestax.model;

public class BaseTaxCalculator implements TaxCalculator {
	
	protected Item item;
	
	public BaseTaxCalculator(Item item) {
	    this.item = item;
	}
	
	@Override
	public Item getItem() {
		return item;
	}

	@Override
	public double calculate() {
		return 0;
	}

}
