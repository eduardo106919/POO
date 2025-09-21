package dev.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Plataforma onde são guardados e geridos os pedidos de suporte.
 * @author Eduardo Freitas Fernandes
 */
public class SistemadeSuporte {

    // variáveis de instância

    /** pedidos informáticos */
    private List<PedidodeSuporte> pedidos;


    // construtores

    /**
     * Construtor por omissão de um Sistema de Suporte
     */
    public SistemadeSuporte() {
        pedidos = new ArrayList<>();
    }

    /**
     * Construtor parametrizadode de um Sistema de Suporte
     * @param pedidos pedidos informáticos
     */
    public SistemadeSuporte(List<PedidodeSuporte> pedidos) {
        this.pedidos = pedidos.stream()
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    /**
     * Construtor de cópia de um Sistema de Suporte
     * @param other SistemadeSuporte a copiar
     */
    public SistemadeSuporte(SistemadeSuporte other) {
        pedidos = other.pedidos.stream()
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }


    // métodos de instância

    /**
     * Devolve uma cópia dos pedidos informáticos
     * @return pedidos informáticos
     */
    public List<PedidodeSuporte> getPedidos() {
        return pedidos.stream()
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    /**
     * Altera os pedidos informáticos do sistema
     * @param pedidos pedidos informáticos
     */
    public void setPedidos(List<PedidodeSuporte> pedidos) {
        this.pedidos = pedidos.stream()
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    /**
     * Adiciona um pedido informático ao sistema
     * @param pedido pedido informático
     */
    public void inserePedido(PedidodeSuporte pedido) {
        pedidos.add(pedido.clone());
    }

    /**
     * Procura um pedido no sistema dado o nome do cliente e data de registo
     * @param user nome do cliente
     * @param data data de registo do pedido
     * @return pedido informático
     */
    public PedidodeSuporte procuraPedido(String user, LocalDateTime data) {
        Iterator<PedidodeSuporte> iterator = pedidos.iterator();
        PedidodeSuporte p = null;

        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.getCliente().equals(user) && p.getInstanteRegisto().equals(data))
                return p.clone();
        }

        return null;
    }

    /**
     * Resolve um pedido de suporte indicando o técnico e a informação a transmitir
     * @param pedido pedido informático a resolver
     * @param tecnico nome do técnico
     * @param info informação a transmitir
     */
    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info) {
        Iterator<PedidodeSuporte> iterator = pedidos.iterator();
        PedidodeSuporte p = null;
        boolean found = false;

        while (iterator.hasNext() && !found) {
            p = iterator.next();
            if (p.equals(pedido)) {
                p.resolverPedido(tecnico, info);
                found = true;
            }
        }
    }

