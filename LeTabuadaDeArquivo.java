// Importa classes necessárias para ler arquivos e interagir com o usuário
import java.io.BufferedReader;   // Permite ler texto de arquivos de forma eficiente
import java.io.FileReader;       // Permite abrir arquivos de texto para leitura
import java.io.IOException;      // Classe usada para tratar erros de entrada/saída
import java.util.Scanner;        // Permite ler dados digitados pelo usuário no teclado
import java.io.File;             // Representa um arquivo ou diretório no sistema

// Define a classe principal do programa
public class LeTabuadaDeArquivo {

    // Método principal: é onde o programa começa a ser executado
    public static void main(String[] args) {

        // Cria um objeto Scanner para ler o que o usuário digitar
        Scanner scanner = new Scanner(System.in);

        // Exibe uma mensagem pedindo ao usuário que digite um número
        // System.out.print mostra texto no console SEM pular linha
        System.out.print("Digite o número cuja tabuada você deseja ler: ");

        // Lê o número digitado e armazena na variável "numero"
        int numero = scanner.nextInt();

        // Cria o nome do arquivo com base no número digitado
        // Exemplo: se o número for 5, o nome será "tabuada_5.txt"
        String nomeArquivo = "tabuada_" + numero + ".txt";

        // Cria um objeto File que representa o arquivo com esse nome
        File arquivo = new File(nomeArquivo);

        // Verifica se o arquivo existe no sistema
        if (!arquivo.exists()) {
            // Se não existir, exibe uma mensagem informando isso
            System.out.println("O arquivo " + nomeArquivo + " não existe.");
        } else {
            // Se o arquivo existir, tenta abrir e ler seu conteúdo
            try (
                // Cria um BufferedReader para ler o arquivo linha por linha
                BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))
            ) {
                String linha;  // Variável para armazenar cada linha lida

                // Exibe um título antes de mostrar a tabuada
                System.out.println("Conteúdo da tabuada:");

                // Lê cada linha do arquivo até que não haja mais linhas (null)
                while ((linha = reader.readLine()) != null) {
                    // Exibe a linha lida no console
                    System.out.println(linha);
                }

            } catch (IOException e) {
                // Se ocorrer algum erro ao ler o arquivo, exibe uma mensagem de erro
                // System.err.println mostra mensagens de erro (geralmente em vermelho)
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        // Fecha o scanner para liberar os recursos do sistema
        scanner.close();
    }

    // Observação: o comentário "// }" no final parece um erro ou sobra de edição
    // O código já está corretamente fechado com a chave acima
}
