

import java.time.LocalDateTime;
import java.util.Scanner;


public class Ficha01 {

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

    /* Determines the day of the week from a date (dd/mm/yyyy) */
    public static String exercise1(int day, int month, int year) {
        int total_days = (year - 1900) * 365;
        total_days = total_days + (year - 1900) / 4;

        // leap year
        if (year % 4 == 0 || month == 1 || month == 2)
            total_days--;
        
        total_days += current_days(day, month);
        total_days %= 7;

        String day_week = "";
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

    /* programa */
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Day: ");
        int day = reader.nextInt();

        System.out.print("Month: ");
        int month = reader.nextInt();

        System.out.print("Year: ");
        int year = reader.nextInt();

        System.out.printf("Day of the week of %d/%d/%d: %s\n", day, month, year, exercise1(day, month, year));

    }
}


