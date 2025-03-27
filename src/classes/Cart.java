package classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartProduct> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(CartProduct product) {
        this.products.add(product);
    }

    public void removeProduct(CartProduct product) {
        this.products.remove(product);
    }

    public List<CartProduct> getProducts() {
        return products;
    }
}
