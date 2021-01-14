import Controller.Observable.StockDatabaseSystem;
import Controller.Payment.CardPayment;
import Controller.Payment.CashPayment;
import Controller.Payment.CustomerController;
import Controller.StockDatabaseController;
import Model.AdminSection.Observers.IStockOrders;
import Model.AdminSection.Observers.StockOrders;
import View.AdminSection.AdminView;

import View.CustomerSection.CustomerKioskView;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Tests {

    //region Class Objects
    //Controllers
    CustomerKioskView customerKioskView;
    CustomerController customerController;
    StockDatabaseSystem stockDatabaseSystem;
    StockDatabaseController stockDatabaseController;
    AdminView adminView = new AdminView("");
    IStockOrders iStockOrders;
    StockOrders stockOrders;
    CashPayment cashPayment;
    CardPayment cardPayment;

    @Before
    public void SetUp(){
        System.out.println("");
        stockDatabaseSystem = new StockDatabaseSystem();
        stockDatabaseController = new StockDatabaseController(stockDatabaseSystem, adminView);
        iStockOrders = new StockOrders(stockDatabaseSystem);
        cashPayment = new CashPayment(customerKioskView, customerController, stockDatabaseSystem, stockOrders);
        cardPayment = new CardPayment(customerKioskView, stockOrders);

    }

    @Test
    public void testAddStockItemName(){
        iStockOrders.setStockName("Beans");
        stockDatabaseSystem.Add(iStockOrders);
        System.out.println(stockDatabaseSystem.stockItems.toString());
        stockDatabaseSystem.stockItems.toArray().toString();
    }

    @Test
    public void testEditStockItemBarcode(){
        System.out.println("Testing Edit Barcode");
        int editBarcode = 12345;
        iStockOrders.setBarcode(73904);
        System.out.println(iStockOrders.getBarcode());
        iStockOrders.setBarcode(editBarcode);
        System.out.println(iStockOrders.getBarcode());
        assertEquals(editBarcode, iStockOrders.getBarcode());
    }

    @Test
    public void testEditStockItemName(){
        System.out.println("Testing Edit Name");
        String editName = "Chocolate";
        iStockOrders.setStockName("Milk");
        System.out.println(iStockOrders.getStockName());
        iStockOrders.setStockName(editName);
        System.out.println(iStockOrders.getStockName());
        assertEquals(editName, iStockOrders.getStockName());
    }

    @Test
    public void testEditStockItemQuantity(){
        System.out.println("Testing Edit Quantity");
        String editName = "Chocolate";
        iStockOrders.setStockName("Milk");
        System.out.println(iStockOrders.getStockName());
        iStockOrders.setStockName(editName);
        System.out.println(iStockOrders.getStockName());
        assertEquals(editName, iStockOrders.getStockName());
    }

    @Test
    public void testEditStockItemPrice(){
        System.out.println("Testing Edit Price");
        double editPrice = 2.00;

        iStockOrders.setStockPrice(5.00);
        System.out.println(iStockOrders.getStockPrice());
        iStockOrders.setStockPrice(editPrice);
        System.out.println(iStockOrders.getStockPrice());
        assertEquals(editPrice + " ", iStockOrders.getStockPrice() + " ");
    }

    @Test
    public void testRemoveStockItem(){
        ArrayList<StockOrders> emptyArray = new ArrayList<>();

        iStockOrders.setStockName("Beans");
        stockDatabaseSystem.Add(iStockOrders);
        System.out.println(stockDatabaseSystem.stockItems.toString());;
        stockDatabaseSystem.stockItems.isEmpty();
    }

    @Test
    public void testSendUpdateMethod(){
        int barcode = 12;
        String  name = "Beans";
        int quantity = 100;
        double price = 2.00;

        stockDatabaseSystem.setValues(barcode, name, quantity, price);
        stockDatabaseSystem.sendUpdate();
    }

    @Test
    public void testRestockItem(){
        int RefillQuantity = 50;
        iStockOrders.setQuantity(30);
        if(iStockOrders.getStockQuantity() < 40){
            iStockOrders.setQuantity(RefillQuantity);
        }
        assertEquals(RefillQuantity, iStockOrders.getStockQuantity());
    }

    @Test
    public void testCreditCardDetails(){
        int bankNumber = 1234;
        String name = "John";
        cardPayment.setBankNumber(1234);
        cardPayment.setBankName("John");
        if(bankNumber == cardPayment.getBankNumber() && name.equals(cardPayment.getBankName())){
            System.out.println("Details are correct!");
        }
        assertEquals(bankNumber, cardPayment.getBankNumber());
        assertEquals(name, cardPayment.getBankName());
    }

    @Test
    public void testSetCashAmountGiven(){
        double cashAmount = 2.00;
        cashPayment.setCashAmount(cashAmount);
        assertEquals(cashAmount + "", cashPayment.getCashAmount() + "");
    }

    @Test
    public void testGetCashAmountReturned(){
        double cashAmount = 2.00;
        double getcashAmount;
        cashPayment.setCashAmount(cashAmount);
        getcashAmount = cashPayment.getCashAmount();
        assertEquals(cashAmount + "", getcashAmount + "");
    }

    @Test
    public void testSetBarcodeMethod(){
        System.out.println("Testing Set Barcode");
        int testBarcode = 12345;
        iStockOrders.setBarcode(12345);
        assertEquals(testBarcode, iStockOrders.getBarcode());
        System.out.println(testBarcode + " " + iStockOrders.getBarcode());
    }

    @Test
    public void testSetNameMethod(){
        System.out.println("Testing Set Name");
        String testName = "Beans";
        iStockOrders.setStockName("Beans");
        assertEquals(testName, iStockOrders.getStockName());
        System.out.println(testName + " " + iStockOrders.getStockName());
    }

    @Test
    public void testSetQuantityMethod(){
        System.out.println("Testing Set Quantity");
        int testQuantity = 100;
        iStockOrders.setQuantity(100);
        assertEquals(testQuantity, iStockOrders.getStockQuantity());
        System.out.println(testQuantity + " " + iStockOrders.getStockQuantity());
    }

    @Test
    public void testSetPriceMethod(){
        System.out.println("Testing Set Price");
        double testPrice = 2.29;
        iStockOrders.setStockPrice(2.29);
        assertEquals(testPrice + " ", iStockOrders.getStockPrice() + " ");
        System.out.println(testPrice + " " + iStockOrders.getStockQuantity());
    }
}
