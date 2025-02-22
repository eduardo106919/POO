import java.util.Scanner;


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
        int[] values = {1,2,3,4,5};
        Ficha2 fc2 = new Ficha2(values);

        System.out.print("Chose a exercise to execute: ");
        int choice = input.nextInt();

        switch(choice) {
            case 1:
                int[] arr = new int[10];
                for (int i = 0; i < 10; i++)
                    arr[i] = i;

                System.out.println("minimum: " + fc2.minimum());

                // exercise 1
                break;
            default:
                break;
        }
    }
}
