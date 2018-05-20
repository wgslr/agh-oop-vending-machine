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
        if (id >= buttons.size()) return false;
        Product p = products.get(buttons.get(id).productId);
        if (productToReceive == null && p.price > slot.currentValue) {
            productToReceive = p;
            slot.empty();
            return true;
        } else {
            return false;
        }
    }

    void fillProduct(int id) {
        if (id < products.size())
            products.get(id).fill();
    }

    boolean insertCoint(double value) {
        if (products.isEmpty()) {
            return false;
        } else {
            return slot.insertCoin(new Coin(value));
        }
    }

    boolean takeProduct(int id) {
        if (productToReceive == null) {
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
