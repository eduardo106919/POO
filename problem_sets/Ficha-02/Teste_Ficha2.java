import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Class to test the methods of Ficha 2
 */
public class Teste_Ficha2 {

    /**
     * Program to test the methods of Ficha 2
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hello world!!");

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Ficha2 fc2 = new Ficha2();

        System.out.print("Chose a exercise to execute: ");
        int choice = input.nextInt();

        switch(choice) {
            // exercise 1
            case 1:

                int[] arr = get_array();
                if (arr == null)
                    break;

                // a)
                System.out.println("minimum: " + fc2.minimum(arr));

                // b)
                System.out.print("Select an index: ");
                int index1 = input.nextInt();

                System.out.print("Select an index: ");
                int index2 = input.nextInt();

                System.out.printf("Sub-array between %d and %d:\n", index1, index2);
                int[] sub = fc2.range(arr, index1, index2);
                if (sub == null) {
                    System.out.println("Invalid indexes.");
                    break;
                }

                show_array(sub);

                // c)
                System.out.println("First array:");
                int[] first = get_array();
                if (first == null)
                    break;

                System.out.println("Second array:");
                int[] second = get_array();
                if (second == null)
                    break;

                int[] common = fc2.intersect(first, second);
                System.out.println("Common values:");
                show_array(common);

                break;
            // exercise 2
            case 2:

                // a)
                for (int i = 0; i < 20; i++) {
                    fc2.insert_date(LocalDate.of(rand.nextInt(2025) + 1, rand.nextInt(12) + 1, rand.nextInt(27) + 1));
                }

                // c)
                String dates = fc2.toString();
                System.out.print(dates);

                // b)
                LocalDate other = LocalDate.of(rand.nextInt(2025) + 1, rand.nextInt(12) + 1, rand.nextInt(27) + 1);
                System.out.println("Closest date to: " + other + " is " + fc2.closest_date(other));

                break;
            // exercise 3
            case 3:
                int[] ex3 = get_array();
                show_array(ex3);

                fc2.sort(ex3);
                show_array(ex3);

                System.out.print("Select a value to search: ");
                int searching = input.nextInt();
                System.out.println("index: " + fc2.binary_search(ex3, searching));

                break;
            // exercise 4
            case 4:
                

                break;
            // exercise 5
            case 5:
                break;
            // exercise 6
            case 6:
                break;
            // exercise 7
            case 7:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        input.close();
    }


    /**
     * Reads an array from standard Input
     *
     * @return array of integers
     */
    private static int[] get_array() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the array [> 0]: ");
        int size = input.nextInt();
        if (size < 1) {
            System.out.println("Invalid size.");
            input.close();
            return null;
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Value at index %d: ", i);
            result[i] = input.nextInt();
        }

        return result;
    }

    /**
     * Shows an array of integers to standard output
     *
     * @param arr array to show
     */
    private static void show_array(int[] arr) {
        for (int item: arr)
            System.out.print(" " + item);
        System.out.println();
    }
}
