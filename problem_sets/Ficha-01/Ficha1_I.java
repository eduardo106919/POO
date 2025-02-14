
import java.util.Scanner;
import java.time.LocalDateTime;

/**
 * Exercises resolutions for the first part of problem sets 1
 */
public class Ficha1_I {

    /**
     * Calculates the number of days passed in the current month and day
     *
     * @param day Current day
     * @param month Current month
     * @return Number of days passed in the current year
     */
    public static int current_days(int day, int month) {
        int result = 0;
        switch (month) {
            // december
            case 12:
                result += 30;
            // november
            case 11:
                result += 31;
            // september
            case 10:
                result += 30;
            // october
            case 9:
                result += 31;
            // august
            case 8:
                result += 31;
            // july
            case 7:
                result += 30;
            // june
            case 6:
                result += 31;
            // may
            case 5:
                result += 30;
            // april
            case 4:
                result += 31;
            // march
            case 3:
                result += 28;
            // february
            case 2:
                result += 31;
            default:
                break;
        }        

        return result + day;
    }

    /**
     * Calculates the number of days in a date
     *
     * @param day selected day
     * @param month selected month
     * @param year selected year
     * @return Number of days passed since day/month/year
     */
    public static int total_days(int day, int month, int year) {
        int total = (year - 1900) * 365;
        total = total + (year - 1900) / 4;

        if (year % 4 == 0 || month == 1 || month == 2)
            total--;

        total += current_days(day, month);

        return total;
    }

    /** 
     * Determines the day of the week from a date (dd/mm/yyyy)
     *
     * @param day selected day
     * @param month selected month
     * @param year selected year
     * @return Day of the week
     */
    public static String exercise1(int day, int month, int year) {
        int total_days = total_days(day, month, year);
        total_days %= 7;

        String day_week;
        switch (total_days) {
            case 0:
                day_week = "Sunday";
                break;
            case 1:
                day_week = "Monday";
                break;
            case 2:
                day_week = "Tuesday";
                break;
            case 3:
                day_week = "Wednesday";
                break;
            case 4:
                day_week = "Thursday";
                break;
            case 5:
                day_week = "Friday";
                break;
            case 6:
                day_week = "Saturday";
                break;
            default:
                day_week = "Error";
                break;
        }

        return day_week;
    }

    /**
     * Adds two dates and represents the value in days, hours, minutes and seconds
     *
     * @param day1 first day
     * @param month1 first month
     * @param year1 first year
     * @param day2 second day
     * @param month2 second month
     * @param year2 second year
     * @return Value in days, hours, minutes and seconds
     */
    public static String exercise2(int day1, int month1, int year1, int day2, int month2, int year2) {
        int total1 = total_days(day1, month1, year1);
        int total2 = total_days(day2, month2, year2);

        int days = total1 + total2;
        int hours = days * 24;
        int minutes = hours * 60;
        int seconds = minutes * 60;

        return days + "D " + hours + "H " + minutes + "M " + seconds + "S";
    }

    /**
     * Reads n classifications and counts them in ranges
     *
     * @param n total classifications
     * @return Counts
     */
    public static String exercise3(int n) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, temp;
        Scanner sc = new Scanner(System.in);

        while (n > 0) {
            System.out.print("Value: ");
            temp = sc.nextInt();
            if (temp < 5 && temp > 0)
                count1++;
            else if (temp >= 5 && temp < 10)
                count2++;
            else if (temp >= 10 && temp < 15)
                count3++;
            else if (temp >= 15 && temp <= 20)
                count4++;

            n--;
        }

        sc.close();

