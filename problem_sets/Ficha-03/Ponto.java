
 /**
 * Classe que implementa um Ponto num plano 2D
 * As coordenadas do Ponto são inteiras
 *
 * @author MaterialPOO
 * @version 20250223
 */
public class Ponto {

    // variáveos de instância
    private int x;
    private int y;

    /**
     * Construtores da classe Ponto
     * Declaração dos construtores por omissão (vazio)
     * parametrizado e de cópia
     */

    /**
     * Construtor por omissão de Ponto
     */
    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Construtor parametrizado de Ponto
     * Aceita como parâmetros os valores para cada coordenada
     *
     * @param cx coordenada em x
     * @param cy coordenada em y
     */
    public Ponto(int cx, int cy) {
        this.x = cx;
        this.y = cy;
    }


    /**
     * Construtor de cópia de Ponto
     * Aceita como parâmetro outro Ponto e utiliza os métodos
     * de acesso aos valores das variáveis de instância
     *
     * @param umPonto outro Ponto
     */
    public Ponto(Ponto umPonto) {
        this.x = umPonto.getX();
        this.y = umPonto.getY();
    }

    /**
     * Métodos de instância
     */

    /**
     * Devolve o valor da coordenada em x
     *
     * @return valor da coordenada x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Devolve o valor da coordenada em y
     *
     * @return valor da coordenada y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Actualiza o valor da coordenada em x
     *
     * @param novoX novo valor da coordenada em X
     */
    public void setX(int novoX) {
        this.x = novoX;
    }

    /**
     * Actualiza o valor da coordenada em y
     *
     * @param novoY novo valor da coordenada em Y
     */
    public void setY(int novoY) {
        this.y = novoY;
    }

    /**
     * Método que desloca um ponto somando um delta às coordenadas em x e y
     *
     * @param deltaX valor de deslocamento do x
     * @param deltaY valor de deslocamento do y
     */
    public void deslocamento(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

     /**
     * Método que soma, ao Ponto receptor da mensagem, as componentes do Ponto passado como parâmetro
     *
     * @param umPonto ponto que é somado ao ponto receptor da mensagem
     */
    public void somaPonto(Ponto umPonto) {
        this.x += umPonto.getX();
        this.y += umPonto.getY();
    }

    /**
     * Método que move o Ponto para novas coordenadas
     *
     * @param cx novo valor de x
     * @param cy novo valor de y
     */
    public void movePonto(int cx, int cy) {
        this.x = cx ; // ou setX (cx)
        this.y = cy ; // ou this.setY(cy)
    }

    /**
     * Método que determina se o ponto está no quadrante positivo de x e y
     *
     * @return booleano que é verdadeiro se x > 0 e y > 0
     */
    public boolean ePositivo() {
        return (this.x > 0 && this.y > 0);
    }

    /**
     * Método que determina a distância de um Ponto a outro
     *
     * @param umPonto ponto ao qual se quer determinar a distância a partir do ponto que é o receptor da mensagem
     * @return double com o valor da distância
     */
    public double distancia(Ponto umPonto) {
        return Math.sqrt(Math.pow(this.x - umPonto.getX() , 2) + Math.pow(this.y - umPonto.getY() , 2));
    }

    /**
     * Método que determina se o módulo das duas coordenadas é o mesmo
     *
     * @return true, se as coordenadas em x e y forem iguais em valor absoluto
     */
     private boolean xIgualAy() {
         return (Math.abs(this.x) == Math.abs(this.y));
     }


    /**
     * Método que implementa a igualdade entre dois pontos
     * Reescrita do método equals que todos os objectos possuem
     *
     * @param o objecto que é comparado com o receptor da mensagem
     * @return boolean resultado booleano da comparação do râmetro com o receptor
     */
    public boolean equals(Object o) {
        if (this == o)
            return true ;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Ponto p = (Ponto) o;
        return (this.x == p.getX() && this.y == p.getY());
    }

    /**
     * Método que devolve a representação em String do Ponto
     *
     * @return String com as coordenadas x e y
     */
    public String toString() {
        return " Cx = " + this . x + " - Cy = " + this . y ;
    }

    /**
     * Método que faz uma cópia do objecto receptor da mensagem
     * Para tal invoca o construtor de cópia
     *
     * @return objecto clone do objecto que recebe a mensagem
     */
    public Ponto clone() {
        return new Ponto(this);
    }
}