    /**
     * Devolve os pedidos já resolvidos, usando iteradores externos
     * @return pedidos resolvidos
     */
    public List<PedidodeSuporte> resolvidosExt() {
        Iterator<PedidodeSuporte> iterator = pedidos.iterator();
        List<PedidodeSuporte> out = new ArrayList<>();
        PedidodeSuporte p = null;

        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.isResolvido())
                out.add(p.clone());
        }

        return out;
    }

    /**
     * Devolve os pedidos já resolvidos, usando iteradores internos
     * @return pedidos resolvidos
     */
    public List<PedidodeSuporte> resolvidosInt() {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    /**
     * Determina o nome do técnico que resolveu mais pedidos, usando iteradores externos
     * @return técnico com mais resoluções
     */
    public String colaboradorTopExt() {
        List<String> colaboradores = new ArrayList<>();
        List<Integer> contadores = new ArrayList<>();

        for (PedidodeSuporte p : pedidos) {
            String func = p.getFuncionario();
            int idx = colaboradores.indexOf(func);
            // tecnico ainda não registado
            if (idx == -1) {
                colaboradores.add(func);
                contadores.add(1);
            } else {
                contadores.set(idx, contadores.get(idx) + 1);
            }
        }

        // determinar o tecnico com mais resoluções
        String top = null;
        int max = 0;
        for (int i = 0; i < colaboradores.size(); i++) {
            if (contadores.get(i) > max) {
                max = contadores.get(i);
                top = colaboradores.get(i);
            }
        }

        return top;
    }

    /**
     * Determina o nome do técnico que resolveu mais pedidos, usando iteradores internos
     * @return técnico com mais resoluções
     */
    public String colaboradorTopInt() {
        List<String> colaboradores = new ArrayList<>();
        List<Integer> contadores = new ArrayList<>();

        pedidos.stream()
                .map(PedidodeSuporte::getFuncionario)
                .forEach(func -> {
                    int idx = colaboradores.indexOf(func);
                    if (idx == -1) {
                        colaboradores.add(func);
                        contadores.add(1);
                    } else {
                        contadores.set(idx, contadores.get(idx) + 1);
                    }
                });

        return colaboradores.stream()
                .reduce((a, b) -> {
                    int idxA = colaboradores.indexOf(a);
                    int idxB = colaboradores.indexOf(b);
                    return contadores.get(idxA) >= contadores.get(idxB) ? a : b;
                })
                .orElse(null);
    }

    /**
     * Devolve os pedidos já resolvidos, num período de tempo, usando iteradores externos
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return pedidos resolvidos
     */
    public List<PedidodeSuporte> resolvidosExt(LocalDateTime inicio, LocalDateTime fim) {
        Iterator<PedidodeSuporte> iterator = pedidos.iterator();
        List<PedidodeSuporte> out = new ArrayList<>();
        PedidodeSuporte p;

        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.isResolvido() && p.getInstanteRegisto().isAfter(inicio) && p.getInstanteConclusao().isBefore(fim))
                out.add(p.clone());
        }

        return out;
    }

    /**
     * Devolve os pedidos já resolvidos, num período de tempo, usando iteradores internos
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return pedidos resolvidos
     */
    public List<PedidodeSuporte> resolvidosInt(LocalDateTime inicio, LocalDateTime fim) {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .filter(p -> p.getInstanteRegisto().isAfter(inicio))
                .filter(p -> p.getInstanteConclusao().isBefore(fim))
                .map(PedidodeSuporte::clone)
                .collect(Collectors.toList());
    }

    /**
     * Determina o tempo médio de resolução de pedidos, usando iteradores externos
     * @return tempo médio de resolução de pedidos
     */
    public double tempoMedioResolucaoExt() {
        int contagem = 0;
        int total = 0;
        Iterator<PedidodeSuporte> iterator = pedidos.iterator();
        PedidodeSuporte p;

        while (iterator.hasNext()) {
            p = iterator.next();
            if (p.isResolvido()) {
                total += p.getTempoResolucao();
                contagem++;
            }
        }

        return total / (double) contagem;
    }

    /**
     * Determina o tempo médio de resolução de pedidos, usando iteradores internos
     * @return tempo médio de resolução de pedidos
     */
    public double tempoMedioResolucaoInt() {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .mapToInt(PedidodeSuporte::getTempoResolucao)
                .average()
                .orElse(0);
    }

    /**
     * Determina o tempo médio de resolução de pedidos, num período de tempo
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return tempo médio de resolução de pedidos
     */
    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim) {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .filter(p -> p.getInstanteRegisto().isAfter(inicio))
                .filter(p -> p.getInstanteConclusao().isBefore(fim))
                .mapToInt(PedidodeSuporte::getTempoResolucao)
                .average()
                .orElse(0);
    }

    /**
     * Determina o pedido que demorou mais tempo a ser resolvido
     * @return pedido mais demorado
     */
    public PedidodeSuporte pedidoMaisLongo() {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .max((p1, p2) -> Integer.compare(p1.getTempoResolucao(), p2.getTempoResolucao()))
                .orElse(null);
    }

    /**
     * Determina o pedido que demorou mais tempo a ser resolvido, num período de tempo
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return pedido mais demorado
     */
    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim) {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .filter(p -> p.getInstanteRegisto().isAfter(inicio))
                .filter(p -> p.getInstanteConclusao().isBefore(fim))
                .max((p1, p2) -> Integer.compare(p1.getTempoResolucao(), p2.getTempoResolucao()))
                .orElse(null);
    }

    /**
     * Determina o pedido que demorou menos tempo a ser resolvido
     * @return pedido menos demorado
     */
    public PedidodeSuporte pedidoMaisCurto() {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .min((p1, p2) -> Integer.compare(p1.getTempoResolucao(), p2.getTempoResolucao()))
                .orElse(null);
    }

    /**
     * Determina o pedido que demorou menos tempo a ser resolvido, num período de tempo
     * @param inicio inicio do periodo
     * @param fim fim do periodo
     * @return pedido menos demorado
     */
    public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim) {
        return pedidos.stream()
                .filter(PedidodeSuporte::isResolvido)
                .filter(p -> p.getInstanteRegisto().isAfter(inicio))
                .filter(p -> p.getInstanteConclusao().isBefore(fim))
                .min((p1, p2) -> Integer.compare(p1.getTempoResolucao(), p2.getTempoResolucao()))
                .orElse(null);
    }

    /**
     * Efetua uma cópia de um Sistema de Suporte
     * @return cópia de um Sistema de Suporte
     */
    @Override
    public SistemadeSuporte clone() {
        return new SistemadeSuporte(this);
    }

    /**
     * Devolve uma representação textual de um Sistema de Suporte
     * @return representação textual
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Sistema de Suporte: { ");
        pedidos.forEach(p -> builder.append(p.toString()).append(" "));
        builder.append(" }");

        return builder.toString();
    }

    /**
     * Compara um objeto a um Sistema de Suporte
     * @param obj objeto a comparar
     * @return {@code true} se forem iguais, {@code false} caso contrário
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        SistemadeSuporte other = (SistemadeSuporte) obj;
        return pedidos.equals(other.pedidos);
    }

}
