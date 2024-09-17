package ca.ulaval.glo4002.mockexercise;

import java.util.HashMap;

import ca.ulaval.glo4002.mockexercise.do_not_edit.ProductRepository;

public class ProductDB implements ProductRepository {
    private HashMap<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getSku(), product);
    }

    @Override
    public Product findBySku(String sku) {
        return products.get(sku);
    }

}