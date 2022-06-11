package main.java.com.salestax.model;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
	private List<Item> catalog = new ArrayList<Item>();

    public Item addItem(int quantity, String name, double price) {
        Item item = new Item(quantity, name, price);
        this.catalog.add(item);
        return item;
    }

    public List<Item> getCatalog(){
        return this.catalog;
    }
}
