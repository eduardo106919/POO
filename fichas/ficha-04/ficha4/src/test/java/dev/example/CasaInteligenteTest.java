package dev.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CasaInteligenteTest {

    private Lampada l1 = new Lampada(Modo.ON, 5, 10, 0, 0);
    private Lampada l2 = new Lampada(Modo.OFF, 2, 8, 10, 5);
    private Lampada l3 = new Lampada(Modo.OFF, 7, 20, 70, 30);
    private Lampada l4 = new Lampada(Modo.ECO, 1, 5, 100, 0);
    private Lampada l5 = new Lampada(Modo.ECO, 3, 6, 200, 200);
    List<Lampada> lls = Arrays.asList(l1, l2, l3, l4, l5);

    private CasaInteligente c1, c2, c3;

    @BeforeEach
    void setUp() {
        c1 = new CasaInteligente();
        c2 = new CasaInteligente(lls);
        c3 = new CasaInteligente(c2);
    }

    @Test
    void addLampada() {
        int len = c2.getLampadas().size();
        Lampada l = new Lampada(Modo.ON, 5, 10, 0, 0);
        c2.addLampada(l);
        assertEquals(len + 1, c2.getLampadas().size());
    }

    @Test
    void ligaLampadaNormal() {
        int index = 2;
        c2.ligaLampadaNormal(index);
        List<Lampada> l = c2.getLampadas();
        Lampada lamp = l.get(index);
        assertEquals(Modo.ON, lamp.getModo());
        System.out.println(lamp.toString());
    }

    @Test
    void ligaLampadaEco() {
        int index = 2;
        c2.ligaLampadaEco(index);
        List<Lampada> l = c2.getLampadas();
        Lampada lamp = l.get(index);
        assertEquals(Modo.ECO, lamp.getModo());
        System.out.println(lamp.toString());
    }

    @Test
    void qtEmEco() {
        assertEquals(2, c2.qtEmEco());
    }

    @Test
    void removeLampada() {
        int len = c2.getLampadas().size();
        c2.removeLampada(3);
        assertEquals(len - 1, c2.getLampadas().size());
    }

    @Test
    void ligaTodasEco() {
        assertEquals(2, c2.qtEmEco());
        c2.ligaTodasEco();
        assertEquals(5, c2.qtEmEco());
    }

    @Test
    void ligaTodasMax() {
        assertEquals(1, c2.getLampadas().stream().filter(l -> l.getModo() == Modo.ON).count());
        c2.ligaTodasMax();
        assertEquals(5, c2.getLampadas().stream().filter(l -> l.getModo() == Modo.ON).count());
    }

    @Test
    void consumoTotal() {
        double valor = lls.stream().mapToDouble(Lampada::totalConsumo).sum();
        assertEquals(valor, c2.consumoTotal());
    }

    @Test
    void maisGastadora() {
        System.out.println(c2.maisGastadora().toString());
        System.out.println(l5.toString());
        assertTrue(l5.equals(c2.maisGastadora()));
    }

    @Test
    void lampadasEmModoEco() {
        Set<Lampada> s = c2.lampadasEmModoEco();
        assertEquals(c2.qtEmEco(), s.size());
    }

    @Test
    void reset() {
        System.out.println(c2.toString());
        c2.reset();
        assertTrue(c2.getLampadas().stream().allMatch(l -> l.getConsumoPeriodo() == 0));
        System.out.println(c2.toString());
    }

    @Test
    void podiumEconomia() {
        Set<Lampada> s = c2.podiumEconomia();
        s.forEach(l -> System.out.println(l.toString()));
    }

    @Test
    void testEquals() {
        assertTrue(c2.equals(c3));
        assertTrue(c3.equals(c2));
        assertFalse(c1.equals(c3));
        assertFalse(c2.equals(null));
    }

}