package dev.carrental;

import dev.carrental.carros.Carro;
import dev.carrental.carros.CarroCombustao;
import dev.carrental.carros.CarroEletrico;
import dev.carrental.comparators.*;
import dev.carrental.exceptions.CarroInexistenteException;
import dev.carrental.exceptions.CarroRepetidoException;
import dev.carrental.exceptions.ComparadorInexistenteException;
import dev.carrental.exceptions.ViagemInvalidaException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe que permite executar o programa CarRental.
 * @author Eduardo Freitas Fernandes
 */
public class CarRentalApp {

    // variáveis de instância

    /** Scanner para leitura de dados */
    private Scanner input;
    /** Modelo lógico do programa */
    private CarRental model;


    // construtores

    /**
     * Construtor de CarRentalApp
     * @param input fonte de input
     */
    public CarRentalApp(InputStream input) {
        this.input = new Scanner(input);
        this.model = new CarRental();
    }


    // métodos de instância

    /**
     * Executa o programa
     */
    public void run() {
        Menu menu = new Menu("Menu Principal", input, new String[]{
                "Gestão de Veículos",
                "Gestão de Comparadores de Carros",
                "Criar Carro",
                "Carregar Estado",
                "Guardar Estado"
        });

        menu.setHandler(1, this::gestaoVeiculos);
        menu.setHandler(2, this::gestaoComparadores);
        menu.setHandler(3, this::criarCarro);
        menu.setHandler(4, this::carregarEstadoCarRental);
        menu.setHandler(5, this::guardarEstadoCarRental);

        menu.run();
    }

    /**
     * Controla a gestão de veículos na empresa
     */
    private void gestaoVeiculos() {
        Menu menu = new Menu("Gestão de Veículos", input, new String[]{
                "Existe Carro?",
                "Quantos Carros existem?",
                "Quantos Carros existem, de uma marca?",
                "Mostrar informação de um Carro",
                "Mostrar todos os Carros",
                "Adicionar um conjunto de Carros",
                "Efetuar viagem",
                "Atestar Carro",
                "Obter Carro mais económico",
                "Obter média de custo por km",
                "Obter custo real de um Carro",
                "Obter conjunto de Carros que podem fazer uma viagem",
                "Obter Carros Elétricos com percentagem de bateria",
                "Obter Carro com mais kilómetros",
                "Obter Carros Elétricos ordenados",
                "Apresentar Carros, ordenados por um critério",
                "Apresentar Carros por autonomia",
                "Obter informação sobre a kilometragem dos Carros",
                "Ver os pontos de todos os Carros Elétricos",
                "Apresentar os Carros Hibridos"
        });

        menu.setPreCondition(1, () -> model.quantos() > 0);
        menu.setHandler(1, this::existeCarro);

        menu.setHandler(2, () -> System.out.println("Existem " + model.quantos() + " veículos registados."));

        menu.setPreCondition(3, () -> model.quantos() > 0);
        menu.setHandler(3, this::quantosMarca);

        menu.setPreCondition(4, () -> model.quantos() > 0);
        menu.setHandler(4, this::mostrarCarro);

        menu.setPreCondition(5, () -> model.quantos() > 0);
        menu.setHandler(5, () -> model.getCarros().forEach(c -> System.out.println(c.getMatricula())));

        menu.setHandler(6, this::adicionarConjuntoCarros);

        menu.setPreCondition(7, () -> model.quantos() > 0);
        menu.setHandler(7, this::efetuarViagem);

        menu.setPreCondition(8, () -> model.quantos() > 0);
        menu.setHandler(8, this::atestarCarro);

        menu.setPreCondition(9, () -> model.quantos() > 0);
        menu.setHandler(9, () -> System.out.println("Carro mais económico:\n" + model.obterCarroMaisEconomico().toString()));

        menu.setPreCondition(10, () -> model.quantos() > 0);
        menu.setHandler(10, () -> System.out.println("Média de custo por km: " + model.obterMediaCustoPorKm()));

        menu.setPreCondition(11, () -> model.quantos() > 0);
        menu.setHandler(11, this::custoRealCarro);

        menu.setPreCondition(12, () -> model.quantos() > 0);
        menu.setHandler(12, this::carrosParaViagem);

        menu.setPreCondition(13, () -> model.quantos() > 0);
        menu.setHandler(13, this::carrosEletricosPercentagem);

        menu.setPreCondition(14, () -> model.quantos() > 0);
        menu.setHandler(14, () -> System.out.println("Carro com mais Kms:\n" + model.carroComMaisKms().toString()));

        menu.setPreCondition(15, () -> model.quantos() > 0);
        menu.setHandler(15, () -> model.getEletricosOrdenados().forEach(e -> System.out.println(e.toString())));

        menu.setPreCondition(16, () -> model.quantos() > 0);
        menu.setHandler(16, this::carrosOrdenadosCriterio);

        menu.setPreCondition(17, () -> model.quantos() > 0);
        menu.setHandler(17, () -> model.carrosPorAutonomia()
                .forEach((k, l) -> {
                    System.out.println("Autonomia: " + k);
                    l.forEach(c -> System.out.println(c.toString()));
                }));

        menu.setPreCondition(18, () -> model.quantos() > 0);
        menu.setHandler(18, () -> model.getInfoCarros()
                .forEach(i ->
                        System.out.println("{Kms Totais: " + i.getKmsTotais() + ", Custo por km: " + i.custoKm() + "}"))
        );

        menu.setPreCondition(19, () -> model.quantos() > 0);
        menu.setHandler(19, () -> model.verPontos().forEach(p -> System.out.println("Pontos: " + p.getPontos())));

        menu.setPreCondition(20, () -> model.quantos() > 0);
        menu.setHandler(20, () -> model.getHibridos().forEach(h -> System.out.println(h.toString())));

        menu.run();
    }

