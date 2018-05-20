package agh.cs.lab.vending_machine;

public class Button {

    /**
     * Button id
     */
    int id;

    /**
     * Id of the Product associated with this Button.
     */
    int productId;

    public Button(int id, int productId) {
        this.productId = productId;
        this.id = id;
    }

}
