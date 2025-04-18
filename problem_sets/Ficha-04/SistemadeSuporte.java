
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

public class SistemadeSuporte {

    /**
     * Variáveis de Instância
     */

    private ArrayList<PedidodeSuporte> pedidos;

    
    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Sistema de Suporte
     */
    public SistemadeSuporte() {
        this.pedidos = new ArrayList<PedidodeSuporte>();
    }

    /**
     * Construtor parametrizado de um Sistemde de Suporte
     *
     * @param pedidos coleção de pedidos de suporte
     */
    public SistemadeSuporte(Collection<PedidodeSuporte> pedidos) {
        this.pedidos = pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Construtor de cópia de um Sistema de Suporte
     *
     * @param outro SistemadeSuporte a copiar
     */
    public SistemadeSuporte(SistemadeSuporte outro) {
        this.pedidos = outro.pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve a lista de Pedidos de Suporte guardados
     *
     * @return lista de pedidos
     */
    public List<PedidodeSuporte> get_pedidos() {
        return this.pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toList());
    }

    // setters
    
    /**
     * Altera os pedidos de suporte guardados
     *
     * @param pedidos colecao de pedidos
     */
    public void set_pedidos(Collection<PedidodeSuporte> pedidos) {
        this.pedidos = pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toCollection(ArrayList::new));
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um Sistema de Suporte
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        SistemadeSuporte temp = (SistemadeSuporte) outro;
        return this.pedidos.equals(temp.pedidos);
    }
 
    /**
     * Devolve uma representacao textual de um Sistema de Suporte
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        this.pedidos.forEach(p -> sb.append(p.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de um Sistema de Suporte
     *
     * @return cópia de um Sistema de Suporte
     */
    public SistemadeSuporte clone() {
        return new SistemadeSuporte(this);
    }

    // outros métodos

    /**
     * Insere um novo pedido de suporte no sistema
     *
     * @param pedido pedido de suporte a inserir
     */
    public void inserePedido(PedidodeSuporte pedido) {
        this.pedidos.addLast(pedido.clone());
    }

