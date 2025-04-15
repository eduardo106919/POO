
import java.util.Arrays;

public class Telemovel {

    /**
     * Variáveis de Instância
     */
    
    private String marca;
    private String modelo;
    private int display_x;
    private int display_y;

    // espaco usado em mensagens
    private int usado_msgs;
    private int nr_msgs;
    private String[] mensagens;

    // espaco usado em fotos
    private int usado_fotos;
    private int nr_fotos;

    // espaco usado em apps
    private int usado_apps;
    private int nr_apps;
    private String[] apps;

    private int espaco_usado;
    private int espaco_total;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Telemovel
     */
    public Telemovel() {
        this.marca = "";
        this.modelo = "";
        this.display_x = this.display_y = 0;

        this.usado_msgs = this.nr_msgs = 0;
        this.mensagens = new String[10];

        this.usado_fotos = this.nr_fotos = 0;

        this.usado_apps = this.nr_apps = 0;
        this.apps = new String[10];

        this.espaco_usado = this.espaco_total = 0;
    }

    /**
     * Construtor parametrizado de um Telemovel
     *
     * @param marca marca do Telemovel
     * @param modelo modelo do Telemovel
     * @param display_x resolucao horizontal
     * @param display_y resolucao vertical
     */
    public Telemovel(String marca, String modelo, int display_x, int display_y, int espaco_total) {
        this();
        this.marca = marca;
        this.modelo = modelo;
        this.display_x = display_x;
        this.display_y = display_y;
        this.espaco_total = espaco_total;
    }

    /**
     * Construtor de cópia de um Telemovel
     *
     * @param outro Telemovel a copiar
     */
    public Telemovel(Telemovel outro) {
        this.marca = outro.marca;
        this.modelo = outro.modelo;
        this.display_x = outro.display_x;
        this.display_y = outro.display_y;

        this.usado_msgs = outro.usado_msgs;
        this.nr_msgs = outro.nr_msgs;
        this.mensagens = outro.mensagens.clone();

        this.usado_apps = outro.usado_apps;
        this.nr_apps = outro.nr_apps;
        this.apps = outro.apps.clone();

        this.espaco_usado = outro.espaco_usado;
        this.espaco_total = outro.espaco_total;
    }


    /**
     * Métodos de Instância
     */

    // getters

    /**
     * Devolve a marca do Telemovel
     *
     * @return marca do Telemovel
     */
    public String get_marca() {
        return this.marca;
    }

    /**
     * Devolve o modelo do Telemovel
     *
     * @return modelo do Telemovel
     */
    public String get_modelo() {
        return this.modelo;
    }

    /**
     * Devolve a resolucao horizontal do Telemovel
     *
     * @return resolucao horizontal
     */
    public int get_display_x() {
        return this.display_x;
    }

    /**
     * Devolve a resolucao vertical do Telemovel
     *
     * @return resolucao vertical
     */
    public int get_display_y() {
        return this.display_y;
    }

    /**
     * Devolve o espaco usado por mensagens no Telemovel
     *
     * @return espaco usado por mensagens
     */
    public int get_espaco_msgs() {
        return this.usado_msgs;
    }

    /**
     * Devolve o espaco usado em fotos no Telemovel
     *
     * @return espaco usado em fotos
     */
    public int get_espaco_fotos() {
        return this.usado_fotos;
    }

    /**
     * Devolve o espaco usado em apps no Telemovel
     *
     * @return espaco usado em apps
     */
    public int get_espaco_apps() {
        return this.usado_apps;
    }

    /**
     * Devolve o espaco usado no Telemovel
     *
     * @return espaco usado
     */
    public int get_espaco_usado() {
        return this.espaco_usado;
    }

    /**
     * Devolve o espaco total do Telemovel
     *
     * @return espaco total
     */
    private int get_espaco_total() {
        return this.espaco_total;
    }

    /**
     * Devolve o numero de fotos guardadas no Telemovel
     *
     * @return numero de fotos
     */
    public int get_nr_fotos() {
        return this.nr_fotos;
    }

    /**
     * Devolve o numero de apps no Telemovel
     *
     * @return numero de apps
     */
    public int get_nr_apps() {
        return this.nr_msgs;
    }

    /**
     * Devolve as apps instaladas no Telemovel
     *
     * @return apps instaladas
     */
    public String[] get_apps() {
        return Arrays.copyOfRange(this.apps, 0, this.nr_apps);
    }

    // setters
    
    /**
     * Altera a marca do Telemovel
     *
     * @param marca marca do Telemovel
     */
    public void set_marca(String marca) {
        this.marca = marca;
    }

    /**
     * Altera o modelo do Telemovel
     *
     * @param modelo modelo do Telemovel
     */
    public void set_modelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Altera a resolucao horizontal do Telemovel
     *
     * @param display_x resolucao horizontal
     */
    public void set_display_x(int display_x) {
        this.display_x = display_x;
    }

