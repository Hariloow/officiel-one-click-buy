package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;
import ca.ulaval.glo4002.mockexercise.do_not_edit.InvoiceLine;
import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ProductRepository {
    private final String email;
    private final List<Product> products = new ArrayList<>();
    private final List<InvoiceLine> invoiceLines = new ArrayList<>();

    public Cart(String email) {
        this.email = email;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product findBySku(String sku) {
        for(Product product : products){
            if (product.getSku().equals(sku)) {
                return product;
            }
        }

        return null;
    }

    public InvoiceLine getLastInvoiceLine() {
            return invoiceLines.getLast();
    }
}
