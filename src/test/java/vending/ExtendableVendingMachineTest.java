package vending;

import org.junit.jupiter.api.Test;
import vending.product.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExtendableVendingMachineTest {

    @Test
    void testExtendableVendingMachineConstructor(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3, 4);
        assertTrue(evm instanceof ExtendableVendingMachine);
    }

    @Test
    void testExtendableVendingMachineBuyChocolateMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.buy(new Chocolate());
        assertEquals(0, evm.getStock(new Chocolate()));

    }

    @Test
    void testExtendableVendingMachineBuySoftDrinkMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);

        evm.buy(new SoftDrink());
        assertEquals(1, evm.getStock(new SoftDrink()));
    }

    @Test
    void testExtendableVendingMachineBuySaltySnackMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.buy(new SaltySnack());
        assertEquals(2, evm.getStock(new SaltySnack()));
    }

    @Test
    void testExtendableVendingMachineBuyMuffinMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.buy(new Muffin());
        assertEquals(3, evm.getStock(new Muffin()));
    }

    @Test
    void testExtenableVendingMachineBuyProductMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.buy(new Product());
        assertEquals(10, evm.getStock(new Product()));

    }

    @Test
    void ExtendableVendingMachineGetStockMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        assertEquals(10, evm.getStock(new Product()));
    }

    @Test
    void ExtendableVendingMachineGetStockMuffinMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        assertEquals(4, evm.getStock(new Muffin()));
    }

    @Test
    void ExtendableVendingMachineGetStockSaltySnackMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        assertEquals(3, evm.getStock(new SaltySnack()));
    }

    @Test
    void ExtendableVendingMachineAddStockProductMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new Product());
        assertEquals(3, evm.getStock(new SaltySnack()));
    }

    @Test
    void ExtendableVendingMachineAddStockSaltySnackMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new SaltySnack());
        assertEquals(6, evm.getStock(new SaltySnack()));
    }

    @Test
    void ExtendableVendingMachineAddStockMuffinMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new Muffin());
        assertEquals(7, evm.getStock(new Muffin()));
    }

    @Test
    void ExtendableVendingMachineAddStockSoftDrinkMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new SoftDrink());
        assertEquals(5, evm.getStock(new SoftDrink()));
    }

    @Test
    void ExtendableVendingMachineAddStockChocolateMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new Chocolate());
        assertEquals(4, evm.getStock(new Chocolate()));
    }

    @Test
    void ExtendableVendingMachineAddStockChocolateQtyMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new Chocolate(),1);
        assertEquals(2, evm.getStock(new Chocolate()));
    }

    @Test
    void ExtendableVendingMachineAddStockChocolateZeroQtyMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(1,2,3,4);
        evm.addStock(new Chocolate(),5);
        assertEquals(6, evm.getStock(new Chocolate()));
    }

    @Test
    void ExtendableVendingMachineBuyQtyChocolateMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(200,2,3,4);
        evm.buy(new Chocolate(),100);
        assertEquals(100, evm.getStock(new Chocolate()));
    }

    @Test
    void ExtendableVendingMachineBuyQtyChocolateTooMuchMethod(){
        ExtendableVendingMachine evm = new ExtendableVendingMachine(200,2,3,4);
        evm.buy(new Chocolate(),300);
        assertEquals(200, evm.getStock(new Chocolate()));
    }
}
