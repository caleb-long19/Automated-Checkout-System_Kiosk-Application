import Controller.Observable.StockDatabaseSystem;
import Controller.StockDatabaseController;
import Model.AdminSection.Observers.IStockOrders;
import Model.AdminSection.Observers.StockOrders;
import View.AdminSection.AdminView;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Tests {

    //region Class Objects
    //Controllers
    StockDatabaseSystem stockDatabaseSystem;
    StockDatabaseController stockDatabaseController;
    AdminView adminView = new AdminView("");
    IStockOrders stockItem;

    String itemName;

    @Before
    public void SetUp(){
        System.out.println("");
        stockDatabaseSystem = new StockDatabaseSystem();
        stockDatabaseController = new StockDatabaseController(stockDatabaseSystem, adminView);
        stockItem = new StockOrders(stockDatabaseSystem);

    }

    @Test
    public void testAddStockItemName(){
        stockItem.setStockName("Beans");
        stockDatabaseSystem.Add(stockItem);
        System.out.println(stockDatabaseSystem.stockItems.toString());
        stockDatabaseSystem.stockItems.toArray().toString();
    }

    @Test
    public void testEditStockItemBarcode(){
        System.out.println("Testing Edit Barcode");
        int editBarcode = 12345;
        stockItem.setBarcode(73904);
        System.out.println(stockItem.getBarcode());
        stockItem.setBarcode(editBarcode);
        System.out.println(stockItem.getBarcode());
        assertEquals(editBarcode, stockItem.getBarcode());
    }

    @Test
    public void testEditStockItemName(){
        System.out.println("Testing Edit Name");
        String editName = "Chocolate";
        stockItem.setStockName("Milk");
        System.out.println(stockItem.getStockName());
        stockItem.setStockName(editName);
        System.out.println(stockItem.getStockName());
        assertEquals(editName, stockItem.getStockName());
    }

    @Test
    public void testEditStockItemQuantity(){
        System.out.println("Testing Edit Quantity");
        String editName = "Chocolate";
        stockItem.setStockName("Milk");
        System.out.println(stockItem.getStockName());
        stockItem.setStockName(editName);
        System.out.println(stockItem.getStockName());
        assertEquals(editName, stockItem.getStockName());
    }

    @Test
    public void testEditStockItemPrice(){
        System.out.println("Testing Edit Price");
        double editPrice = 2.00;

        stockItem.setStockPrice(5.00);
        System.out.println(stockItem.getStockPrice());
        stockItem.setStockPrice(editPrice);
        System.out.println(stockItem.getStockPrice());
        assertEquals(editPrice + " ", stockItem.getStockPrice() + " ");
    }

    @Test
    public void testRemoveStockItem(){
        ArrayList<StockOrders> emptyArray = new ArrayList<>();

        stockItem.setStockName("Beans");
        stockDatabaseSystem.Add(stockItem);
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

    }

    @Test
    public void testCustomerKioskAddItem(){

    }

    @Test
    public void testCreditCardDetails(){

    }

    @Test
    public void testCashAmountGiven(){

    }

    @Test
    public void testCashAmountReturned(){

    }

    @Test
    public void testCustomerReceiptDetails(){

    }

    @Test
    public void testSetBarcodeMethod(){
        System.out.println("Testing Set Barcode");
        int testBarcode = 12345;
        stockItem.setBarcode(12345);
        assertEquals(testBarcode, stockItem.getBarcode());
        System.out.println(testBarcode + " " + stockItem.getBarcode());
    }

    @Test
    public void testSetNameMethod(){
        System.out.println("Testing Set Name");
        String testName = "Beans";
        stockItem.setStockName("Beans");
        assertEquals(testName, stockItem.getStockName());
        System.out.println(testName + " " + stockItem.getStockName());
    }

    @Test
    public void testSetQuantityMethod(){
        System.out.println("Testing Set Quantity");
        int testQuantity = 100;
        stockItem.setQuantity(100);
        assertEquals(testQuantity, stockItem.getStockQuantity());
        System.out.println(testQuantity + " " + stockItem.getStockQuantity());
    }

    @Test
    public void testSetPriceMethod(){
        System.out.println("Testing Set Price");
        double testPrice = 2.29;
        stockItem.setStockPrice(2.29);
        assertEquals(testPrice + " ", stockItem.getStockPrice() + " ");
        System.out.println(testPrice + " " + stockItem.getStockQuantity());
    }
}
