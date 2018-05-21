package agh.cs.lab.vending_machine;


import java.util.*;
import java.util.function.Supplier;

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
        int idx = 0;
        products.add(new Product(idx++, "espresso", 8.0, 8));        // 1
        products.add(new Product(idx++, "latte", 5.99, 6));   // 2
        products.add(new Product(idx++, "cappucino", 4.29, 8));   // 3
        products.add(new Product(idx++, "water", 1.25, 10));      // 4
        products.add(new Product(idx++, "tissues", 0.85, 20));    // 5
        products.add(new Product(idx++, "mentoski", 2.34, 15));   // 6

        machine = new Machine(products, new CoinSlot(2));

        test();
    }

    static void test() {
        printResult(machine.pressButton(0), "Choose espresso (expected failure)");
        printResult(machine.insertCoin(8), "Insert first coin");
        printResult(machine.takeProduct(), "Take product (expected failure)");
        printResult(machine.pressButton(2), "Choose paluszki");
        printResult(machine.takeProduct(), "Take product");

        printResult(machine.insertCoin(2), "Insert first coin");
        printResult(machine.insertCoin(4), "Insert second coin");
        printResult(machine.insertCoin(1), "Insert third coin (expected failure)");

        printResult(machine.pressButton(3), "Choose water");
        printResult(machine.pressButton(3), "Choose water (expected failure)");

    }

    static void printResult(boolean result, String description) {
        if(result) {
            System.out.println("Action " + description + " succesfull");
        } else {
            System.out.println("Action " + description + " failed");
        }
    }

}
