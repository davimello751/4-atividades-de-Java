// Define a classe chamada Contatinho
// Em Java, uma classe é como um molde para criar objetos com características e comportamentos
public class Contatinho {

    // Declaração de atributos (características) do contatinho
    // Esses atributos são privados, ou seja, só podem ser acessados diretamente dentro da própria classe
    private String nome;       // Nome do contato
    private String email;      // Email do contato
    private String telefone;   // Telefone do contato
    private String categoria;  // Categoria do contato (ex: amigo, trabalho, família)

    // Construtor da classe: é chamado quando criamos um novo objeto Contatinho
    // Recebe os valores iniciais para nome, email, telefone e categoria
    public Contatinho(String nome, String email, String telefone, String categoria) {
        this.nome = nome;             // "this.nome" se refere ao atributo da classe
        this.email = email;           // "email" é o valor passado como parâmetro
        this.telefone = telefone;
        this.categoria = categoria;
    }

    // Métodos "get" e "set" são usados para acessar e modificar os atributos privados

    // Retorna o nome do contatinho
    public String getNome() { return nome; }

    // Permite alterar o nome do contatinho
    public void setNome(String nome) { this.nome = nome; }

    // Retorna o email do contatinho
    public String getEmail() { return email; }

    // Permite alterar o email do contatinho
    public void setEmail(String email) { this.email = email; }

    // Retorna o telefone do contatinho
    public String getTelefone() { return telefone; }

    // Permite alterar o telefone do contatinho
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Retorna a categoria do contatinho
    public String getCategoria() { return categoria; }

    // Permite alterar a categoria do contatinho
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
