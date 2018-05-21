package agh.cs.lab.vending_machine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    CoinSlot slot;

    List<Product> products;
    List<Button> buttons;

    Product productToReceive;

    public Machine(List<Product> products, CoinSlot slot) {
        this.products = products;
        this.slot = slot;

        int idx = 0;
        buttons = new ArrayList<>();
        for (Product p : products) {
            buttons.add(new Button(idx++, p.id));
        }

        productToReceive = null;
    }

    boolean pressButton(int id) {
        if (id >= buttons.size()) {
            System.out.println("No such button!");
            return false;
        }
        Button b = buttons.get(id);
        Product p = products.get(b.productId);
        if (productToReceive == null && p.price <= slot.currentValue) {
            productToReceive = p;
            slot.empty();
            return true;
        } else {
            System.out.println("Item not received or not enough money in the slot");
            return false;
        }
    }

    void fillProduct(int id) {
        if (id < products.size())
            products.get(id).fill();
    }

    boolean insertCoin(double value) {
        if (products.isEmpty()) {
            System.out.println("No products in vending machine");
            return false;
        } else {
            return slot.insertCoin(new Coin(value));
        }
    }

    boolean takeProduct() {
        if (productToReceive == null) {
            System.out.println("No product to receive");
            return false;
        } else {
            productToReceive = null;
            return true;
        }
    }

    boolean returnCoins() {
        return slot.returnCoins();
    }

}
