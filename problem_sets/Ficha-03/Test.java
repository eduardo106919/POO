
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
                // Song
                System.out.println("Class -> Song");

                Song music1 = new Song();
                String[] lyrics = {"\n\tThese niggas talkin' out of they necks",
                                   "\n\tDon't pull no coffin out of your mouth",
                                   "\n\tI'm way too paranoid for a threat",
                                   "\n\tAyy-ayy, let's get it, bro",
                                   "\n\tD-O-T, the money, power, respect",
                                   "\n\tThe last one is better",
                                   "\n\tSay, it's a lot of goofies with a check",
                                   "\n\tI mean, ah, I hope them sentiments symbolic",
                                   "\n\tAh, my temperament bipolar, I choose violence",
                                   "\n\tOkay, let's get it up, it's time for him to prove that he's a problem",
                                   "\n\tNiggas clickin' up, but cannot be legit, no 40 water, tell 'em",
                                   "\n\tAh, yeah, huh, yeah, get up with me (he was once a thug, he was, he -)",
                                   "\n\tFuck sneak dissin', first person shooter (he was once a thug, he was, he -)",
                                   "\n\tI hope they came with three switches (he was once a thug, he was, he -)",
                                   "\n\tI crash out, like, 'Fuck rap,  this Melle Mel if I had to (he was once a thug, he was, he -)",
                                   "\n\tGot two T's with me, I'm snatchin' chains and burnin' tattoos",
                                   "\n\tIt's up, lost too many soldiers not to play it safe",
                                   "\n\tIf he walk around with that stick, it ain't Andre 3K",
                                   "\n\tThink I won't drop the location? I still got PTSD",
                                   "\n\tMotherfuck the big three, nigga, it's just big me"};
                String[] notes = {"\n\tlalalal", "\n\tlalalala", "\n\tdjfskd"};
                Song music2 = new Song("Like that", "Future K Dot", "Metro Boomin", "Young Metro", lyrics, notes, 268, 695586936);
                Song music3 = new Song(music2);

                System.out.println("music1:");
                System.out.println(music1.toString());

                System.out.println("\nmusic2:");
                System.out.println(music2.toString());

                System.out.println("\nmusic3:");
                System.out.println(music3.toString());

                System.out.println("\ntesting getters and setters");
                music1.set_name(music2.get_name());
                music1.set_interpreter(music2.get_interpreter());
                music1.set_author(music2.get_author());
                music1.set_editor_name(music2.get_editor_name());
                music1.set_lyrics(music2.get_lyrics());
                music1.set_notes(music2.get_notes());
                music1.set_duration(music2.get_duration());
                music1.set_streams(music2.get_streams());
                
                System.out.println("music1:");
                System.out.println(music1.toString());

                System.out.println("music1 is equal to music3: " + music1.equals(music3));
                System.out.println("\nchanging music2 name and author:");
                music2.set_name("Not like us");
                music2.set_author("Kendrick Lamar");

                System.out.println("music2:");
                System.out.println(music2.toString());

                System.out.println("How many lines do the music3 lyrics have: " + music3.lyrics_lines_count());
                System.out.println("How many characters dot the music3 lyrics have: " + music3.total_lyrics_chars());
                System.out.println("Longest line in music3: " + music3.longest_line());

                System.out.println("adding: The last one is better");
                music3.add_line(15, "\n\tThe last one is better");
                music3.add_line(19, "\n\tThe last one is better");
                music3.add_line(3, "\n\tThe last one is better");
                
                music3.add_line(3, "\n\tI crash out, like, 'Fuck rap,  this Melle Mel if I had to (he was once a thug, he was, he -)");

                System.out.println("music3:");
                System.out.println(music3.toString());

                System.out.print("Top 3 more frequent lines:");
                String[] aux = music3.most_used_letters();
                for (String item: aux) {
                    System.out.print(item);
                }
                System.out.println();

                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        input.close();

    }
}
