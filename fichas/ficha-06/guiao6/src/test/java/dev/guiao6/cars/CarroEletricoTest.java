package dev.guiao6.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarroEletricoTest {

    private CarroEletrico carro;

    @BeforeEach
    void setUp() {
        carro = new CarroEletrico(
                "12-34-AB", "Model 3", "Tesla", 2021, 100.0,
                75.0, 15.0, 0.30
        );
    }

    @Test
    void testGetters() {
        assertEquals("12-34-AB", carro.get_matricula());
        assertEquals("Tesla", carro.get_marca());
        assertEquals("Model 3", carro.get_modelo());
        assertEquals(2021, carro.get_ano());
        assertEquals(100.0, carro.get_velocidade());
        assertEquals(75.0, carro.get_bateria());
        assertEquals(75.0, carro.get_bateria_atual());
        assertEquals(15.0, carro.get_consumo());
        assertEquals(0.30, carro.get_preco_energia());
    }

    @Test
    void testSetters() {
        carro.set_matricula("99-ZZ-99");
        assertEquals("99-ZZ-99", carro.get_matricula());

        carro.set_marca("Renault");
        assertEquals("Renault", carro.get_marca());

        carro.set_modelo("ZOE");
        assertEquals("ZOE", carro.get_modelo());

        carro.set_ano(2020);
        assertEquals(2020, carro.get_ano());

        carro.set_velocidade(80.0);
        assertEquals(80.0, carro.get_velocidade());

        carro.set_autonomia(150);
        assertEquals(150, carro.get_autonomia());

        carro.set_deposito(50.0);
        assertEquals(50.0, carro.get_bateria());

        carro.set_consumo(10.0);
        assertEquals(10.0, carro.get_consumo());

        carro.set_preco_energia(0.25);
        assertEquals(0.25, carro.get_preco_energia());
    }

    @Test
    void testViagem() {
        int autonomiaInicial = carro.get_autonomia();
        carro.viagem(50);
        assertTrue(carro.get_kms_totais() >= 50);
        assertTrue(carro.get_kms_parciais() >= 50);
        assertTrue(carro.get_autonomia() < autonomiaInicial);
        assertTrue(carro.get_bateria_atual() < 75.0);
    }

    @Test
    void testAbastecerCarro() {
        carro.viagem(50);
        carro.abastecer_carro();
        assertEquals(carro.get_bateria(), carro.get_bateria_atual(), 1e-6);
    }

    @Test
    void testCustoReal() {
        double esperado = (15.0 / 100) * 0.30; // custo base por km
        esperado += esperado * (Carro.get_custo_extra() / 100.0); // com custo extra
        assertEquals(esperado, carro.custo_real(), 1e-6);
    }

    @Test
    void testEqualsAndClone() {
        CarroEletrico clone = carro.clone();
        assertEquals(carro, clone);
        assertNotSame(carro, clone);
    }

    @Test
    void testCompareTo() {
        CarroEletrico outro = new CarroEletrico(
                "00-AA-00", "Model X", "Tesla", 2020, 90.0,
                90.0, 18.0, 0.35
        );

        outro.viagem(300);
        carro.viagem(100);

        assertTrue(outro.compareTo(carro) != 0);
    }

    @Test
    void testToString() {
        String output = carro.toString();
        assertTrue(output.contains("Matricula"));
        assertTrue(output.contains("Tesla"));
        assertTrue(output.contains("75.0"));
    }

    @Test
    void testResetParcial() {
        carro.viagem(200);
        carro.reset_parcial();
        assertEquals(0, carro.get_kms_parciais());
    }

    @Test
    void testAdicionaKms() {
        carro.adiciona_kms(100);
        assertEquals(100, carro.get_kms_totais());
        assertEquals(100, carro.get_kms_parciais());
    }

    @Test
    void testStaticCustoExtra() {
        assertEquals(15, Carro.get_custo_extra());
    }
}
