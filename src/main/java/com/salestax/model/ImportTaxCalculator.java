package main.java.com.salestax.model;

public class ImportTaxCalculator implements TaxCalculator {

	private TaxCalculator calculator;

	public ImportTaxCalculator(TaxCalculator calculator) {
	    this.calculator = calculator;
	}
	
	@Override
	public Item getItem() {
		return calculator.getItem();
	}

	/**
	 *  Returns 5% import tax for the item
	 */
	@Override
	public double calculate() {
		return calculator.calculate() + 
				getItem().getBasePrice() * getItem().getQuantity() * 0.05; 
	}

}
