package agh.cs.lab.vending_machine;

import java.util.List;
import java.util.stream.Collectors;

public class Machine {
    CoinSlot slot;

    List<Product> products;
    List<Button> buttons;

    Product productToReceive;

    public Machine(List<Product> products, CoinSlot slot) {
        this.products = products;
        this.slot = slot;

        buttons = products.stream()
                .map((Product x) -> new Button(x.id, x.id))
                .collect(Collectors.toList());

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