        return "[0, 5[ -> " + count1 + "\n[5, 10[ -> " + count2 + "\n[10, 15[ -> " + count3 + "\n[15, 10] -> " + count4;
    }


    /**
     * Reads n temperatures and calculates the average and the highest difference in consecutive days
     *
     * @param n total temperatures
     * @return Average and the highest difference
     */
    public static String exercise4(int n) {
        Scanner sc = new Scanner(System.in);
        double average = 0;
        int total = 0;

        double max_change = 0, day_before = 0, current = 0;
        int day = 0;

        while (total < n) {
            System.out.print("Temperature: ");
            current = sc.nextInt();

            average += current;

            // first iteration
            if (total == 0)
                day_before = current;

            if (Math.abs(current - day_before) > max_change) {
                max_change = Math.abs(current - day_before);
                day = total;
            }

            day_before = current;

            total++;
        }


        sc.close();

        String answer = "The average of " + total + " temperatures is " + average / total + " degrees.\n";
        answer += "The biggest variation was registered between day " + day + " and " + (day + 1) + ", the temperature went up/down " + max_change + " degrees.";

        return answer;
    }

    /**
     * Reads the mesuraments of triangles and calculates the area and perimeter
     */
    public static void exercise5() {
        Scanner sc = new Scanner(System.in);

        double base = 1.0, height;
        double area = 0, perimeter = 0;

        System.out.println("To stop give base value 0");

        while (true) {
            System.out.print("Base: ");
            base = sc.nextDouble();

            // stop case
            if (base == 0)
                break;

            System.out.print("Height: ");
            height = sc.nextDouble();

            area = (base * height) / 2;
            perimeter = base + height + (Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));

            System.out.printf("Area = %.5f | Perimeter = %.5f\n", area, perimeter);
        }

        sc.close();
    }

    /**
     * Checks if value is a prime number
     *
     * Assumes value is positive
     *
     * @param value Value to check
     * @return true if value is prime, otherwise false
     */
    public static boolean is_prime(int value) {
        int temp = 2;
        while (value % temp != 0)
            temp++;

        return temp == value;
    }

    /**
     * Primes numbers
     */
    public static void exercise6() {
        Scanner sc = new Scanner(System.in);
        int value;
        String response;

        do {
            System.out.print("Value: ");
            value = sc.nextInt();

            while (value > 1) {
                if (is_prime(value) == true)
                    System.out.println(value);

                value--;
            }
        
            System.out.print("Do you wish to go again [Y/n]: ");
            response = sc.next();
        } while (response.charAt(0) != 'n');

        sc.close();
    }

    /**
     * Birthday
     */
    public static void exercise7() {
        Scanner sc = new Scanner(System.in);

        // get year
        System.out.print("Year: ");
        int year = sc.nextInt();

        // get month
        System.out.print("Month: ");
        int month = sc.nextInt();

        // get day
        System.out.print("Day: ");
        int day = sc.nextInt();

        // determine the number o days
        int age = total_days(day, month, year);

        // get the current date and time
        LocalDateTime current = LocalDateTime.now();        
        System.out.println("Age in hours is " + age + " calculated at " + current.toString());
        
        sc.close();
    }

    /**
     * Program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int value1, value2, value3;
        int value4, value5, value6;

        System.out.print("Select a question [1..7]: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Day of the week");
                System.out.print("Day: ");
                value1 = sc.nextInt();

                System.out.print("Month: ");
                value2 = sc.nextInt();

                System.out.print("Year: ");
                value3 = sc.nextInt();

                System.out.println(value1 + "/" + value2 + "/" + value3 + " was a " + exercise1(value1, value2, value3));

                break;
            case 2:
                System.out.println("Add dates");

                System.out.print("Day 1: ");
                value1 = sc.nextInt();

                System.out.print("Month 1: ");
                value2 = sc.nextInt();

                System.out.print("Year 1: ");
                value3 = sc.nextInt();

                System.out.print("Day 2: ");
                value4 = sc.nextInt();

                System.out.print("Month 2: ");
                value5 = sc.nextInt();

                System.out.print("Year 2: ");
                value6 = sc.nextInt();

                System.out.println(value1 + "/" + value2 + "/" + value3 + " + " + value4 + "/" + value5 + "/" + value6 + " == " + exercise2(value1, value2, value3, value4, value5, value6));

                break;
            case 3:
                System.out.println("Classifications");
                System.out.print("How many classifications you want to add: ");
                value1 = sc.nextInt();

                System.out.println(exercise3(value1));

                break;
            case 4:
                System.out.println("Temperatures");
                value1 = 0;
                do {
                    System.out.print("How many temperatures you want (> 1): ");
                    value1 = sc.nextInt();

                    if (value1 < 2)
                        System.out.println("Invalid value, at least 2.");

                } while (value1 < 2);
                
                System.out.println(exercise4(value1));

                break;
            case 5:
                System.out.println("Triangles");

                exercise5();

                break;
            case 6:
                System.out.println("Prime numbers");

                exercise6();

                break;
            case 7:
                System.out.println("Birthday");

                exercise7();

                break;
            default:
                System.out.println("Invalid choice [1..7]");
                break;
        }

        sc.close();
    }
}