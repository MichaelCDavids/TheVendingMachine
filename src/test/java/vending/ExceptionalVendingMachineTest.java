package vending;

import org.junit.jupiter.api.Test;
import vending.exceptions.*;
import vending.product.Chocolate;
import vending.product.Muffin;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionalVendingMachineTest {

    @Test
    void testExpectedMuffinsOutOfStockException() {
        assertThrows(MuffinsOutOfStockException.class, () -> {
            ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);
            exceptionalVendingMachine.buy(new Muffin(),5);
        });
    }

    @Test
    void testExpectedSaltyCracksAllEatenException() {
        assertThrows(SaltyCracksAllEatenException.class, () -> {
            ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);
            exceptionalVendingMachine.buy(new SaltySnack(),15);
        });
    }

    @Test
    void testExpectedSoftDrinksOutOfStockException() {
        assertThrows(SoftDrinksOutOfStockException.class, () -> {
            ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);
            exceptionalVendingMachine.buy(new SoftDrink(),10);
        });
    }

    @Test
    void testExpectedChocolatesAllGoneException() {
        assertThrows(ChocolatesAllGoneException.class, () -> {
            ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);
            exceptionalVendingMachine.buy(new Chocolate(),50);
        });
    }

    @Test
    void testExpectedInvalidProductException() {
        assertThrows(InvalidProductException.class, () -> {
            ExceptionalVendingMachine exceptionalVendingMachine = new ExceptionalVendingMachine(1,2,3,4);
            exceptionalVendingMachine.buy(new Chocolate(),-1);
        });
    }

    @Test
    void testAddStockMethod(){
        ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(1,2,3,4);
        vendingMachine.addStock(new Muffin(),10);
        assertEquals(14,vendingMachine.getStock(new Muffin()));
    }

    @Test
    void testGetStockMethod(){
        ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(1,2,3,4);
        assertEquals(4,vendingMachine.getStock(new Muffin()));
    }

    @Test
    void testBuyMethod(){
        ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(1,2,3,4);
        assertThrows(MuffinsOutOfStockException.class, () -> {
            vendingMachine.buy(new Muffin(),5);
        });
        assertEquals(4,vendingMachine.getStock(new Muffin()));
    }

    @Test
    void testBuyMethodAgain(){
        ExceptionalVendingMachine vendingMachine = new ExceptionalVendingMachine(1,2,3,4);
//        assertThrows(MuffinsOutOfStockException.class, () -> {
//            vendingMachine.buy(new Muffin(),3);
//        });
        try {
            vendingMachine.buy(new Muffin(),3);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(1,vendingMachine.getStock(new Muffin()));
    }

}
