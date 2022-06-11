package main.java.com.salestax.model;

public class SalesTaxCalculator implements TaxCalculator {

	private TaxCalculator calculator;
	
	public SalesTaxCalculator(TaxCalculator calculator) {
	    this.calculator = calculator;
	}
	
	@Override
	public Item getItem() {
		return calculator.getItem();
	}

	/**
	 * Returns 10% basic sales tax for the item
	 */
	@Override
	public double calculate() {
		return calculator.calculate() + 
				getItem().getBasePrice() * getItem().getQuantity() * 0.1;
	}
	
}