    /**
     * Verifica se um Carro existe, pedindo a matrícula.
     */
    private void existeCarro() {
        String matricula = lerString("Matrícula: ");
        if (model.existeCarro(matricula))
            System.out.println("O veículo " + matricula + " está registado.");
        else
            System.out.println("O veículo " + matricula + " não está registado.");
    }

    /**
     * Determina o número de Carros de uma marca.
     */
    private void quantosMarca() {
        String marca = lerString("Marca: ");
        System.out.println("Existem " + model.quantos(marca) + " veículos da marca " + marca + ".");
    }

    /**
     * Mostra a informação relativa a um Carro
     */
    private void mostrarCarro() {
        String matricula = lerString("Matrícula: ");
        try {
            Carro temp = model.getCarro(matricula);
            System.out.println(temp.toString());
        } catch (CarroInexistenteException e) {
            System.out.println("O Carro " + matricula + " é inexistente.");
        }
    }

    /**
     * Adiciona um conjunto de Carros à empresa
     */
    private void adicionarConjuntoCarros() {
        int total = lerValorPositivo("Total de Carros a adicionar: ");

        for (int i = 0; i < total; i++) {
            this.criarCarro();
        }
    }

    /**
     * Efetua uma viagem, num Carro selecionado
     */
    private void efetuarViagem() {
        String matricula = lerString("Matrícula: ");
        int distancia = lerValorPositivo("Distância viagem: ");

        try {
            model.registarViagem(matricula, distancia);
        } catch (ViagemInvalidaException e) {
            System.out.println("O Carro " + matricula + " é inexistente.");
        }
    }

    /**
     * Atesta um Carro selecionado
     */
    private void atestarCarro() {
        String matricula = lerString("Matrícula: ");
        try {
            model.atestarCarro(matricula);
        } catch (CarroInexistenteException e) {
            System.out.println("O Carro " + matricula + " é inexistente.");
        }
    }

    /**
     * Determina o custo real de um Carro selecionado
     */
    private void custoRealCarro() {
        String matricula = lerString("Matrícula: ");
        try {
            double custo = model.custoRealKm(matricula);
            System.out.println("Custo real por km de " + matricula + ":" + custo);
        } catch (CarroInexistenteException e) {
            System.out.println("O Carro " + matricula + " é inexistente.");
        }
    }

    /**
     * Determina os Carros que podem fazer uma viagem de uma certa distância
     */
    private void carrosParaViagem() {
        int distancia = lerValorPositivo("Distância a percorrer: ");

        System.out.println("Carros com alcance:");
        Set<Carro> veiculos = model.carrosComAlcance(distancia);
        veiculos.forEach(c -> System.out.println(c.getMatricula()));
    }

    /**
     * Determina os Carros Elétricos com uma certa percentagem de bateria
     */
    private void carrosEletricosPercentagem() {
        int percentagem = lerValorPositivo("Percentagem de bateria: ");

        System.out.println("Elétricos com bateria suficiente:");
        Set<CarroEletrico> veiculos = model.comBateriaDe(percentagem);
        veiculos.forEach(c -> System.out.println(c.getMatricula()));
    }

    /**
     * Apresenta os Carros, ordenados por um critério
     */
    private void carrosOrdenadosCriterio() {
        String criterio = lerString("Critério de ordenação: ");
        try {
            Iterator<Carro> iterator = model.ordenarCarros(criterio);
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } catch (ComparadorInexistenteException e) {
            System.out.println("O Comparador " + e.getMessage() + " é inexistente!");
        }
    }

    private void gestaoComparadores() {
        Menu menu = new Menu("Gestão de Comparadores", input, new String[] {
                "Apresentar comparadores",
                "Adicionar comparadores"
        });

        menu.setHandler(1, () -> CarRental.getComparadores().forEach(c -> System.out.println(c.getClass().getSimpleName())));
        menu.setHandler(2, this::adicionarComparador);

        menu.run();
    }

