package vending;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OverloadedVendingMachineTest {

    @Test
    void testOverloadedVendingMachineConstructor(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,10);
        assertTrue(ovm instanceof OverloadedVendingMachine);
    }

    @Test
    void testOverloadedVendingMachineGetStockForChocolateMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,30);
        ovm.getStock(ovm.chocolate);
        assertEquals(30,ovm.getStock(ovm.chocolate));
    }

    @Test
    void testOverloadedVendingMachineGetStockForSaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.getStock(ovm.chocolate);
        assertEquals(7,ovm.getStock(ovm.saltySnack));
    }

    @Test
    void testOverloadedVendingMachineGetStockForSoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.getStock(ovm.chocolate);
        assertEquals(10,ovm.getStock(ovm.softDrink));
    }

    @Test
    void testOverloadedVendingMachineGetStockMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        assertEquals(23,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineBuySoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(ovm.softDrink);
        ovm.buy(ovm.softDrink);
        assertEquals(8,ovm.getStock(ovm.softDrink));
    }

    @Test
    void testOverloadedVendingMachineBuySaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(ovm.saltySnack);
        ovm.buy(ovm.saltySnack);
        assertEquals(5,ovm.getStock(ovm.saltySnack));
    }

    @Test
    void testOverloadedVendingMachineBuyChocolateMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(ovm.chocolate);
        ovm.buy(ovm.chocolate);
        assertEquals(4,ovm.getStock(ovm.chocolate));
    }

    @Test
    void testOverloadedVendingMachineBuyOneOfEachMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(ovm.product);
        assertEquals(20,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineAddStockSoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(ovm.softDrink);
        assertEquals(13,ovm.getStock(ovm.softDrink));
    }

    @Test
    void testOverloadedVendingMachineAddStockChoclateMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(ovm.chocolate);
        assertEquals(9,ovm.getStock(ovm.chocolate));
    }

    @Test
    void testOverloadedVendingMachineAddStockSaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(ovm.saltySnack);
        assertEquals(10,ovm.getStock(ovm.saltySnack));
    }

    @Test
    void testOverloadedVendingMachineAddStockProductMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(ovm.product);
        assertEquals(32,ovm.getStock());
    }

}
