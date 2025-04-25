package dev.guiao6.stands;

import dev.guiao6.cars.*;
import dev.guiao6.comparators.ComparatorCarroKms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {
    private CarRental carRental;
    private CarroEletrico electricCar1;
    private CarroEletrico electricCar2;
    private CarroCombustao combustionCar1;
    private CarroCombustao combustionCar2;

    @BeforeEach
    void setUp() {
        carRental = new CarRental();

        // Create test cars with correct constructor parameters
        electricCar1 = new CarroEletrico("ELC-001", "Model S", "Tesla", 2020, 120.0, 100.0, 15.0, 0.15);
        electricCar2 = new CarroEletrico("ELC-002", "Leaf", "Nissan", 2019, 110.0, 80.0, 12.0, 0.14);
        combustionCar1 = new CarroCombustao("GAS-001", "Corolla", "Toyota", 2021, 105.0, 50.0, 6.5, 1.65);
        combustionCar2 = new CarroCombustao("GAS-002", "Focus", "Ford", 2020, 100.0, 45.0, 7.0, 1.60);

        // Add cars to rental
        carRental.adiciona(electricCar1);
        carRental.adiciona(electricCar2);
        carRental.adiciona(combustionCar1);
        carRental.adiciona(combustionCar2);

        // Add comparators
        carRental.adiciona_comparador(new ComparatorCarroKms());
    }

    @Test
    void testEquals() {
        CarRental same = new CarRental(carRental);
        assertEquals(carRental, same);

        CarRental different = new CarRental();
        assertNotEquals(carRental, different);
    }

    @Test
    void testClone() {
        CarRental clone = carRental.clone();
        assertEquals(carRental, clone);
        assertNotSame(carRental, clone);
    }

    @Test
    void testAdicionaRemoveComparador() {
        int initialSize = carRental.get_comparadores().size();
        carRental.adiciona_comparador(Comparator.comparing(Carro::get_marca));
        assertEquals(initialSize + 1, carRental.get_comparadores().size());

        String comparatorName = ComparatorCarroKms.class.getTypeName();
        carRental.remove_comparador(comparatorName);
        assertEquals(initialSize, carRental.get_comparadores().size());
    }

    @Test
    void testExisteCarro() {
        assertTrue(carRental.existe_carro("ELC-001"));
        assertFalse(carRental.existe_carro("NON-EXISTENT"));
    }

    @Test
    void testQuantos() {
        assertEquals(4, carRental.quantos());
        assertEquals(1, carRental.quantos("Tesla"));
        assertEquals(0, carRental.quantos("Audi"));
    }

    @Test
    void testGetCarro() {
        Carro car = carRental.get_carro("ELC-001");
        assertNotNull(car);
        assertEquals("Tesla", car.get_marca());
        assertNull(carRental.get_carro("NON-EXISTENT"));
    }

    @Test
    void testAdicionaCarros() {
        int initialCount = carRental.quantos();
        Carro newCar = new CarroCombustao("NEW-001", "X5", "BMW", 2022, 115.0, 55.0, 8.0, 1.75);
        carRental.adiciona(newCar);
        assertEquals(initialCount + 1, carRental.quantos());

        Set<Carro> newCars = new HashSet<>();
        newCars.add(new CarroCombustao("NEW-002", "A4", "Audi", 2021, 110.0, 50.0, 7.5, 1.70));
        newCars.add(new CarroEletrico("NEW-003", "Kona", "Hyundai", 2021, 105.0, 90.0, 14.0, 0.16));
        carRental.adiciona(newCars);
        assertEquals(initialCount + 3, carRental.quantos());
    }

    @Test
    void testRegistarViagem() {
        int initialKms = electricCar1.get_kms_totais();
        carRental.registar_viagem("ELC-001", 100);
        Carro afterTrip = carRental.get_carro("ELC-001");
        assertEquals(initialKms + 100, afterTrip.get_kms_totais());

        // Test with non-existent car (should do nothing)
        carRental.registar_viagem("NON-EXISTENT", 100);
    }

    @Test
    void testAtestarCarro() {
        electricCar1.viagem(400); // Use up battery
        carRental.atestar_carro("ELC-001");
        assertEquals(100.0, ((CarroEletrico)carRental.get_carro("ELC-001")).get_bateria_atual(), 0.001);

        combustionCar1.viagem(500); // Use up fuel
        carRental.atestar_carro("GAS-001");
        assertEquals(50.0, ((CarroCombustao)carRental.get_carro("GAS-001")).get_deposito_atual(), 0.001);
    }

    @Test
    void testCarroMaisEconomico() {
        // Electric cars are generally more economical
        Carro mostEconomical = carRental.carro_mais_economico();
        assertTrue(mostEconomical instanceof CarroEletrico);
    }

    @Test
    void testMediaCustoKm() {
        double avgCost = carRental.media_custo_km();
        assertTrue(avgCost > 0);
    }

    @Test
    void testCustoRealCarro() {
        double cost = carRental.custo_real_carro("ELC-001");
        assertTrue(cost > 0);
        assertEquals(0, carRental.custo_real_carro("NON-EXISTENT"));
    }

    @Test
    void testCarrosComAlcance() {
        Set<Carro> carsWithRange = carRental.carros_com_alcance(650);
        assertEquals(3, carsWithRange.size()); // Ford Focus has 640...
    }

    @Test
    void testComBateria() {
        Set<CarroEletrico> electricCars = carRental.com_bateria(90);
        assertEquals(1, electricCars.size()); // Only Tesla has battery >= 90
    }

    @Test
    void testCarroComMaisKms() {
        // Make one car have more kms
        carRental.registar_viagem("GAS-001", 1000);
        Carro mostKms = carRental.carroComMaisKms();
        assertEquals("GAS-001", mostKms.get_matricula());
    }

    @Test
    void testGetEletricosOrd() {
        Set<CarroEletrico> electricCars = carRental.getEletricosOrd();
        assertEquals(2, electricCars.size());
        // Should be ordered by battery level (natural order)
        List<CarroEletrico> orderedList = new ArrayList<>(electricCars);
        assertTrue(orderedList.get(0).get_kms_totais() <= orderedList.get(1).get_kms_totais());
    }

    @Test
    void testOrdenarCarros() {
        String comparatorName = ComparatorCarroKms.class.getTypeName();
        Iterator<Carro> sorted = carRental.ordenarCarros(comparatorName);
        assertNotNull(sorted);

        // Verify order
        Carro prev = sorted.next();
        while (sorted.hasNext()) {
            Carro current = sorted.next();
            assertTrue(prev.get_kms_totais() >= current.get_kms_totais());
            prev = current;
        }
    }

    @Test
    void testCarrosPorAutonomia() {
        Map<Integer, List<Carro>> byAutonomy = carRental.carrosPorAutonomia();
        assertFalse(byAutonomy.isEmpty());
        // Each autonomy value should have at least one car
        assertTrue(!byAutonomy.keySet().isEmpty());
    }

    @Test
    void testToString() {
        String str = carRental.toString();
        assertNotNull(str);
        assertTrue(str.contains("Veiculos"));
        assertTrue(str.contains("Comparadores"));
    }
}