




public class Aluno {

    /**
     * Variáveis de Instância
     */

    private String numero;
    private int nota;
    private String nome;
    private String curso;


    /**
     * Construtores
     */

     /**
      * Construtor por omissão de um Aluno
      */
    public Aluno() {
        this.numero = "";
        this.nota = 0;
        this.nome = "";
        this.curso = "";
    }

    /**
     * Construtor parametrizado de um Aluno
     *
     * @param numero numero do Aluno
     * @param nota nota do Aluno
     * @param nome nome do Aluno
     * @param curso curso do Aluno
     */
    public Aluno(String numero, int nota, String nome, String curso) {
        this.numero = numero;
        this.nota = nota;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Construtor de cópia de um Aluno
     *
     * @param outro Aluno a copiar
     */
    public Aluno(Aluno outro) {
        this.numero = outro.numero;
        this.nota = outro.nota;
        this.nome = outro.nome;
        this.curso = outro.curso;
    }
    

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o nome do Aluno
     *
     * @return nome do Aluno
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o numero do Aluno
     *
     * @return numero do Aluno
     */
    public String get_numero() {
        return this.numero;
    }

    /**
     * Devolve a nota do Aluno
     *
     * @return nota do Aluno
     */
    public int get_nota() {
        return this.nota;
    }

    /**
     * Devolve o curso do Aluno
     *
     * @return curso do Aluno
     */
    public String get_curso() {
        return this.curso;
    }

    // setters
    
    /**
     * Altera o nome do Aluno
     *
     * @param nome nome do Aluno
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o numero do Aluno
     *
     * @param numero numero do Aluno
     */
    public void set_numero(String numero) {
        this.numero = numero;
    }

    /**
     * Altera a nota do Aluno
     *
     * @param nota nota do Aluno
     */
    public void set_nota(int nota) {
        this.nota = nota;
    }

    /**
     * Altera o curso do Aluno
     *
     * @param curso curso do Aluno
     */
    public void set_curso(String curso) {
        this.curso = curso;
    }

    // métodos de utilidade

    /**
     * Compara um objeto a um Aluno
     *
     * @param obj objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Aluno temp = (Aluno) obj;
        return this.nome.equals(temp.nome) && this.nota == temp.nota
            && this.numero.equals(temp.numero) && this.curso.equals(temp.curso);
    }

    /**
     * Devolve uma representacao textual de um Aluno
     *
     * @return representcao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Numero: ").append(this.numero);
        sb.append("Nome: ").append(this.nome);
        sb.append("Nota: ").append(this.nota);
        sb.append("Curso: ").append(this.curso);

        return sb.toString();
    }

    /**
     * Cria uma cópia de um Aluno
     *
     * @return cópia de um Aluno
     */
    public Aluno clone() {
        return new Aluno(this);
    }
}
