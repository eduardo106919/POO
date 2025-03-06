
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Class that represents an Order
 */
public class Order {

    /**
     * Instance Variables
     */

    private String client_name;
    private int NIF;
    private String adress;
    private int order_number;
    private LocalDate date;

    private Order_Line[] orders;
    private int orders_count;


    /**
     * Constructors
     */

    /**
     * Creates an empty Order
     */
    public Order() {
        this.client_name = "";
        this.NIF = 0;
        this.adress = "";
        this.order_number = 0;
        this.date = null;
        this.orders = new Order_Line[10];
        this.orders_count = 0;
    }
    
    /**
     * Creates an Order with parameters
     *
     * @param client_name Client who made the order
     * @param NIF Client NIF
     * @param adress Client adress
     * @param order_number order number
     * @param date date in which the order was made
     * @param orders Order lines
     * @param orders_count number of orders
     */
    public Order(String client_name, int NIF, String adress, int order_number, LocalDate date, Order_Line[] orders, int orders_count) {
        this.client_name = client_name;
        this.NIF = NIF;
        this.adress = adress;
        this.order_number = order_number;
        this.date = date;
        this.orders = new Order_Line[orders.length];

        for (int i = 0; i < orders_count; i++) {
            this.orders[i] = orders[i].clone();
        }

        this.orders_count = orders_count;
    }

    public Order(Order other) {
        this.client_name = other.client_name;
        this.NIF = other.NIF;
        this.adress = other.adress;
        this.order_number = other.order_number;
        this.date = other.date;
        this.orders = new Order_Line[other.orders.length];

        for (int i = 0; i < other.orders_count; i++) {
            this.orders[i] = other.orders[i].clone();
        }
        
        this.orders_count = other.orders_count;
    }

    /**
     * Instance Methods
     */

    // getters

    /**
     * Returns the client name who made the order
     *
     * @return client name
     */
    public String get_client_name() {
        return this.client_name;
    }

    /**
     * Returns the NIF of the client
     *
     * @return clients NIF
     */
    public int get_NIF() {
        return this.NIF;
    }

    /**
     * Returns the client adress
     *
     * @return client adress
     */
    public String get_adress() {
        return this.adress;
    }

    /**
     * Returns the order number
     *
     * @return order number
     */
    public int get_order_number() {
        return this.order_number;
    }

    /**
     * Returns the order date
     *
     * @return order date
     */
    public LocalDate get_date() {
        return this.date;
    }


    public Order_Line[] get_orders() {
        Order_Line[] result = new Order_Line[this.orders_count];

        for (int i = 0; i < this.orders_count; i++)
            result[i] = this.orders[i].clone();

        return result;
    }

    // setters

    /**
     * Changes the client name who made the order
     *
     * @param client_name new clients name
     */
    public void set_client_name(String client_name) {
        this.client_name = client_name;
    }

    /**
     * Changes the client NIF
     *
     * @param NIF new NIF
     */
    public void set_NIF(int NIF) {
        this.NIF = NIF;
    }

    /**
     * Changes the clients adress
     *
     * @param adress new adress
     */
    public void set_adress(String adress) {
        this.adress = adress;
    }

    /**
     * Changes the order number
     *
     * @param order_number new order number
     */
    public void set_order_number(int order_number) {
        this.order_number = order_number;
    }

    /**
     * Changes the order date
     *
     * @param date new date
     */
    public void set_date(LocalDate date) {
        this.date = date;
    }

    /**
     * Changes the orders made by the client
     *
     * @param orders new orders
     * @param orders_count number of orders
     */
    public void set_orders(Order_Line[] orders, int orders_count) {
        this.orders = new Order_Line[orders.length];
        for (int i = 0; i < orders_count; i++) {
            this.orders[i] = orders[i].clone();
        }
    }

    // other methods

    /**
     * Checks if two objects are equal
     *
     * @param other object to compare
     * @return true if the objects are equal
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || other.getClass() != this.getClass())
            return false;
        Order temp = (Order) other;
        return this.client_name.equals(temp.client_name) && this.NIF == temp.NIF &&
               this.adress.equals(temp.adress) && this.order_number == temp.order_number && this.date.equals(temp.date) &&
               this.orders.equals(temp.orders) && this.orders_count == temp.orders_count;
    }

    /**
     * Clones an Order
     *
     * @return cloned Order
     */
    public Order clone() {
        return new Order(this);
    }

    /**
     * Turns an Order into a String
     *
     * @return String with the Order information
     */
    public String toString() {
        return "client name: " + this.client_name + "\nNIF: " + this.NIF + "\nadress: " + this.adress +
               "\norder number: " + this.order_number + "\ndate: " + this.date.toString() + "\norders: " + Arrays.toString(this.orders);
    }
}
