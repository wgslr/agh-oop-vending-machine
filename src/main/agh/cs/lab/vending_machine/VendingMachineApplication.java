package agh.cs.lab.vending_machine;


import java.util.*;

public class VendingMachineApplication {
    static Machine machine;

    public static void main(String[] args) {

        int productCount = 6;
        List<Product> products = new ArrayList<>(productCount);

        Random rng = new Random();
        Set<Integer> generated = new LinkedHashSet<>();
        while (generated.size() < productCount) {
            Integer next = rng.nextInt(2137) + 1;
            generated.add(next);
        }
        Iterator<Integer> iterator = generated.iterator();
        products.add(new Product(iterator.next(), "mamba", 8.0, 8));        // 1
        products.add(new Product(iterator.next(), "monsterek", 5.99, 6));   // 2
        products.add(new Product(iterator.next(), "paluszkis", 4.29, 8));   // 3
        products.add(new Product(iterator.next(), "water", 1.25, 10));      // 4
        products.add(new Product(iterator.next(), "tissues", 0.85, 20));    // 5
        products.add(new Product(iterator.next(), "mentoski", 2.34, 15));   // 6

        machine = new Machine(products, new CoinSlot(2));
    }

    void repl() {

    }

}
