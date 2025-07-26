package dev.guiao6.comparators;

import dev.guiao6.cars.Carro;
import dev.guiao6.cars.CarroCombustao;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorCarroAutonomiaTest {
    @Test
    void testCompare() {
        Comparator<Carro> comparator = new ComparatorCarroAutonomia();

        // Create test cars with different autonomy
        Carro car1 = new CarroCombustao("AAA-001", "Model1", "Brand1", 2020, 100.0, 50.0, 6.0, 1.5);
        Carro car2 = new CarroCombustao("BBB-002", "Model2", "Brand2", 2021, 110.0, 55.0, 5.5, 1.6);

        // car2 has more autonomy (should come after)
        assertTrue(comparator.compare(car1, car2) < 0);
        assertTrue(comparator.compare(car2, car1) > 0);

        // Test tie-breaker (same autonomy, compare by license plate)
        Carro car3 = new CarroCombustao("AAA-001", "Model1", "Brand1", 2020, 100.0, 50.0, 6.0, 1.5);
        Carro car4 = new CarroCombustao("BBB-002", "Model2", "Brand2", 2021, 110.0, 50.0, 6.0, 1.5);
        assertEquals(-1, comparator.compare(car3, car4)); // AAA comes before BBB
    }

}