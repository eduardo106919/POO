package dev.carrental;

import dev.carrental.carros.Carro;
import dev.carrental.carros.CarroEletrico;
import dev.carrental.carros.CarroHibrido;
import dev.carrental.comparators.KmsTotaisComparator;
import dev.carrental.comparators.CustoKmComparator;
import dev.carrental.exceptions.CarroInexistenteException;
import dev.carrental.exceptions.CarroRepetidoException;
import dev.carrental.exceptions.ComparadorInexistenteException;
import dev.carrental.exceptions.ViagemInvalidaException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Empresa que gere Carros de vários tipos.
 * @author Eduardo Freitas Fernandes
 */
public class CarRental implements Serializable {

    @Serial
    private static final long serialVersionUID = -5722626914931357170L;

    // variáveis de classe

    /** Comparators guardados pela empresa, associados ao seu nome */
    private static Map<String, Comparator<Carro>> comparadores = new HashMap<>();

    // variáveis de instância

    /** Carros guardados pela empresa, associados à sua matrícula */
    private Map<String, Carro> veiculos;


    // construtores

    /**
     * Construtor por omissão de um CarRental
     */
    public CarRental() {
        veiculos = new HashMap<>();
    }

    /**
     * Construtor parametrizado de um CarRental
     * @param veiculos conjunto de veículos
     */
    public CarRental(Set<Carro> veiculos) {
        this();
        veiculos.forEach(c -> this.veiculos.put(c.getMatricula(), c.clone()));
    }

    /**
     * Construtor de cópia de um CarRental
     * @param other CarRental a copiar
     */
    public CarRental(CarRental other) {
        this();
        other.veiculos.forEach((key, value) -> veiculos.put(key, value.clone()));
    }


    // métodos de classe

    /**
     * Adiciona um comparador à empresa
     * @param comp Comparador a adicionar
     */
    public static void addComparator(Comparator<Carro> comp) {
        CarRental.comparadores.put(comp.getClass().getSimpleName(), comp);
    }

    /**
     * Devolve uma coleção de comparadores de Carros
     * @return coleção de comparadores de Carros
     */
    public static Collection<Comparator<Carro>> getComparadores() {
        return comparadores.values();
    }

    /**
     * Altera os comparadores de Carros guardados pela empresa
     * @param comparadores comparadores de Carros
     */
    public static void setComparadores(Map<String, Comparator<Carro>> comparadores) {
        CarRental.comparadores.clear();
        CarRental.comparadores.putAll(comparadores);
    }

    // métodos de instância

    /**
     * Altera os veículos guardados pela empresa
     * @param veiculos novo conjunto de veículos
     */
    public void setVeiculos(Set<Carro> veiculos) {
        this.veiculos.clear();
        veiculos.forEach(c -> this.veiculos.put(c.getMatricula(), c.clone()));
    }

    /**
     * Verifica se um Carro existe na empresa
     * @param cod matrícula do Carro
     * @return {@code true} se existir, {@code false} caso contrário
     */
    public boolean existeCarro(String cod) {
        return veiculos.containsKey(cod);
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
        return (int) veiculos.values().stream()
                .filter(c -> c.getMarca().equals(marca))
                .count();
    }

    /**
     * Devolve uma cópia de um Carro, dada a sua matrícula
     * @param cod matrícula do Carro
     * @return cópia do Carro
     */
    public Carro getCarro(String cod) throws CarroInexistenteException {
        Carro temp = veiculos.get(cod);
        if (temp == null)
            throw new CarroInexistenteException(cod);
        return temp.clone();
    }

    /**
     * Adiciona um Carro à empresa
     * @param v Carro a adicionar
     */
    public void adiciona(Carro v) throws CarroRepetidoException {
        if (veiculos.containsKey(v.getMatricula()))
            throw new CarroRepetidoException(v.getMatricula());
        veiculos.put(v.getMatricula(), v.clone());
    }

    /**
     * Devolve uma lista dos Carros geridos pela empresa
     * @return lista de Carros
     */
    public List<Carro> getCarros() {
        return veiculos.values().stream()
                .map(Carro::clone)
                .collect(Collectors.toList());
    }

