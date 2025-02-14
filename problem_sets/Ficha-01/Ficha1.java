
import java.time.LocalDateTime;

/**
 * Class for the exercises of problem set 1 part 2
 */
public class Ficha1 {

    /**
     * Turns a value in Celsius to Farenheit
     *
     * @param value Degrees in Celsius
     * @return Degrees in Farenheit
     */
    public double celsius_to_farenheit(double value) {
        return value * 1.8 + 32;
    }

    /**
     * Calculates the maximum of two values
     *
     * @param a First value
     * @param b Second value
     * @return Maximum of a and b
     */
    public int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    /**
     * Shows the account information of a person
     *
     * @param name Name of the person
     * @param value Account balance
     * @return Account information
     */
    public String account_description(String name, double value) {
        return "Mister or Miss " + name + " has " + value + "€ in their account.";
    }

    /**
     * Turns euros in pounds
     *
     * @param value Amount in euros
     * @param conversion_rate Conversion rate to pounds
     * @return Amount in pounds
     */
    public double euros_to_pounds(double value, double conversion_rate) {
        return value * conversion_rate;
    }

    /**
     * Calculates the average of two values and puts in descending order
     *
     * @param a First value
     * @param b Second value
     * @return Average and numbers ordered
     */
    public String average_descending(int a, int b) {
        double average = (a + b) / 2;
        String result = "Average: " + average + " and ";
        if (a > b)
            result = result + a + " > " + b;
        else
            result = result + b + " > " + a;
        return result;
    }

    /**
     * Calculates the factorial of a number
     *
     * @param value Value to calculate the factorial
     * @return Factorial of value
     */
    public long factorial(int value) {
        int result = 1;
        while (value > 1) {
            result *= value;
            value--;
        }

        return result;
    }

    /**
     * Determines the time spent to calculate the factorial of 5000
     *
     * @return Miliseconds to calculate factorial of 5000
     */
    public long time_spent() {
        LocalDateTime before = LocalDateTime.now();

        factorial(5000);

        LocalDateTime after = LocalDateTime.now();

        long total = (after.getSecond() - before.getSecond()) * 1000;

        return total;
    }
}
