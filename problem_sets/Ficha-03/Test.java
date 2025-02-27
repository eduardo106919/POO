
import java.util.Scanner;
import java.util.Random;

/**
 * Class to test the exercises of Ficha 3
 */
public class Test {

    /**
     * Main program
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Chose a class to test:");
        System.out.println(" 1 - Circle");
        System.out.println(" 2 - Sensor");
        System.out.println(" 3 - Song");
        System.out.println(" 4 - Mobile Phone");
        System.out.println(" 5 - Youtube Video");
        System.out.println(" 6 - Light Bulb");
        System.out.println(" 7 - Football Game");
        System.out.println(" 8 - Car");
        System.out.println(" 9 - Order Line");
        System.out.println("10 - Order");

        System.out.print("choice (1..10) : ");
        int choice = input.nextInt();
        System.out.println("-------------------------------");

        switch (choice) {
            case 1:
                // Circle
                System.out.println("Class -> Circle");

                Circle circle1 = new Circle();
                // Circle stores floats, but for simplicity, I will use integers
                Circle circle2 = new Circle(rand.nextInt() % 10, rand.nextInt() % 10, rand.nextInt() % 20);
                Circle circle3 = new Circle(circle2);

                System.out.println("circle1:");
                System.out.println(circle1.toString());

                System.out.println("circle2:");
                System.out.println(circle2.toString());

                System.out.println("circle3:");
                System.out.println(circle3.toString());

                System.out.println("testing setters");
                circle1.set_x(15);
                circle1.set_y(-5);
                circle1.set_radius(6);
                System.out.println("circle1:");
                System.out.println(circle1.toString());
                
                System.out.println("testing getters");
                System.out.println("circle2:");
                System.out.println("x: " + circle2.get_x() + " y: " + circle2.get_y() + " radius: " + circle2.get_radius());
                
                System.out.println("area of circle 3: " + circle3.calculate_area());
                System.out.println("perimeter of circle 3: " + circle3.calculate_perimeter());
                
                System.out.println("Cloning circle1");
                System.out.println("circle4:");
                Circle circle4 = circle1.clone();
                System.out.println(circle4.toString());

                System.out.println("circle1 is equal to circle3: " + circle1.equals(circle3));
                System.out.println("circle1 is equal to circle4: " + circle1.equals(circle4));

                break;
            case 2:
                // Sensor
                System.out.println("Class -> Sensor");

                Sensor sensor1 = new Sensor();
                // Sensor stores floats, but for simplicity, I will use integers
                Sensor sensor2 = new Sensor(rand.nextInt() % 100);
                Sensor sensor3 = new Sensor(sensor2);

                System.out.println("sensor1:");
                System.out.println(sensor1.toString());

                System.out.println("sensor2:");
                System.out.println(sensor2.toString());

                System.out.println("sensor3:");
                System.out.println(sensor3.toString());

                System.out.println("Cloning sensor2:");
                System.out.println("sensor4:");
                Sensor sensor4 = sensor2.clone();
                System.out.println(sensor4.toString());

                System.out.println("sensor1 is equal to sensor2: " + sensor1.equals(sensor2));
                System.out.println("sensor2 is equal to sensor3: " + sensor2.equals(sensor3));

                System.out.println("testing setters\nsetting pressure to " + 50);
                boolean result = sensor1.set_pressure(50.0);
                System.out.println("result: " + result);

                System.out.println("sensor1:");
                System.out.println(sensor1.toString());
                
                System.out.println("setting pressure to " + -10);
                result = sensor1.set_pressure(-10);
                System.out.println("result: " + result);

                System.out.println("sensor1:");
                System.out.println(sensor1.toString());
                
                System.out.println("testing getters");
                System.out.println("pressure on sensor3: " + sensor3.get_pressure());

                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        input.close();

    }
}
