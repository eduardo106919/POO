import java.util.TreeMap;

/**
 * Class that represents a order line for a single product
 */
public class Order_Line {

    /**
     * Instance Variables
     */

    private String product_id;
    private String description;
    private double price; // before taxes
    private double quantity;
    private double taxes; // in percentage (i.e: 6%, 13%, 23%, etc)
    private double comercial_discount; // in percentage


    /**
     * Constructors
     */

    /**
     * Creates an empty order line
     */
    public Order_Line() {
        this.product_id = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
        this.taxes = 0;
        this.comercial_discount = 0;
    }

    /**
     * Creates a order line with parameters
     *
     * @param reference Product identifier/reference
     * @param description Product description
     * @param privce Product price before taxes
     * @param quantity Amount of product to order
     * @param taxes tax percentage
     * @param comercial_discount discount to aply to the price before taxes
     */
    public Order_Line(String reference, String description, double price, double quantity, double taxes, double comercial_discount) {
        this.product_id = reference;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.taxes = taxes;
        this.comercial_discount = comercial_discount;
    }

    /**
     * Creates an Order Line through another Order Line
     *
     * @param other Another Order Line
     */
    public Order_Line(Order_Line other) {
        this.product_id = other.product_id;
        this.description = other.description;
        this.price = other.price;
        this.quantity = other.quantity;
        this.taxes = other.taxes;
        this.comercial_discount = other.comercial_discount;
    }


    /**
     * Instance Methods
     */

    // getters

    /**
     * Returns the product reference
     *
     * @return product reference
     */
    public String get_reference() {
        return this.product_id;
    }

    /**
     * Returns the product description
     *
     * @return product description
     */
    public String get_description() {
        return this.description;
    }

    /**
     * Returns the product price, before taxes
     *
     * @return product price
     */
    public double get_price() {
        return this.price;
    }

    /**
     * Returns the amount of product
     *
     * @return amount of product
     */
    public double get_quantity() {
        return this.quantity;
    }

    /**
     * Returns the tax percentage
     *
     * @return tax percentage on the product
     */
    public double get_taxes() {
        return this.taxes;
    }

    /**
     * Returns the comercial discount, in percentage
     *
     * @return comercial discount on the product, before taxes
     */
    public double get_comercial_discount() {
        return this.comercial_discount;
    }

    // setters

    /**
     * Changes the order line reference
     *
     * @param reference new reference
     */
    public void set_reference(String reference) {
        this.product_id = reference;
    }

    /**
     * Changes the order line description
     *
     * @param description new description
     */
    public void set_description(String description) {
        this.description = description;
    }

    /**
     * Changes the product's price
     *
     * @param price new product price
     */
    public void set_price(double price) {
        this.price = price;
    }

    /**
     * Changes the product quantity
     *
     * @param quantity new quantity
     */
    public void set_quantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Changes the tax percentage on the product
     *
     * @param taxes new tax percentage
     */
    public void set_taxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * Changes the comercial discount percentage on the product
     *
     * @param comercial_discount new comercial discount
     */
    public void set_comercial_discount(double comercial_discount) {
        this.comercial_discount = comercial_discount;
    }

    // other methods

    /**
     * Returns the final price of the order line
     *
     * @return final price
     */
    public double order_line_value() {
        double discount = 1 - (this.comercial_discount / 100);
        double with_discount = this.quantity * this.price * discount;
        double tax = with_discount * (this.taxes / 100);

        return with_discount + tax;
    }

    /**
     * Returns the value, in euros, of the comercial discount
     *
     * @return value of comercial discount
     */
    public double discount_value() {
        double discount = 1 - (this.comercial_discount / 100);

        return this.quantity * this.price * discount;
    }

    /**
     * Checks if another object is equal to the caller
     *
     * @param other object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || other.getClass() != this.getClass())
            return false;
        Order_Line temp = (Order_Line) other;
        return this.product_id.equals(temp.product_id) && this.description.equals(temp.description) &&
               this.price == temp.price && this.quantity == temp.quantity &&
               this.taxes == temp.taxes && this.comercial_discount == temp.comercial_discount;
    }

    /**
     * Clones the calling object
     *
     * @return cloned object
     */
    public Order_Line clone() {
        return new Order_Line(this);
    }

    /**
     * Turns an Order Line into a string
     *
     * @return String with the information about an Order Line
     */
    public String toString() {
        return "reference: " + this.product_id + "\ndescription: " + this.description +
               "\nprice: " + this.price + "\nquantity: " + this.quantity +
               "\ntaxes: " + this.taxes + "\ncomercial discount: " + this.comercial_discount;
    }
}
