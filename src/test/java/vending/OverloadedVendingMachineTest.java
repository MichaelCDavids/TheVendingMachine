package vending;

import org.junit.jupiter.api.Test;
import vending.product.Chocolate;
import vending.product.Product;
import vending.product.SaltySnack;
import vending.product.SoftDrink;

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
        assertEquals(30,ovm.getStock(new Chocolate()));
    }

    @Test
    void testOverloadedVendingMachineGetStockForSaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        assertEquals(7,ovm.getStock(new SaltySnack()));
    }

    @Test
    void testOverloadedVendingMachineGetStockForSoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        assertEquals(10,ovm.getStock(new SoftDrink()));
    }

    @Test
    void testOverloadedVendingMachineGetStockMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        assertEquals(23,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineBuySoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new SoftDrink());
        ovm.buy(new SoftDrink());
        assertEquals(8,ovm.getStock(new SoftDrink()));
    }

    @Test
    void testOverloadedVendingMachineBuySaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new SaltySnack());
        ovm.buy(new SaltySnack());
        assertEquals(5,ovm.getStock(new SaltySnack()));
    }

    @Test
    void testOverloadedVendingMachineBuyChocolateMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new Chocolate());
        ovm.buy(new Chocolate());
        assertEquals(4,ovm.getStock(new Chocolate()));
    }

    @Test
    void testOverloadedVendingMachineBuyOneOfEachMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new Product());
        assertEquals(20,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineAddStockSoftDrinkMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(new SoftDrink());
        assertEquals(11,ovm.getStock(new SoftDrink()));
    }

    @Test
    void testOverloadedVendingMachineAddStockChocolateMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(new Chocolate());
        assertEquals(7,ovm.getStock(new Chocolate()));
    }

    @Test
    void testOverloadedVendingMachineAddStockSaltySnackMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(new SaltySnack());
        assertEquals(8,ovm.getStock(new SaltySnack()));
    }

    @Test
    void testOverloadedVendingMachineAddStockProductMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.addStock(new Product());
        assertEquals(26,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineBuyProductSoftDrinkQtyMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new SoftDrink(),5);
        assertEquals(5,ovm.getStock(new SoftDrink()));
    }

    @Test
    void testOverloadedVendingMachineBuyProductSaltySnackQtyMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new SaltySnack(),5);
        assertEquals(2,ovm.getStock(new SaltySnack()));
    }

    @Test
    void testOverloadedVendingMachineBuyProductChocolateQtyMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new Chocolate(),5);
        assertEquals(1,ovm.getStock(new Chocolate()));
    }

    @Test
    void testOverloadedVendingMachineBuyProductQtyMethod(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,7,6);
        ovm.buy(new Product(),2);
        assertEquals(17,ovm.getStock());
    }

    @Test
    void testOverloadedVendingMachineAddStockChocolateMethodWithQuantity(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,10);
        ovm.addStock(new Chocolate(),10);
        assertEquals(20,ovm.getStock(new Chocolate()));
    }

    @Test
    void testOverloadedVendingMachineAddStockSoftDrinkMethodWithQuantity(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,10);
        ovm.addStock(new SoftDrink(),10);
        assertEquals(20,ovm.getStock(new SoftDrink()));
    }

    @Test
    void testOverloadedVendingMachineAddStockSaltySnackMethodWithQuantity(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,10);
        ovm.addStock(new SaltySnack(),10);
        assertEquals(20,ovm.getStock(new SaltySnack()));
    }
    @Test
    void testOverloadedVendingMachineAddStockOfEachMethodWithQuantity(){
        OverloadedVendingMachine ovm = new OverloadedVendingMachine(10,10,10);
        ovm.addStock(new Product(),10);
        assertEquals(60,ovm.getStock());
    }

}
