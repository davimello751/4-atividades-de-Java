// Importa classes da biblioteca padrão do Java que serão usadas no programa
import java.io.BufferedWriter;     // Permite escrever texto em arquivos de forma eficiente (usando um "buffer")
import java.io.FileWriter;         // Permite criar ou abrir arquivos de texto para escrita
import java.io.IOException;        // Classe usada para tratar erros de entrada/saída (como problemas ao salvar o arquivo)
import java.util.Scanner;          // Permite ler dados digitados pelo usuário no teclado

// Define a classe principal do programa. Em Java, todo código precisa estar dentro de uma classe.
public class TabuadaEmArquivo {

    // Método principal: é o ponto de entrada do programa. Tudo começa a partir daqui.
    public static void main(String[] args) {

        // Cria um objeto chamado "scanner" que vai ler o que o usuário digitar no teclado
        Scanner scanner = new Scanner(System.in);

        // Exibe uma mensagem na tela pedindo para o usuário digitar um número
        // System.out.print exibe texto no console SEM pular linha no final
        System.out.print("Digite um número para calcular a tabuada: ");

        // Lê o número inteiro digitado pelo usuário e armazena na variável "numero"
        int numero = scanner.nextInt();

        // Cria uma string com o nome do arquivo onde a tabuada será salva
        // Exemplo: se o usuário digitou 7, o nome será "tabuada_7.txt"
        String nomeArquivo = "tabuada_" + numero + ".txt";

        // Bloco try-with-resources: garante que o arquivo será fechado corretamente após o uso
        // BufferedWriter escreve texto no arquivo de forma eficiente
        // FileWriter cria ou sobrescreve o arquivo com o nome especificado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            // Laço de repetição que vai de 1 até 10
            for (int i = 1; i <= 10; i++) {

                // Monta uma linha da tabuada, por exemplo: "7 x 3 = 21"
                String linha = numero + " x " + i + " = " + (numero * i);

                // Escreve essa linha no arquivo
                writer.write(linha);

                // Adiciona uma quebra de linha no arquivo (como apertar Enter)
                writer.newLine();
            }

            // Exibe uma mensagem no console informando que a tabuada foi salva com sucesso
            // System.out.println exibe texto e pula uma linha no final
            System.out.println("Tabuada salva no arquivo: " + nomeArquivo);

        } catch (IOException e) {
            // Se acontecer algum erro ao tentar escrever no arquivo, este bloco será executado
            // System.err.println exibe mensagens de erro no console (geralmente em vermelho)
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }

        // Fecha o objeto scanner para liberar os recursos do sistema
        scanner.close();
    }
}
