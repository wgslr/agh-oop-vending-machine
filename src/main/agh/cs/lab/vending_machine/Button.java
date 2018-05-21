package agh.cs.lab.vending_machine;

public class Button {

    /**
     * Button id
     */
    private final int id;

    /**
     * Id of the Product associated with this Button.
     */
    private final int productId;

    public Button(int id, int productId) {
        this.productId = productId;
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public int getId() {
        return id;
    }
}
