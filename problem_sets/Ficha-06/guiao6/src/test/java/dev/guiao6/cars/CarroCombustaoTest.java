package dev.guiao6.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarroCombustaoTest {

    private CarroCombustao carro;

    @BeforeEach
    void setUp() {
        carro = new CarroCombustao(
                "11-22-AA", "Golf", "Volkswagen", 2019, 90.0,
                50.0, 6.0, 1.80
        );
    }

    @Test
    void testGetters() {
        assertEquals("11-22-AA", carro.get_matricula());
        assertEquals("Volkswagen", carro.get_marca());
        assertEquals("Golf", carro.get_modelo());
        assertEquals(2019, carro.get_ano());
        assertEquals(90.0, carro.get_velocidade());
        assertEquals(50.0, carro.get_deposito());
        assertEquals(50.0, carro.get_deposito_atual());
        assertEquals(6.0, carro.get_consumo());
        assertEquals(1.80, carro.get_preco_combustivel());
    }

    @Test
    void testSetters() {
        carro.set_matricula("77-BB-77");
        assertEquals("77-BB-77", carro.get_matricula());

        carro.set_marca("Peugeot");
        assertEquals("Peugeot", carro.get_marca());

        carro.set_modelo("308");
        assertEquals("308", carro.get_modelo());

        carro.set_ano(2018);
        assertEquals(2018, carro.get_ano());

        carro.set_velocidade(110.0);
        assertEquals(110.0, carro.get_velocidade());

        carro.set_autonomia(300);
        assertEquals(300, carro.get_autonomia());

        carro.set_deposito(45.0);
        assertEquals(45.0, carro.get_deposito());

        carro.set_consumo(5.5);
        assertEquals(5.5, carro.get_consumo());

        carro.set_preco_combustivel(1.60);
        assertEquals(1.60, carro.get_preco_combustivel());
    }

    @Test
    void testViagem() {
        int autonomiaAntes = carro.get_autonomia();
        carro.viagem(100);

        assertTrue(carro.get_kms_totais() >= 100);
        assertTrue(carro.get_kms_parciais() >= 100);
        assertTrue(carro.get_deposito_atual() < 50.0);
        assertTrue(carro.get_autonomia() < autonomiaAntes);
    }

    @Test
    void testAbastecerCarro() {
        carro.viagem(100);
        carro.abastecer_carro();
        assertEquals(carro.get_deposito(), carro.get_deposito_atual(), 1e-6);
    }

    @Test
    void testCustoReal() {
        double custoBase = (6.0 / 100.0) * 1.80;
        double custoEsperado = custoBase + custoBase * (Carro.get_custo_extra() / 100.0);
        assertEquals(custoEsperado, carro.custo_real(), 1e-6);
    }

    @Test
    void testEqualsAndClone() {
        CarroCombustao clone = carro.clone();
        assertEquals(carro, clone);
        assertNotSame(carro, clone);
    }

    @Test
    void testToString() {
        String str = carro.toString();
        assertTrue(str.contains("Volkswagen"));
        assertTrue(str.contains("Golf"));
        assertTrue(str.contains("Deposito"));
        assertTrue(str.contains("Preco"));
    }

    @Test
    void testAdicionaKmsAndResetParcial() {
        carro.adiciona_kms(150);
        assertEquals(150, carro.get_kms_totais());
        assertEquals(150, carro.get_kms_parciais());

        carro.reset_parcial();
        assertEquals(0, carro.get_kms_parciais());
    }

    @Test
    void testStaticCustoExtra() {
        assertEquals(15, Carro.get_custo_extra());
    }
}
