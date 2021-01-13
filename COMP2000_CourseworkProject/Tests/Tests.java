import Controller.AdminSection.AdminController;
import Controller.AdminSection.AdminUsersController;
import Controller.Payment.CardPayment;
import Controller.Payment.CashPayment;
import Controller.Payment.CustomerController;
import Controller.Payment.Receipt;
import Controller.Observable.StockDatabaseSystem;
import Model.AdminSection.AdminModel;
import Model.AdminSection.Observers.StockOrders;
import Model.CustomerSection.Bank;
import Model.CustomerSection.CustomerModel;

import Model.CustomerSection.IPaymentMethod;
import View.AdminSection.AdminView;
import View.CustomerSection.CustomerKioskView;

import org.junit.*;
import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class Tests {

    //region Class Objects
    //Controllers
    StockDatabaseSystem stockDatabaseSystem;
    AdminUsersController adminUsersController;
    AdminController adminController;
    CardPayment cardPayment;
    CashPayment cashPayment;
    CustomerController customerController;
    Receipt receipt;

    //Models
    AdminModel adminModel;
    StockOrders stockOrders;
    CustomerModel customerModel;
    IPaymentMethod iPaymentMethod;

    //View
    AdminView adminView;
    CustomerKioskView customerKioskView;

    //Single Classes
    Bank bank;
    JTextField stockItem = new JTextField();
    //endregion

    @Before
    public void SetUp(){

    }

    @Test
    public void testAddStockItem(){

    }

    @Test
    public void testEditStockItemBarcode(){

    }

    @Test
    public void testEditStockItemName(){

    }

    @Test
    public void testEditStockItemQuantity(){

    }

    @Test
    public void testEditStockItemPrice(){

    }

    @Test
    public void testRemoveStockItem(){

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
    public void testSetMethods(){}

}
