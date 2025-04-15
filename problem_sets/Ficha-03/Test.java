import java.util.Scanner;



/**
 * Classe de teste das classes da Ficha 3
 */
public class Test {

    /**
     * Programa principal
     *
     * @param args argumentos passados pela linha de comandos
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolhe uma classe a testar:");
        System.out.println(" 1 - Circulo");
        System.out.println(" 2 - Sensor");
        System.out.println(" 3 - Música");
        System.out.println(" 4 - Telemóvel");
        System.out.println(" 5 - Video de Youtube");
        System.out.println(" 6 - Lâmpada");
        System.out.println(" 7 - Jogo de Futebol");
        System.out.println(" 8 - Carro");
        System.out.println(" 9 - Linha de Encomenda");
        System.out.println("10 - Encomenda");
        System.out.println("11 - Triângulo");

        System.out.print("class: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\n---------- Circulo ----------");
                Circulo circ1 = new Circulo();
                Circulo circ2 = new Circulo(5, 6, 9);
                Circulo circ3 = new Circulo(circ2);

                System.out.println("circulo 1:\n" + circ1.toString());
                System.out.println("\ncirculo 2:\n" + circ2.toString());
                System.out.println("\ncirculo 3:\n" + circ3.toString());
                
                System.out.println("\nx de circulo 1: " + circ1.get_x());
                System.out.println("y de circulo 2: " + circ2.get_y());
                System.out.println("raio de circulo 3: " + circ3.get_raio());

                System.out.println("\nA alterar circulo 1...");
                circ1.set_x(9);
                circ1.set_y(-3);
                circ1.set_raio(5);
                System.out.println("circulo 1:\n" + circ1.toString());

                System.out.println("\nA alterar centro do circulo 3...");
                circ3.altera_centro(-6, 3);
                System.out.println("circulo 3:\n" + circ3.toString());

                System.out.println("\nA calcular àrea e perimetro do circulo 2...");
                System.out.println("àrea: " + circ2.calcula_area() + "\nperimetro: " + circ2.calcula_perimetro());
                
                Circulo circ4 = circ3.clone();
                System.out.println("\ncirculo 4:\n" + circ4.toString());

                System.out.println("\ncirculo 3 == circulo 4: " + circ3.equals(circ4));
                System.out.println("circulo 1 == circulo 2: " + circ1.equals(circ2));

                break;

            case 2:
                System.out.println("\n---------- Sensor ----------");

                Sensor sens1 = new Sensor();
                Sensor sens2 = new Sensor(45);
                Sensor sens3 = new Sensor(sens2);

                System.out.println("sensor 1 | " + sens1.toString());
                System.out.println("sensor 2 | " + sens2.toString());
                System.out.println("sensor 3 | " + sens3.toString());

                System.out.println("\npressao do sensor 2: " + sens2.get_pressao());

                System.out.println("\nA alterar pressao do sensor 1 e 3...");
                if (sens3.set_pressao(-10) == false) {
                    System.out.println("Não foi possível alterar a pressão do sensor 3 para -10");
                }

                sens1.set_pressao(78);
                System.out.println("sensor 1 | " + sens1.toString());
                System.out.println("sensor 3 | " + sens3.toString());

                Sensor sens4 = sens1.clone();
                System.out.println("\nsensor 4 | " + sens4.toString());
                System.out.println("\nsensor 1 == sensor 4 : " + sens1.equals(sens4));
                System.out.println("sensor 1 == sensor 3 : " + sens1.equals(sens3));

                break;

            case 3:
                System.out.println("\n---------- Música ----------");

                String[] earfquakeLyrics = {
                	"\tFor real, for real this time",
                	"\tFor real, for real, for real this time",
                	"\tBitch, I cannot fall short",
                	"\tFor real, for real, for real this time (yeah yeah)",
                	"\tFor real, for real, for real this time",
                	"\t'Cause you make my earth quake",
                	"\tOh, you make my earth quake",
                	"\tRiding around, your love is shakin' me up and it's making my heart break",
                	"\t'Cause you make my earth quake (earth quake, ooh)",
                	"\tOh, you make my earth quake",
                	"\tRiding around, your love is shakin' me up and it's making my heart break",
                	"\tDon't leave, it's my fault",
                	"\tDon't leave, it's my fault",
                	"\tDon't leave, it's my fault (yeah)",
                	"\t'Cause when it all comes crashing down I'll need you",
                	"\t'Cause you make my earth quake",
                	"\tOh, you make my earth quake",
                	"\tRiding around, you tell me something, baby, and it's making my heart break",
                	"\t'Cause you make my earth quake",
                	"\tOh, you make my earth quake (earth quake, yeah)",
                	"\tRiding around, your love is shakin' me up and it's making my heart break (you already know)",
                	"\tWe ain't gotta ball, D.Rose, huh",
                	"\tDon't give a fuck 'bout nun', huh",
                	"\tBeamin' like fuck my lungs, huh",
                	"\tJust might call my lawyer, huh",
                	"\tPlug gon' set me up, huh",
                	"\tBih, don't set me up, fuck that",
                	"\tI'm with Tyler, yuh (slime)",
                	"\tHe ride like the car, huh",
                	"\tAnd she wicked, huh, yuh",
                	"\tLike Woah Vicky, huh, yeah (like Woah Vicky)",
                	"\tOh my God, hold up, um",
                	"\tThese diamonds not Tiffany, huh, yeah",
                	"\tSo in love",
                	"\tSo in love",
                	"\tDon't leave, it's my fault (fault)",
                	"\tDon't leave, it's my fault",
                	"\tDon't leave, it's my fault",
                	"\t'Cause when it all comes crashing down I'll need you",
                	"\t'cause you make my earth quake",
                	"\tI don't want no confrontation, no",
                	"\tYou don't want my conversation (I don't want no conversation)",
                	"\tI just need some confirmation on how you feel, for real (for real)",
                	"\t(Ay) you don't want no complication, no",
                	"\tI don't want no sovereign nation (I don't want no sovereign nation)",
                	"\tI don't even know 'bout that 'cause I'm for real (for real)",
                	"\tI said don't leave, it's my fault (one)",
                	"\tI said don't leave, it's my fault (two, two)",
                	"\tDon't leave, its, it's my fault girl (three, three, three)",
                	"\tDon't, do-do-do-do-do, I need"
                };

                String[] notes = {"do re mi", "fa si", "do re mi fa si sol"};
                Musica m1 = new Musica();
                Musica m2 = new Musica("EARFQUAKE", "Tyler and Carti", "Tyler, the Creator", "Earfquake publisher", earfquakeLyrics, notes, 190);
                Musica m3 = new Musica(m2);

                System.out.println(m2.toString());

                System.out.println("m2 == m3: " + m2.equals(m3));
                System.out.println("m2 == m1: " + m2.equals(m1));

                System.out.println("qtsLinhasPoema: " + (m2.qtsLinhasPoema() == earfquakeLyrics.length));
                System.out.println("numeroCaracteres: " + m2.numeroCarateres());

                m2.addLetra(10, earfquakeLyrics[0]);
                System.out.println(m2.toString());

                System.out.println("linha mais longa: " + m2.linhaMaisLonga());

                String[] more3 = m2.letrasMaisUtilizadas();
                for (String item : more3) {
                    System.out.println(item);
                }


                



                break;
            default:
                System.out.println("Valor Inválido!!");
                break;
        }

        input.close();
    }
}
