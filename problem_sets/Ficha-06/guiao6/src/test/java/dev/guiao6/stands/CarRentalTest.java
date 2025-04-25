
package dev.guiao6.stands;

import dev.guiao6.cars.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {

    CarroCombustao c1,c2,c3,c4,c5,c6,c7,c8;
    CarroEletrico e1,e2,e3,e4,e5,e6,e7,e8;
    CarRental stand;

    @BeforeEach
    void setUp() {
        c1 = new CarroCombustao("11-AA-11", "Civic",   "Honda",      2015, 115.0, 45.0, 6.2, 1.75);
        c2 = new CarroCombustao("22-BB-22", "Astra",   "Opel",       2017, 105.0, 50.0, 5.9, 1.78);
        c3 = new CarroCombustao("33-CC-33", "308",     "Peugeot",    2019, 98.0,  48.0, 5.5, 1.72);
        c4 = new CarroCombustao("44-DD-44", "Passat",  "Volkswagen", 2021, 125.0, 55.0, 6.8, 1.85);
        c5 = new CarroCombustao("55-EE-55", "Corolla", "Toyota",     2020, 110.0, 50.0, 5.6, 1.80);
        c6 = new CarroCombustao("12-AB-34", "Golf",    "Volkswagen", 2018, 110.0, 50.0, 6.5, 1.80);
        c7 = new CarroCombustao("56-CD-78", "Clio",    "Renault",    2020, 100.0, 45.0, 5.8, 1.70);
        c8 = new CarroCombustao("90-EF-12", "Focus",   "Ford",       2016, 120.0, 60.0, 7.2, 1.95);

        e1 = new CarroEletrico("66-FF-66", "e-Niro",         "Kia",        2021, 120.0, 64.0, 15.9, 0.17);
        e2 = new CarroEletrico("77-GG-77", "Zoe",            "Renault",    2020, 100.0, 52.0, 17.2, 0.19);
        e3 = new CarroEletrico("88-HH-88", "ID.3",           "Volkswagen", 2022, 115.0, 58.0, 16.0, 0.18);
        e4 = new CarroEletrico("99-II-99", "Mustang Mach-E", "Ford",       2023, 130.0, 75.7, 18.5, 0.22);
        e5 = new CarroEletrico("00-JJ-00", "EQC",            "Mercedes",   2021, 125.0, 80.0, 19.0, 0.20);
        e6 = new CarroEletrico("34-GH-56", "Model 3",        "Tesla",      2022, 130.0, 75.0, 14.0, 0.16);
        e7 = new CarroEletrico("78-IJ-90", "Leaf",           "Nissan",     2019, 95.0,  40.0, 17.0, 0.18);
        e8 = new CarroEletrico("12-KL-34", "i3",             "BMW",        2017, 105.0, 42.2, 15.6, 0.20);

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
    }

    @Test
    void existe_carro() {
        assertTrue(stand.existe_carro("33-CC-33"));
        assertTrue(stand.existe_carro("88-HH-88"));
        assertFalse(stand.existe_carro("dskhlds"));
    }

    @Test
    void quantos() {
        assertEquals(12, stand.quantos());
    }

    @Test
    void testQuantos() {
        assertEquals(3, stand.quantos("Volkswagen"));
        assertEquals(1, stand.quantos("Ford"));
    }

    @Test
    void get_carro() {
        assertEquals(c1, stand.get_carro("11-AA-11"));
        assertNull(stand.get_carro("ksdfj"));
    }

    @Test
    void adiciona() {
        stand.adiciona(c7);
        assertEquals(c7, stand.get_carro(c7.get_matricula()));
    }

    @Test
    void get_carros() {

    }

    @Test
    void testAdiciona() {
    }

    @Test
    void registar_viagem() {
    }

    @Test
    void atestar_carro() {
    }

    @Test
    void carro_mais_economico() {
    }

    @Test
    void media_custo_km() {
    }

    @Test
    void custo_real_carro() {
    }

    @Test
    void carros_com_alcance() {
    }

    @Test
    void com_bateria() {
    }
}