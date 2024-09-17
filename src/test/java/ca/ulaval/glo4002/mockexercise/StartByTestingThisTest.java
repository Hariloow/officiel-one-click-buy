package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StartByTestingThisTest {
    private StartByTestingThis service;

     @BeforeEach
     public void setUp() {
         service = new StartByTestingThis();
     }

    @Test
    public void whenAddCartWithCartFactory() {
        Cart cart = service.createCart("test@gmail.com");
        assertNotNull(cart);
    }

    @Test
    public void whenAddProductAndSearch_findInCart() {
        Product product = new Product("idTest", "nameTest", 15.0);
        Cart cart = service.createCart("test@gmail.com");

        cart.addProduct(product);
        assertEquals(cart.findBySku("idTest"), product);
    }

    @Test
    public void whenSearchProductInDB_thenFindInDB() {
        ProductDBMock db = new ProductDBMock();
        Product product = new Product("idTest", "nameTest", 15.0);

        db.addProduct(product);
        assertEquals(db.findBySku("idTest"), product);
    }

    @Test
    public void whenProductInCart_addInvoiceLineInInvoice(){
        Product product = new Product("idTest", "nameTest", 15.0);
        Cart cart = service.createCart("test@gmail.com");

        cart.addProduct(product);
        InvoiceLine lastInvoiceLine = cart.getLastInvoiceLine();

        assertNotNull(lastInvoiceLine);
        assertEquals(lastInvoiceLine, product);
    }

    public class ProductDBMock extends ProductDB { }

    public class InvoiceLineMock extends InvoiceLine {
        public InvoiceLineMock(String lineText, double price) {
            super(lineText, price);
        }
    }
}