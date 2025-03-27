package classes;

import java.util.UUID;

public class CartProduct {
    private UUID productId;
    private int amount;

    public CartProduct(UUID productId, double price, int quantity) {
        this.productId = productId;
        this.amount = quantity;
    }

    public UUID getId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int quantity) {
        this.amount = quantity;
    }
}