    /**
     * Adiciona um conjunto de Carros à empresa
     * @param vs conjunto de Carros a adicionar
     */
    public void adiciona(Set<Carro> vs) throws CarroRepetidoException {
        Iterator<Carro> iterator = vs.iterator();
        Carro temp;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (veiculos.containsKey(temp.getMatricula()))
                throw new CarroRepetidoException(temp.getMatricula());
            veiculos.put(temp.getMatricula(), temp.clone());
        }
    }

    /**
     * Regista uma viagem num Carro, dada a sua matrícula
     * @param codCarro matrícula do Carro
     * @param numKms distância percorrida
     */
    public void registarViagem(String codCarro, int numKms) throws ViagemInvalidaException {
        Carro temp = veiculos.get(codCarro);
        if (temp == null)
            throw new ViagemInvalidaException(codCarro);
        temp.viagem(numKms);
    }

    /**
     * Abastece o combustível de um Carro, dada a sua matrícula
     * @param codCarro matrícula do Carro
     */
    public void atestarCarro(String codCarro) throws CarroInexistenteException {
        Carro temp = veiculos.get(codCarro);
        if (temp == null)
            throw new CarroInexistenteException(codCarro);
        temp.abastecer();
    }

    /**
     * Devolve o Carro com o menor custo por km
     * @return Carro com o menor custo por km
     */
    public Carro obterCarroMaisEconomico() {
        Optional<Carro> temp = veiculos.values().stream().min(new CustoKmComparator());
        return temp.isPresent() ? temp.get().clone() : null;
    }

    /**
     * Calcula a média de custo por quilómetro de todos os carros da empresa
     * @return média de custo por quilómetro
     */
    public double obterMediaCustoPorKm() {
        return veiculos.values().stream().mapToDouble(Carro::custoKm).average().orElse(0);
    }

    /**
     * Calcula o custo real por km de um Carro
     * @param cod matrícula do Carro
     * @return custo real por km de um Carro
     */
    public double custoRealKm(String cod) throws CarroInexistenteException {
        Carro temp = veiculos.get(cod);
        if (temp == null)
            throw new CarroInexistenteException(cod);
        return temp.custoRealKm();
    }

    /**
     * Determina o conjunto dos carros que podem ser requisitados para
     * efectuar uma viagem de um determinado número de kms
     * @param kms número de kms a percorrer
     * @return conjunto de Carros
     */
    public Set<Carro> carrosComAlcance(int kms) {
        return veiculos.values().stream()
                    .filter(c -> c.getAutonomia() >= kms)
                    .map(Carro::clone)
                    .collect(Collectors.toSet());
    }

    /**
     * Determina o conjunto dos carros eléctricos cujo nível de bateria é de pelo menos uma percentagem
     * @param nivelMinimo percentagem mínima de bateria
     * @return conjunto de carros elétricos
     */
    public Set<CarroEletrico> comBateriaDe(int nivelMinimo) {
        return veiculos.values().stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (CarroEletrico) c)
                .filter(e -> e.getPercentagemBateria() >= nivelMinimo)
                .map(CarroEletrico::clone)
                .collect(Collectors.toSet());
    }

    /**
     * Determina o Carro com mais kilómetros feitos
     * @return Carro com mais kilómetros
     */
    public Carro carroComMaisKms() {
        Optional<Carro> temp = veiculos.values().stream().max(new KmsTotaisComparator());
        return temp.isPresent() ? temp.get().clone() : null;
    }

    /**
     * Devolve um conjunto com todos os Carros Elétricos ordenados pela sua ordem natual
     * @return conjunto com todos os Carros Elétricos ordenados
     */
    public Set<CarroEletrico> getEletricosOrdenados() {
        return veiculos.values().stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (CarroEletrico) c)
                .map(CarroEletrico::clone)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * Devolve um iterador de Carros, ordenado pelo critério indicado
     * @param criterio nome do Comparador para ordenação
     * @return Iterador de Carros, ordenado por critério
     */
    public Iterator<Carro> ordenarCarros(String criterio) throws ComparadorInexistenteException {
        Comparator<Carro> comp = CarRental.comparadores.get(criterio);
        if (comp == null)
            throw new ComparadorInexistenteException(criterio);
        return veiculos.values().stream()
                .map(Carro::clone)
                .sorted(comp)
                .iterator();
    }

    /**
     * Devolve um mapa que associa uma autonomia a uma lista de Carros
     * @return mapa que associa uma autonomia a uma lista de Carros
     */
    public Map<Integer, List<Carro>> carrosPorAutonomia() {
        return veiculos.values().stream()
                .map(Carro::clone)
                .collect(Collectors.groupingBy(Carro::getAutonomia));
    }

    /**
     * Devolve uma lista de informação dos Carros da empresa
     * @return lista de informação dos Carros
     */
    public List<InfoKms> getInfoCarros() {
        return veiculos.values().stream()
                .map(c -> (InfoKms) c)
                .collect(Collectors.toList());
    }

    /**
     * Devolve os Carros Elétricos mas que só deixe consultar os seus pontos
     * @return lista de carros elétricos, com acesso aos seus pontos
     */
    public List<PontosPorKms> verPontos() {
        return veiculos.values().stream()
                .filter(c -> c instanceof CarroEletrico)
                .map(c -> (PontosPorKms) c)
                .collect(Collectors.toList());
    }

    /**
     * Devolve os carros hibridos existentes
     * @return carros hibridos existentes
     */
    public List<CarroHibrido> getHibridos() {
        return veiculos.values().stream()
                .filter(c -> c instanceof CarroHibrido)
                .map(c -> (CarroHibrido) c)
                .map(CarroHibrido::clone)
                .collect(Collectors.toList());
    }

    /**
     * Guarda uma instância de CarRental num ficheiro de objetos
     * @param ficheiro nome do ficheiro
     * @throws FileNotFoundException erro com o ficheiro
     * @throws IOException erro de I/O
     */
    public void guardaCarRental(String ficheiro) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Carrega uma instância de CarRental de um ficheiro de objetos
     * @param ficheiro nome do ficheiro
     * @return instância de CarRental
     * @throws FileNotFoundException erro com o ficheiro
     * @throws IOException erro de I/O
     * @throws ClassNotFoundException classe não encontrada
     */
    public static CarRental carregaCarRental(String ficheiro) throws FileNotFoundException,
                                                                     IOException,
                                                                     ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ficheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        CarRental obj = (CarRental) ois.readObject();
        ois.close();
        return obj;
    }

    /**
     * Devolve uma cópia de um CarRental
     * @return cópia de um CarRental
     */
    @Override
    public CarRental clone() {
        return new CarRental(this);
    }

    /**
     * Devolve uma representação textual de um Carro
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("--- CarRental ---\n");
        builder.append("veiculos:\n");
        veiculos.values().forEach(c -> builder.append(c.toString()));

        return builder.toString();
    }

    /**
     * Compara um objeto a um CarRental
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        CarRental other = (CarRental) obj;
        return veiculos.equals(other.veiculos);
    }

}
