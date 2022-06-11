package main.java.com.salestax.model;

public class RoundOff implements TaxCalculator {
	
	private TaxCalculator calculator;
	
	public RoundOff(TaxCalculator calculator) {
	    this.calculator = calculator;
	}
	
	@Override
	public Item getItem() {
		return calculator.getItem();
	}

	/**
	 * Sales tax is rounded up to the nearest 0.05, 
	 * & set final sales price including tax for the item
	 */
	@Override
	public double calculate() {
		double roundedOffTax = Math.ceil(calculator.calculate() * 20.0) / 20.0;
		setItemPriceWithTax(roundedOffTax);
		return roundedOffTax;
	}
	
	/**
	 * Sets final sales price of an item
	 * @param tax
	 */
	private void setItemPriceWithTax(double tax) {
		calculator.getItem().setPriceWithTax(
				calculator.getItem().getBasePrice() 
				* calculator.getItem().getQuantity()
				+ tax);
	}
}