    /**
     * Procura um pedido de suporte dada a identificação de quem o criou e a instante em que foi criado
     *
     * @param user nome do cliente
     * @param data data do pedido
     */
    public PedidodeSuporte procuraPedido(String user, LocalDateTime data) {
        Iterator<PedidodeSuporte> iterator = this.pedidos.iterator();
        PedidodeSuporte temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_cliente().equals(user) && temp.get_data().equals(data)) {
                return temp.clone();
            }
        }

        return null;
    }

    /**
     * Resolve um pedido de suporte indicando o técnico e a informação relacionada com o pedido
     *
     * @param pedido pedido a resolver
     * @param tecnico nome do tecnico
     * @param info informacao a transmitir ao cliente
     */
    public void resolvePedido(PedidodeSuporte pedido, String tecnico, String info) {
        int index = this.pedidos.indexOf(pedido);
        if (index >= 0) {
            this.pedidos.get(index).resolver(tecnico, info);
        }
    }

    /**
     * Devolve todos os pedidos já resolvidos
     * Versão de Iteradores Internos
     *
     * @return lista de pedidos de suporte
     */
    public List<PedidodeSuporte> resolvidos_I() {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .map(PedidodeSuporte::clone)
                           .collect(Collectors.toList());
    }

    /**
     * Devolve todos os pedidos já resolvidos
     * Versão de Iteradores Externos
     *
     * @return lista de pedidos de suporte
     */
    public List<PedidodeSuporte> resolvidos_E() {
        List<PedidodeSuporte> res = new ArrayList<PedidodeSuporte>();
        Iterator<PedidodeSuporte> iterator = this.pedidos.iterator();
        PedidodeSuporte temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_resolvido()) {
                res.add(temp.clone());
            }
        }

        return res;
    }

    /**
     * Devolve o colaborador que resolveu mais pedidos de suporte
     * Versão de Iteradores Internos
     *
     * @return nome do funcionario
     */
    // TODO
    public String colaboradorTop_I() {
        return "";
    }

    /**
     * Devolve o colaborador que resolveu mais pedidos de suporte
     * Versão de Iteradores Externos
     *
     * @return nome do funcionario
     */
    // TODO
    public String colaboradorTop_E() {
        return "";
    }

    /**
     * Devolve os pedidos resolvidos num determinado período de tempo
     * Versão Iteradores Externos
     *
     * @param inicio limite inferior temporal
     * @param fim limite superior temporal
     */
    public List<PedidodeSuporte> resolvidos_E(LocalDateTime inicio, LocalDateTime fim) {
        List<PedidodeSuporte> res = new ArrayList<PedidodeSuporte>();
        Iterator<PedidodeSuporte> iterator = this.pedidos.iterator();
        PedidodeSuporte temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_resolvido() && temp.get_data_resolucao().isAfter(inicio) && temp.get_data_resolucao().isBefore(fim)) {
                res.add(temp.clone());
            }
        }

        return res;
    }

    /**
     * Devolve os pedidos resolvidos num determinado período de tempo
     * Versão Iteradores Internos
     *
     * @param inicio limite inferior temporal
     * @param fim limite superior temporal
     */
    public List<PedidodeSuporte> resolvidos_I(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .filter(p -> p.get_data_resolucao().isAfter(inicio))
                           .filter(p -> p.get_data_resolucao().isBefore(fim))
                           .map(PedidodeSuporte::clone)
                           .collect(Collectors.toList());
    }

    /**
     * Calcula a média em minutos do tempo de resolução dos pedidos
     * Versão de Iteradores Internos
     *
     * @return média do tempo de resolução
     */
    public double tempoMedioResolucao_I() {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .mapToLong(PedidodeSuporte::tempo_resolucao)
                           .average()
                           .orElse(0);
    }

    /**
     * Calcula a média em minutos do tempo de resolução dos pedidos
     * Versão de Iteradores Externos
     *
     * @return média do tempo de resolução
     */
    public double tempoMedioResolucao_E() {
        Iterator<PedidodeSuporte> iterator = this.pedidos.iterator();
        PedidodeSuporte temp = null;
        long total = 0;

        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.get_resolvido()) {
                total += temp.tempo_resolucao();
            }
        }

        return total / (double) this.pedidos.size();
    }


    /**
     * Calcula a média em minutos do tempo de resolução dos pedidos concluídos num determinado período
     *
     * @param inicio limite inferior temporal
     * @param fim limite superior temporal
     * @return tempo medio de resolucao
     */
    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream()
                           .filter(p -> p.get_data_resolucao().isAfter(inicio))
                           .filter(p -> p.get_data_resolucao().isBefore(fim))
                           .mapToLong(PedidodeSuporte::tempo_resolucao)
                           .average()
                           .orElse(0);
    }

    /**
     * Devolve o pedido de suporte que demorou mais tempo a ser resolvido
     *
     * @return Pedido de Suporte mais demorado
     */
    public PedidodeSuporte pedidoMaisLongo() {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .map(PedidodeSuporte::clone)
                           .sorted((p1, p2) -> Long.compare(p2.tempo_resolucao(), p1.tempo_resolucao()))
                           .findFirst()
                           .orElse(null);
    }

    /**
     * Devolve, dos pedidos resolvidos num determinado intervalo, o que demorou mais tempo a ser resolvido
     *
     * @param inicio limite inferior temporal
     * @param fim limite superior temporal
     * @return Pedido de Suporte mais demorado
     */
    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .filter(p -> p.get_data_resolucao().isAfter(inicio))
                           .filter(p -> p.get_data_resolucao().isBefore(fim))
                           .map(PedidodeSuporte::clone)
                           .sorted((p1, p2) -> Long.compare(p2.tempo_resolucao(), p1.tempo_resolucao()))
                           .findFirst()
                           .orElse(null);
    }

    /**
     * Devolve o pedido de suporte que demorou menos tempo a ser resolvido
     *
     * @return Pedido de Suporte menos demorado
     */
    public PedidodeSuporte pedidoMaisCurto() {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .map(PedidodeSuporte::clone)
                           .sorted((p1, p2) -> Long.compare(p1.tempo_resolucao(), p2.tempo_resolucao()))
                           .findFirst()
                           .orElse(null);
    }

    /** 
    * Devolve, dos pedidos resolvidos num determinado intervalo, o que demorou menos tempo a ser resolvido
    *
    * @param inicio limite inferior temporal
    * @param fim limite superior temporal
    * @return Pedido de Suporte menos demorado
    */
    public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim) {
        return this.pedidos.stream()
                           .filter(PedidodeSuporte::get_resolvido)
                           .filter(p -> p.get_data_resolucao().isAfter(inicio))
                           .filter(p -> p.get_data_resolucao().isBefore(fim))
                           .map(PedidodeSuporte::clone)
                           .sorted((p1, p2) -> Long.compare(p2.tempo_resolucao(), p1.tempo_resolucao()))
                           .findFirst()
                           .orElse(null);
    }
}
