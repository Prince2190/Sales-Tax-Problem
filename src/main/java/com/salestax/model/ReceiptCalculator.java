package main.java.com.salestax.model;

import java.util.List;

public class ReceiptCalculator {
	private double itemTotal = 0;
	private double taxTotal = 0;
    private double saleTotal = 0;

    public ReceiptCalculator(List<Item> items){
    	/** 
    	 * For each item, evaluate price & tax based on 
    	 * base price, quantity and applicable tax attributes.
    	 * Finally, evaluate total sales price with tax.
    	 */
        for(Item item: items){
       	 	TaxCalculator taxCalculator = new BaseTaxCalculator(item);
            if (!item.isExempted())
            	taxCalculator = new SalesTaxCalculator(taxCalculator);
            if (item.isImported())
            	taxCalculator = new ImportTaxCalculator(taxCalculator);
            taxCalculator = new RoundOff(taxCalculator);
            double salesTax = taxCalculator.calculate();
            this.itemTotal = this.itemTotal + (item.getBasePrice() * item.getQuantity());
            this.taxTotal = this.taxTotal + salesTax;
        }
        this.saleTotal = this.itemTotal + this.taxTotal;
    }

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public double getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(double taxTotal) {
		this.taxTotal = taxTotal;
	}

	public double getSaleTotal() {
		return saleTotal;
	}

	public void setSaleTotal(double saleTotal) {
		this.saleTotal = saleTotal;
	}
}
