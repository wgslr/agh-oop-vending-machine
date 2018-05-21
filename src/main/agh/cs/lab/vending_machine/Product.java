package agh.cs.lab.vending_machine;

public class Product {
    int id;

    final String name;

    double price;

    int limit;

    int counter;

    public Product(int id, String name, double price, int limit) {
        System.out.println("Creating product with id " + id);
        this.id = id;
        this.name = name;
        this.price = price;
        this.limit = limit;
        this.counter = 0;
    }

    boolean sell() {
        if(counter > 0) {
            --counter;
            return true;
        } else {
            return false;
        }
    }

    void fill() {
        counter = limit;
    }

}
