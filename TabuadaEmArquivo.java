import java.io.BufferedWriter;     // Importa a classe para escrita eficiente em arquivos de texto
import java.io.FileWriter;         // Importa a classe que permite criar e manipular arquivos de texto
import java.io.IOException;        // Importa exceção usada para tratar erros de entrada/saída
import java.util.Scanner;          // Importa a classe para leitura de dados do usuário

public class TabuadaEmArquivo {
     public static void main(String[] args) {
         // Cria um objeto Scanner para ler dados do teclado
         Scanner scanner = new Scanner(System.in);

         // Solicita ao usuário que digite o número desejado
         System.out.print("Digite um número para calcular a tabuada: ");
         int numero = scanner.nextInt();  // Lê o número digitado

         // Define o nome do arquivo onde a tabuada será salva
         String nomeArquivo = "tabuada_" + numero + ".txt";

         // Usa try-with-resources para criar o BufferedWriter e garantir que ele será fechado automaticamente
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
             // Laço para calcular a tabuada de 1 até 10
             for (int i = 1; i <= 10; i++) {
                 // Monta a linha do resultado da tabuada, ex: "5 x 1 = 5"
                 String linha = numero + " x " + i + " = " + (numero * i);
                 writer.write(linha);      // Escreve a linha no arquivo
                 writer.newLine();         // Adiciona uma nova linha
             }
             // Mensagem informando que o arquivo foi salvo com sucesso
             System.out.println("Tabuada salva no arquivo: " + nomeArquivo);
         } catch (IOException e) {
             // Trata possíveis erros de escrita no arquivo e exibe a mensagem de erro
             System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
         }

         // Fecha o scanner para liberar recursos
         scanner.close();
     }
}
