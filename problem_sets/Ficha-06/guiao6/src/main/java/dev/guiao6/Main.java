package dev.guiao6;

import dev.guiao6.cars.*;
import dev.guiao6.stands.*;

import java.util.*;

/**
 * Classe de teste para a Ficha 06
 */
public class Main {

    /**
     * Programa principal para executar os testes criados
     *
     * @param args argumentos da linha de comandos
     */
    public static void main(String[] args) {

        Map<String, String> m1 = new HashMap<>();
        Map<String, String> m2 = new HashMap<>();

        m1.put("chave", "valor");
        m2.put("chave", "valor");

        System.out.println(m1.equals(m2));  // true


        System.out.println("----- Ficha 06 -----");
        
        CarroCombustao c1 = new CarroCombustao("11-AA-11", "Civic",   "Honda",      2015, 115.0, 45.0, 6.2, 1.75);
        CarroCombustao c2 = new CarroCombustao("22-BB-22", "Astra",   "Opel",       2017, 105.0, 50.0, 5.9, 1.78);
        CarroCombustao c3 = new CarroCombustao("33-CC-33", "308",     "Peugeot",    2019, 98.0,  48.0, 5.5, 1.72);
        CarroCombustao c4 = new CarroCombustao("44-DD-44", "Passat",  "Volkswagen", 2021, 125.0, 55.0, 6.8, 1.85);
        CarroCombustao c5 = new CarroCombustao("55-EE-55", "Corolla", "Toyota",     2020, 110.0, 50.0, 5.6, 1.80);
        CarroCombustao c6 = new CarroCombustao("12-AB-34", "Golf",    "Volkswagen", 2018, 110.0, 50.0, 6.5, 1.80);
        CarroCombustao c7 = new CarroCombustao("56-CD-78", "Clio",    "Renault",    2020, 100.0, 45.0, 5.8, 1.70);
        CarroCombustao c8 = new CarroCombustao("90-EF-12", "Focus",   "Ford",       2016, 120.0, 60.0, 7.2, 1.95);

        CarroEletrico e1 = new CarroEletrico("66-FF-66", "e-Niro",         "Kia",        2021, 120.0, 64.0, 15.9, 0.17);
        CarroEletrico e2 = new CarroEletrico("77-GG-77", "Zoe",            "Renault",    2020, 100.0, 52.0, 17.2, 0.19);
        CarroEletrico e3 = new CarroEletrico("88-HH-88", "ID.3",           "Volkswagen", 2022, 115.0, 58.0, 16.0, 0.18);
        CarroEletrico e4 = new CarroEletrico("99-II-99", "Mustang Mach-E", "Ford",       2023, 130.0, 75.7, 18.5, 0.22);
        CarroEletrico e5 = new CarroEletrico("00-JJ-00", "EQC",            "Mercedes",   2021, 125.0, 80.0, 19.0, 0.20);
        CarroEletrico e6 = new CarroEletrico("34-GH-56", "Model 3",        "Tesla",      2022, 130.0, 75.0, 14.0, 0.16);
        CarroEletrico e7 = new CarroEletrico("78-IJ-90", "Leaf",           "Nissan",     2019, 95.0,  40.0, 17.0, 0.18);
        CarroEletrico e8 = new CarroEletrico("12-KL-34", "i3",             "BMW",        2017, 105.0, 42.2, 15.6, 0.20);

        ArrayList<Carro> car_list = new ArrayList<Carro>();
        car_list.add(c1);
        car_list.add(c2);
        car_list.add(c3);
        car_list.add(c4);
        car_list.add(c5);
        car_list.add(c6);
        
        car_list.add(e1);
        car_list.add(e2);
        car_list.add(e3);
        car_list.add(e4);
        car_list.add(e5);
        car_list.add(e6);

        CarRental stand = new CarRental(car_list, new ArrayList<Comparator<Carro>>());

        // teste: toString()
        System.out.println(stand.toString());

        // teste: existe_carro(String cod)
        System.out.println("Existe '44-DD-44': " + stand.existe_carro("44-DD-44"));
        System.out.println("Existe '77-GG-77': " + stand.existe_carro("77-GG-77"));
        System.out.println("Existe '12-KL-34': " + stand.existe_carro("12-KL-34"));

        // teste: quantos()
        System.out.println("Nr Carros: " + stand.quantos());

        // teste: quantos(String marca)
        System.out.println("[Marca] Volkswagen: " + stand.quantos("Volkswagen"));
        System.out.println("[Marca] Ford: " + stand.quantos("Ford"));

        // teste: get_carro(String cod)
        System.out.print(stand.get_carro("99-II-99"));
        System.out.println(stand.get_carro("56-CD-78"));

            
        // teste: adiciona(Carro c)
        stand.adiciona(c7);
        stand.adiciona(c8);
        System.out.println("Nr Carro: " + stand.quantos());
        System.out.println(stand.toString());

        // teste: 



    }
}
