// Importa classes da biblioteca padrão do Java
import java.util.ArrayList;       // Permite criar listas dinâmicas
import java.util.Collections;     // Oferece métodos para ordenar e manipular coleções
import java.util.Comparator;      // Permite definir regras de comparação entre objetos
import java.util.List;            // Interface que representa uma lista de elementos
import java.io.BufferedWriter;    // Escreve texto em arquivos de forma eficiente
import java.io.FileWriter;        // Cria ou abre arquivos de texto para escrita
import java.io.IOException;       // Trata erros de entrada/saída
import java.io.BufferedReader;    // Lê texto de arquivos de forma eficiente
import java.io.FileReader;        // Abre arquivos de texto para leitura

// Define a classe Agenda, que vai armazenar e manipular uma lista de contatinhos
public class Agenda {

    // Lista de objetos do tipo Contatinho
    private List<Contatinho> contatinhos;

    // Construtor da classe Agenda: inicializa a lista vazia
    public Agenda() {
        contatinhos = new ArrayList<>();
    }

    // Método para adicionar um novo contatinho à lista
    public void addContatinho(Contatinho c) {
        contatinhos.add(c);
    }

    // Método para ordenar a lista de contatinhos pelo nome (em ordem alfabética)
    public void ordenarLista() {
        // Usa o método sort da classe Collections com um comparador baseado no nome
        Collections.sort(contatinhos, Comparator.comparing(Contatinho::getNome));
    }

    // Método para salvar a lista de contatinhos em um arquivo de texto
    public void salvarLista(String nomeArquivo) {
        ordenarLista();  // Ordena a lista antes de salvar

        // Usa try-with-resources para garantir que o arquivo será fechado corretamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            // Para cada contatinho na lista, escreve uma linha no arquivo
            for (Contatinho c : contatinhos) {
                // Monta a linha com os dados separados por "#"
                String linha = c.getNome() + "#" + c.getEmail() + "#" + c.getTelefone() + "#" + c.getCategoria();
                writer.write(linha);      // Escreve a linha no arquivo
                writer.newLine();         // Adiciona uma quebra de linha
            }

            // Mensagem de sucesso no console
            System.out.println("Lista ordenada salva em: " + nomeArquivo);

        } catch (IOException e) {
            // Se ocorrer erro ao salvar, exibe mensagem de erro
            System.err.println("Erro ao salvar a lista: " + e.getMessage());
        }
    }

    // Método para acessar a lista de contatinhos (útil para outras partes do programa)
    public List<Contatinho> getContatinhos() {
        return contatinhos;
    }

    // Método para buscar um contatinho pelo nome dentro de um arquivo
    public Contatinho buscarContatinhoPorNome(String nomeBusca, String nomeArquivo) {

        // Usa try-with-resources para abrir o arquivo e garantir que será fechado corretamente
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            // Lê o arquivo linha por linha
            while ((linha = reader.readLine()) != null) {
                // Divide a linha em partes usando "#" como separador
                String[] dados = linha.split("#");

                // Verifica se a linha tem 4 partes e se o nome bate com o nome buscado
                if (dados.length == 4 && dados[0].equalsIgnoreCase(nomeBusca)) {
                    // Cria e retorna um novo objeto Contatinho com os dados encontrados
                    return new Contatinho(dados[0], dados[1], dados[2], dados[3]);
                }
            }

        } catch (IOException e) {
            // Se ocorrer erro ao ler o arquivo, exibe mensagem de erro
            System.err.println("Falha ao ler arquivo: " + e.getMessage());
        }

        // Se não encontrar o contatinho, retorna null
        return null;
    }
}
