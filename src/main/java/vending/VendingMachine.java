package vending;

import vending.exceptions.ProductNotFoundException;
import vending.product.Product;

public abstract class VendingMachine {
    public abstract void buy( Product p, int i ) throws ProductNotFoundException;
    public abstract int getStock(Product p);
    public abstract void addStock(Product p, int i);
    public abstract void buy( Product product );
}
