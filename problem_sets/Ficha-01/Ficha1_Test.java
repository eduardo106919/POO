
import java.util.Scanner;

public class Ficha1_Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ficha1 fc1 = new Ficha1();
        double value1, value2;
        int value3, value4;
        String name;

        System.out.print("Select a question to execute [1..7]: ");
        value3 = sc.nextInt();

        switch (value3) {
            case 1:
                // question 1
                System.out.println("Celsius to Farenheit");
                System.out.print("Celsius: ");
                value1 = sc.nextDouble();
                value2 = fc1.celsius_to_farenheit(value1);
                System.out.println("Farenheit: " + value2);
                break;
            case 2:
                // question 2
                System.out.println("Max of two values");
                System.out.print("First value: ");
                value3 = sc.nextInt();
                System.out.print("Second value: ");
                value4 = sc.nextInt();
                System.out.println("Max of [" + value3 + ", " + value4 + "] is " + fc1.max(value3, value4));
                break;
            case 3:
                // question 3
                System.out.println("Account information");
                System.out.print("Enter your name: ");
                name = sc.next();
                System.out.print("Paycheck: ");
                value1 = sc.nextDouble();
                System.out.println(fc1.account_description(name, value1));
                break;
            case 4:
                // question 4
                System.out.println("Euros to Pounds");
                System.out.print("Value in euros(€): ");
                value1 = sc.nextDouble();
                System.out.print("Conversion rate to pounds(£): ");
                value2 = sc.nextDouble();
                System.out.println(value1 + "€ == " + fc1.euros_to_pounds(value1, value2) + "£");
                break;
            case 5:
                // question 5
                System.out.println("Average and descending");
                System.out.print("First value: ");
                value3 = sc.nextInt();
                System.out.print("Second value: ");
                value4 = sc.nextInt();
                System.out.println(fc1.average_descending(value3, value4));
                break;
            case 6:
                // question 6
                System.out.println("Factorial");
                System.out.print("Value: ");
                value3 = sc.nextInt();
                System.out.println("Factorial of " + value3 + " is " + fc1.factorial(value3));
                break;
            case 7:
                // question 7
                System.out.println("Time spent");
                System.out.println("Time to calculate 5000! is " + fc1.time_spent() + " miliseconds");
                break;
            default:
                System.out.println("Invalid question number");
                break;
        }

        sc.close();

    }
}