    /**
     * Altera a resolucao vertical do Telemovel
     *
     * @param display_y resolucao vertical
     */
    public void set_display_y(int display_y) {
        this.display_y = display_y;
    }

    /**
     * Altera o espaco total do Telemovel, caso este seja maior que o espaco usado
     *
     * @param espaco_total espaco total de armazenamento
     */
    public void set_espaco_total(int espaco_total) {
        if (espaco_total > this.espaco_usado) {
            this.espaco_total = espaco_total;
        }
    }

    // métodos de utilidade
    
    /**
     * Compara um objecto ao Telemovel que recebe a mensagem
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Telemovel temp = (Telemovel) outro;
        return this.marca.equals(temp.marca) && this.modelo.equals(temp.modelo)
            && this.display_x == temp.display_x && this.display_y == temp.display_y
            && this.usado_msgs == temp.usado_msgs && this.nr_msgs == temp.nr_msgs
            && Arrays.equals(this.mensagens, temp.mensagens)
            && this.usado_fotos == temp.usado_fotos && this.nr_fotos == temp.nr_fotos
            && this.usado_apps == temp.usado_apps && this.nr_apps == temp.nr_apps
            && Arrays.equals(this.apps, temp.apps)
            && this.espaco_usado == temp.espaco_usado && this.espaco_total == temp.espaco_total;
    }

    /**
     * Cria uma cópia do Telemovel que recebe a mensagem
     *
     * @return cópia de um Telemovel
     */
    public Telemovel clone() {
        return new Telemovel(this);
    }

    /**
     * Devolve uma representacao textual de um Telemovel
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Marca: ").append(this.marca);
        sb.append("\nModelo: ").append(this.modelo);
        sb.append("\nDisplay: ").append(this.display_x).append(" x ").append(this.display_y);
        sb.append("\nEspaco usado: ").append(this.espaco_usado);
        sb.append("\nEspaco total: ").append(this.espaco_total);

        return sb.toString();
    }
    
    // outros métodos

    /**
     * Método que valida se um determinado conteúdo pode ser 
     * carregado para o telefone
     *
     * @param numeroBytes espaco do conteudo a carregar
     * @return true se puder ser carregado
     */
    public boolean existeEspaco(int numeroBytes) {
        return numeroBytes <= (this.espaco_total - this.espaco_usado);
    }

    /**
     * Método que carrega (isto é, instala) uma aplicação nova
     *
     * @param nome nome da aplicacao
     * @param tamanho tamanho da aplicacao
     */
    public void instalaApp(String nome, int tamanho) {
        if (this.existeEspaco(tamanho)) {
            // array cheio
            if (this.nr_apps == this.apps.length) {
                String[] temp = new String[this.nr_apps * 2];

                for (int i = 0; i < this.nr_apps; i++) {
                    temp[i] = this.apps[i];
                }

                this.apps = temp;
            }

            this.apps[this.nr_apps] = nome;
            this.usado_apps += tamanho;
            this.espaco_usado += tamanho;
            this.nr_apps++;
        }
    }

    /**
     * Método que recebe e guarda uma mensagem de texto
     *
     * @param msg mensagem recebida
     */
    public void recebeMsg(String msg) {
        if (this.existeEspaco(msg.length())) {
            // array cheio
            if (this.nr_msgs == this.mensagens.length) {
                String[] temp = new String[this.nr_msgs * 2];

                for (int i = 0; i < this.nr_msgs; i++) {
                    temp[i] = this.mensagens[i];
                }

                this.mensagens = temp;
            }

            this.mensagens[this.nr_msgs] = msg;
            this.usado_msgs += msg.length();
            this.espaco_usado += msg.length();
            this.nr_msgs++;
        }
    }

    /**
     * Método que determina o tamanho médio das aplicações
     *
     * @return tamanho médio das aplicações
     */
    public double tamMedioApps() {
        return this.usado_apps / (double) this.nr_apps;
    }

    /**
     * Método que devolve a maior mensagem de texto recebida
     *
     * @return maior mensagem
     */
    public String maiorMsg() {
        if (this.nr_msgs == 0) {
            return null;
        }

        int max = 0;
        for (int i = 1; i < this.nr_msgs; i++) {
            if (this.mensagens[i].length() > this.mensagens[max].length()) {
                max = i;
            }
        }
        
        return this.mensagens[max];
    }

    /**
     * Método que desinstala uma aplicação
     *
     * @param nome nome da aplicacao
     * @param tamanho tamanho da aplicacao
     */
    public void removeApp(String nome, int tamanho) {
        if (this.nr_apps != 0) {
            int index = 0;
            int i;

            for (i = 0; i < this.nr_apps && this.apps[i].equals(nome) == false; i++);

            if (i < this.nr_apps) {
                for (int j = i + 1; j < this.nr_apps; j++) {
                    this.apps[j - 1] = this.apps[j];
                }

                this.nr_apps--;
            }
        }
    }
}
