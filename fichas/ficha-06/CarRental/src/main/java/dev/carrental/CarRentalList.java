package dev.carrental;

import dev.carrental.carros.Carro;
import dev.carrental.carros.CarroEletrico;

import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Empresa que gere Carros de vários tipos, com uma Lista.
 * @author Eduardo Freitas Fernandes
 */
public class CarRentalList {

    // variáveis de instância

    /** Lista de veículos geridos pela empresa */
    private List<Carro> veiculos;


    // construtores

    /**
     * Construtor por omissão de um CarRentalList
     */
    public CarRentalList() {
        veiculos = new ArrayList<>();
    }

    /**
     * Construtor parametrizado de um CarRentalList
     * @param veiculos Lista de Carros
     */
    public CarRentalList(List<Carro> veiculos) {
        this();
        veiculos.forEach(c -> this.veiculos.add(c.clone()));
    }

    /**
     * Construtor de cópia de um CarRentalList
     * @param other CarRentalList a copiar
     */
    public CarRentalList(CarRentalList other) {
        this();
        other.veiculos.forEach(c -> this.veiculos.add(c.clone()));
    }


    // métodos de instância

    /**
     * Verifica se um Carro existe na empresa
     * @param cod matrícula do Carro
     * @return {@code true} se existir, {@code false} caso contrário
     */
    public boolean existeCarro(String cod) {
        Iterator<Carro> iterator = veiculos.iterator();
        Carro temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getMatricula().equals(cod))
                return true;
        }

        return false;
    }

    /**
     * Determina o número total de veículos geridos pela empresa
     * @return número total de veículos
     */
    public int quantos() {
        return veiculos.size();
    }

    /**
     * Determina o número de veículos de uma certa marca
     * @param marca marca de Carro
     * @return número de veículos de uma certa marca
     */
    public int quantos(String marca) {
        return (int) veiculos.stream()
                .filter(c -> c.getMarca().equals(marca))
                .count();
    }

    /**
     * Devolve uma cópia de um Carro, dada a sua matrícula
     * @param cod matrícula do Carro
     * @return cópia do Carro
     */
    public Carro getCarro(String cod) {
        Iterator<Carro> iterator = veiculos.iterator();
        Carro temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getMatricula().equals(cod))
                return temp.clone();
        }

        return null;
    }

    /**
     * Adiciona um Carro à empresa
     * @param v Carro a adicionar
     */
    public void adiciona(Carro v) {
        veiculos.add(v.clone());
    }

    /**
     * Devolve uma lista dos Carros geridos pela empresa
     * @return lista de Carros
     */
    public List<Carro> getCarros() {
        return veiculos.stream()
                .map(Carro::clone)
                .collect(Collectors.toList());
    }

    /**
     * Adiciona um conjunto de Carros à empresa
     * @param vs conjunto de Carros a adicionar
     */
    public void adiciona(Set<Carro> vs) {
        vs.forEach(c -> veiculos.add(c.clone()));
    }

    /**
     * Regista uma viagem num Carro, dada a sua matrícula
     * @param codCarro matrícula do Carro
     * @param numKms distância percorrida
     */
    public void registarViagem(String codCarro, int numKms) {
        Iterator<Carro> iterator = veiculos.iterator();
        Carro temp = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            temp = iterator.next();
            if (temp.getMatricula().equals(codCarro)) {
                found = true;
                temp.viagem(numKms);
            }
        }
    }

    /**
     * Abastece o combustível de um Carro, dada a sua matrícula
     * @param codCarro matrícula do Carro
     */
    public void atestarCarro(String codCarro) {
        Iterator<Carro> iterator = veiculos.iterator();
        Carro temp = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            temp = iterator.next();
            if (temp.getMatricula().equals(codCarro)) {
                found = true;
                temp.abastecer();
            }
        }
    }

    /**
     * Devolve o Carro com o menor custo por km
     * @return Carro com o menor custo por km
     */
    public Carro obterCarroMaisEconomico() {
        Optional<Carro> temp = veiculos.stream().sorted().findFirst();
        return temp.isPresent() ? temp.get().clone() : null;
    }

    /**
     * Calcula a média de custo por quilómetro de todos os carros da empresa
     * @return média de custo por quilómetro
     */
    public double obterMediaCustoPorKm() {
        return veiculos.stream()
                .mapToDouble(Carro::custoKm)
                .average()
                .orElse(0);
    }

    /**
     * Calcula o custo real por km de um Carro
     * @param cod matrícula do Carro
     * @return custo real por km de um Carro
     */
    public int custoRealKm(String cod) {
        Iterator<Carro> iterator = veiculos.iterator();
        Carro temp = null;
        boolean found = false;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.getMatricula().equals(cod)) {
                return (int) temp.custoRealKm();
            }
        }

        return -1;
    }

    /**
     * Determina o conjunto dos carros que podem ser requisitados para
     * efectuar uma viagem de um determinado número de kms
     * @param kms número de kms a percorrer
     * @return conjunto de Carros
     */
    public Set<Carro> carrosComAlcance(int kms) {
        return veiculos.stream()
                .filter(c -> c.getAutonomia() > kms)
                .map(Carro::clone)
                .collect(Collectors.toSet());
    }

    /**
     * Determina o conjunto dos carros eléctricos cujo nível de bateria é de pelo menos uma percentagem
     * @param nivelMinimo percentagem mínima de bateria
     * @return conjunto de carros elétricos
     */
    public Set<CarroEletrico> comBateriaDe(int nivelMinimo) {
        return veiculos.stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (CarroEletrico) c)
                .filter(e -> e.getPercentagemBateria() >= nivelMinimo)
                .map(CarroEletrico::clone)
                .collect(Collectors.toSet());
    }

}
