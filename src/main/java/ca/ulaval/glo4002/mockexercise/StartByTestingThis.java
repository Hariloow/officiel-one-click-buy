package ca.ulaval.glo4002.mockexercise;

import ca.ulaval.glo4002.mockexercise.do_not_edit.CartFactory;
import ca.ulaval.glo4002.mockexercise.do_not_edit.Invoice;

public class StartByTestingThis {
    private CartFactory cartFactory = new CartFactory();
    private ProductDB productDB = new ProductDB();

    public Cart createCart(String email) {
        return cartFactory.create(email);
    }

    public Invoice oneClickBuy(String clientEmail, String productSku) {
        // Étape 1 : Créer le cart avec le CartFactory
        Cart cart = this.createCart(clientEmail);

        // Étape 2 : Trouver le produit avec le ProductRepository
        Product product = productDB.findBySku(productSku);

        // Étape 3 : Ajouter le produit au cart
        if (product == null) { return null; }
        cart.addProduct(product);

        // Étape 4 : Pour chaque item du cart, ajouter une ligne sur l'invoice
        // Étape 5 : Retourner l'invoice
        return null;
    }
}