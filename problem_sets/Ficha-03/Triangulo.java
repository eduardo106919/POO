

public class Triangulo {

    /**
     * Variáveis de Instância
     */

    public Ponto ponto1;
    public Ponto ponto2;
    public Ponto ponto3;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de um Triangulo
     */
    public Triangulo() {
        this.ponto1 = new Ponto();
        this.ponto2 = new Ponto();
        this.ponto3 = new Ponto();
    }

    /**
     * Construtor parametrizado de um Triangulo
     *
     * @param p1 ponto 1
     * @param p2 ponto 2
     * @param p3 ponto 3
     */
    public Triangulo(Ponto p1, Ponto p2, Ponto p3) {
        this.ponto1 = p1.clone();
        this.ponto2 = p2.clone();
        this.ponto3 = p3.clone();
    }

    /**
     * Construtor de cópia de um Triangulo
     *
     * @param outro Triangulo a copiar
     */
    public Triangulo(Triangulo outro) {
        this.ponto1 = outro.ponto1.clone();
        this.ponto2 = outro.ponto2.clone();
        this.ponto3 = outro.ponto3.clone();
    }


    /**
     * Métodos de Instância
     */
    
    // getters
    
    /**
     * Devolve o ponto 1 do Triangulo
     *
     * @return ponto 1
     */
    public Ponto get_ponto1() {
        return this.ponto1.clone();
    }

    /**
     * Devolve o ponto 2 do Triangulo
     *
     * @return ponto 2
     */
    public Ponto get_ponto2() {
        return this.ponto2.clone();
    }

    /**
     * Devolve o ponto 3 do Triangulo
     *
     * @return ponto 3
     */
    public Ponto get_ponto3() {
        return this.ponto3.clone();
    }

    // setters
    
    /**
     * Altera o ponto 1 do Triangulo
     *
     * @param p ponto
     */
    public void set_ponto1(Ponto p) {
        this.ponto1 = p.clone();
    }

    /**
     * Altera o ponto 2 do Triangulo
     *
     * @param p ponto
     */
    public void set_ponto2(Ponto p) {
        this.ponto2 = p.clone();
    }
    
    /**
     * Altera o ponto 3 do Triangulo
     *
     * @param p ponto
     */
    public void set_ponto3(Ponto p) {
        this.ponto3 = p.clone();
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um Triangulo
     *
     * @param outro objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object outro) {
        if (this == outro)
            return true;
        if ((outro == null) || (this.getClass() != outro.getClass()))
            return false;
        Triangulo temp = (Triangulo) outro;
        return this.ponto1.equals(temp.ponto1) && this.ponto2.equals(temp.ponto2) && this.ponto3.equals(temp.ponto3);
    }

    /**
     * Devolve uma representacao textual de um Triangulo
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Ponto 1: ").append(this.ponto1);
        sb.append("Ponto 2: ").append(this.ponto2);
        sb.append("Ponto 3: ").append(this.ponto3);

        return sb.toString();
    }

    /**
     * Cria uma copia de um Triangulo
     *
     * @return copia de um Triangulo
     */
    public Triangulo clone() {
        return new Triangulo(this);
    }

    // outros métodos

    /**
     * Método que calcula a área do triângulo
     *
     * @return área do Triangulo
     */
    public double calculaAreaTriangulo() {
        double p1 = this.ponto1.distancia(this.ponto2);
        double p2 = this.ponto2.distancia(this.ponto3);
        double p3 = this.ponto3.distancia(this.ponto1);
        double s = (p1 + p2 + + p3) / 2;

        return Math.sqrt(s * (s - p1) * (s - p2) * (s - p3));
    }

    /**
     * Método que calcula o perímetro do triângulo
     *
     * @return perimetro do Triangulo
     */
    public double calculaPerimetroTriangulo() {
        return this.ponto1.distancia(this.ponto2) + this.ponto1.distancia(this.ponto3) + this.ponto2.distancia(this.ponto3);
    }

    /**
     * Método que calcula a altura do triângulo, definido como sendo a
     * distância no eixo dos y entre o ponto com menor coordenada em y e
     * o ponto com maior coordenada
     *
     * @return altura do Triangulo
     */
    public double calculaAlturaTriangulo() {
        Ponto menor = this.ponto1;
        Ponto maior = this.ponto1;

        if (this.ponto2.getY() < menor.getY()) {
            menor = this.ponto2;
        }

        if (this.ponto3.getY() < menor.getY()) {
            menor = this.ponto3;
        }

        if (this.ponto2.getY() > maior.getY()) {
            maior = this.ponto2;
        }

        if (this.ponto3.getY() > maior.getY()) {
            maior = this.ponto3;
        }

        return maior.distancia(menor);
    }


}