    private void adicionarComparador() {
        String[] comparadores = {
                "Kms Totais",
                "Custo por km",
                "Autonomia",
                "Consumo por km",
                "Velocidade Média"
        };

        System.out.println("Comparadores Existentes:");
        for (int i = 0; i < comparadores.length; i++) {
            System.out.print(i + 1);
            System.out.print(" - ");
            System.out.println(comparadores[i]);
        }
        System.out.println("Para adicionar todos, selecione 0.");

        int opcao = lerValorPositivo("Opção: ");
        switch (opcao) {
            case 0:
                CarRental.addComparator(new KmsTotaisComparator());
                CarRental.addComparator(new CustoKmComparator());
                CarRental.addComparator(new AutonomiaComparator());
                CarRental.addComparator(new ConsumoKmComparator());
                CarRental.addComparator(new VelocidadeMediaComparator());
                break;
            case 1:
                CarRental.addComparator(new KmsTotaisComparator());
                break;
            case 2:
                CarRental.addComparator(new CustoKmComparator());
                break;
            case 3:
                CarRental.addComparator(new AutonomiaComparator());
                break;
            case 4:
                CarRental.addComparator(new ConsumoKmComparator());
                break;
            case 5:
                CarRental.addComparator(new VelocidadeMediaComparator());
                break;
            default:
                System.out.println("Opção inválida!!!");
                return;
        }

        System.out.println("Comparadores adicionados.");
    }

    /**
     * Permite ao utilizador criar um Carro e adicioná-lo à empresa
     */
    private void criarCarro() {
        System.out.println("O veículo criado será adicionado à empresa automaticamente.");
        String matricula;
        do {
            matricula = lerString("Matrícula: ");
        } while (model.existeCarro(matricula));

        String marca = lerString("Marca: ");
        String modelo = lerString("Modelo: ");
        int anoConstrucao = lerValorPositivo("Ano de Construção: ");
        double velocidadeMedia = lerDouble("Velocidade Média: ");

        String[] tipos = {"Carro a Combustão", "Carro Elétrico", "Carro Híbrido"};
        int tipoCarro;

        do {
            System.out.println("Escolha um tipo de Carro:");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + 1);
                System.out.print(" - ");
                System.out.println(tipos[i]);
            }

            tipoCarro = lerValorPositivo("Tipo de Carro: ");
            if (tipoCarro < 1 || tipoCarro > 3) {
                System.out.println("Valor inválido, tente novamente!");
                tipoCarro = 0;
            }
        } while (tipoCarro == 0);

        double tanque, consumo, preco;
        Carro veiculo;

        switch (tipoCarro) {
            case 1:
                tanque = lerDouble("Tamanho do depósito: ");
                consumo = lerDouble("Consumo em litros aos 100 km: ");
                preco = lerDouble("Preço por litro do combustível: ");
                veiculo = new CarroCombustao(matricula, marca, modelo, anoConstrucao, velocidadeMedia, tanque, consumo, preco);
                break;
            case 2:
                tanque = lerDouble("Tamanho do bateria: ");
                consumo = lerDouble("Consumo em KWh aos 100 km: ");
                preco = lerDouble("Preço do KW: ");
                veiculo = new CarroEletrico(matricula, marca, modelo, anoConstrucao, velocidadeMedia, tanque, consumo, preco);
                break;
            case 3:
                System.out.println("Tipo de Carro ainda não implementado!!");
                return;
                // break;
            default:
                return;
        }

        try {
            model.adiciona(veiculo);
            System.out.println("Veículo adicionado!");
        } catch (CarroRepetidoException e) {
            System.out.println("O veículo " + e.getMessage() + " já existe!");
        }
    }

    /**
     * Carrega um estato de CarRental a partir de um ficheiro de objetos
     */
    private void carregarEstadoCarRental() {
        String ficheiro = lerString("Ficheiro de objetos: ");
        try {
            model = CarRental.carregaCarRental(ficheiro);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Guarda um estado de CarRental num ficheiro de objetos
     */
    private void guardarEstadoCarRental() {
        String ficheiro = lerString("Ficheiro de objetos: ");
        try {
            model.guardaCarRental(ficheiro);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Lê uma string.
     * @param text texto a apresentar
     * @return String lida
     */
    private String lerString(String text) {
        System.out.print(text);
        return input.next();
    }

    /**
     * Lê um valor inteiro não negativo
     * @param text texto a apresentar
     * @return Valor lido
     */
    private int lerValorPositivo(String text) {
        int value;
        do {
            System.out.print(text);
            try {
                String line = input.next();
                value = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                value = -1;
                System.out.println("Valor inválido, tente novamente!");
            }
        } while (value < 0);

        return value;
    }

    /**
     * Lê um Double positivo
     * @param text texto a apresentar
     * @return Double lido
     */
    private double lerDouble(String text) {
        double value;
        do {
            System.out.print(text);
            try {
                String line = input.next();
                value = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                value = -1;
                System.out.println("Valor inválido, tente novamente!");
            }
        } while (value < 0);

        return value;
    }

}
