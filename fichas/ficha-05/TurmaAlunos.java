
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;


public class TurmaAlunos implements Comparable<TurmaAlunos> {

    /**
     * Variáveis de Instância
     */

    private String nome;
    private String codigo;
    private HashMap<String, Aluno> alunos;


    /**
     * Construtores
     */

    /**
     * Construtor por omissão de uma TurmaAlunos
     */
    public TurmaAlunos() {
        this.nome = "";
        this.codigo = "";
        this.alunos = new HashMap<String, Aluno>();
    }

    /**
     * Construtor parametrizado de uma TurmaAlunos
     *
     * @param nome nome da TurmaAlunos
     * @param codigo codigo da UC
     * @param alunos colecao de alunos
     */
    public TurmaAlunos(String nome, String codigo, Collection<Aluno> alunos) {
        this();
        this.nome = nome;
        this.codigo = codigo;
        Iterator<Aluno> iterator = alunos.iterator();
        Aluno temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.alunos.put(temp.get_numero(), temp.clone());
        }
    }

    /**
     * Construtor de cópia de uma TurmaAlunos
     *
     * @param outro TurmaAlunos a copiar
     */
    public TurmaAlunos(TurmaAlunos outro) {
        this();
        this.nome = outro.nome;
        this.codigo = outro.codigo;

        Iterator<Map.Entry<String, Aluno>> iterator = outro.alunos.entrySet().iterator();
        Map.Entry<String, Aluno> temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.alunos.put(temp.getKey(), temp.getValue().clone());
        }
    }

    /**
     * Métodos de Instância
     */

    // getters
    
    /**
     * Devolve o nome da Turma
     *
     * @return nome da Turma
     */
    public String get_nome() {
        return this.nome;
    }

    /**
     * Devolve o codigo da UC
     *
     * @return codigo da UC
     */
    public String get_codigo() {
        return this.codigo;
    }

    /**
     * Devovle os alunos da Turma
     *
     * @return lista de alunos
     */
    public List<Aluno> get_alunos() {
        return this.alunos.values().stream().map(Aluno::clone).collect(Collectors.toList());
    }

    // setters
    
    /**
     * Altera o nome da Turma
     *
     * @param nome nome da Turma
     */
    public void set_nome(String nome) {
        this.nome = nome;
    }

    /**
     * Altera o codigo da UC
     *
     * @param codigo codigo da UC
     */
    public void set_codigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Altera os alunos da Turma
     *
     * @param alunos colecao de alunos
     */
    public void set_alunos(Collection<Aluno> alunos) {
        this.alunos = new HashMap<String, Aluno>();
        Iterator<Aluno> iterator = alunos.iterator();
        Aluno temp = null;

        while (iterator.hasNext()) {
            temp = iterator.next();
            this.alunos.put(temp.get_numero(), temp.clone());
        }
    }

    // métodos de utilidade

    /**
     * Compara um objeto a uma TurmaAlunos
     *
     * @param obj objeto a comparar
     * @return true se forem iguais
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if ((obj == null) || (this.getClass() != obj.getClass()))
            return false;
        TurmaAlunos temp = (TurmaAlunos) obj;
        return this.nome.equals(temp.nome) && this.codigo.equals(temp.codigo)
            && this.alunos.equals(temp.alunos);
    }

    /**
     * Devolve uma representacao textual de uma TurmaAlunos
     *
     * @return representacao textual
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome);
        sb.append("Codigo: ").append(this.codigo);
        this.alunos.values().forEach(a -> sb.append(a.toString()));

        return sb.toString();
    }

    /**
     * Cria uma cópia de uma TurmaAlunos
     *
     * @return cópia de uma TurmaAlunos
     */
    public TurmaAlunos clone() {
        return new TurmaAlunos(this);
    }

    /**
     * Estabelece a ordem natural de Turmas de Alunos
     *
     * @return ordem natural
     */
    public int compareTo(TurmaAlunos outro) {
        return this.codigo.compareTo(outro.codigo);
    }

    // outros métodos

    /**
     * Adiciona um novo Aluno à turma
     *
     * @param a aluno a adicionar
     */
    public void insereAluno(Aluno a) {
        this.alunos.put(a.get_numero(), a.clone());
    }

    /**
     * Devolve um aluno dado o seu código
     *
     * @param codAluno numero de aluno
     * @return Aluno correspondente
     */
    public Aluno getAluno(String codAluno) {
        Aluno temp = this.alunos.get(codAluno);
        if (temp != null) {
            return temp.clone();
        }

        return null;
    }

    /**
     * Remove um Aluno da turma
     *
     * @param codAluno numero do Aluno
     */
    public void removeAluno(String codAluno) {
        this.alunos.remove(codAluno);
    }

    /**
     * Devolve todos os numeros da turma
     *
     * @return conjunto dos numeros
     */
    public Set<String> todosOsCodigos() {
        return this.alunos.keySet();
    }

    /**
     * Determina o tamanho da turma
     *
     * @return tamanho da turma
     */
    public int qtsAlunos() {
        return this.alunos.size();
    }

    /**
     * Devolver os alunos ordenados por ordem alfabética do seu nome
     *
     * @return alunos por ordem alfabetica do nome
     */
    public Collection<Aluno> alunosOrdemAlfabetica() {
        return this.alunos.values().stream()
                                   .map(Aluno::clone)
                                   .sorted((a1, a2) -> a1.get_nome().compareTo(a2.get_nome()))
                                   .collect(Collectors.toList());
    }

    /**
     * Devolver os alunos ordenados por ordem decrescente do seu número
     *
     * @return conjunto de alunos
     */
    public Set<Aluno> alunosOrdemDescrescenteNumero() {
        return this.alunos.values().stream()
                                   .map(Aluno::clone)
                                   .sorted((a1, a2) -> a2.get_numero().compareTo(a1.get_numero()))
                                   .collect(Collectors.toSet());
    }
}
