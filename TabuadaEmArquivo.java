// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Scanner;

// public class TabuadaEmArquivo {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Digite um número para calcular a tabuada: ");
//         int numero = scanner.nextInt();

//         String nomeArquivo = "tabuada_" + numero + ".txt";

//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
//             for (int i = 1; i <= 10; i++) {
//                 String linha = numero + " x " + i + " = " + (numero * i);
//                 writer.write(linha);
//                 writer.newLine();
//             }
//             System.out.println("Tabuada salva no arquivo: " + nomeArquivo);
//         } catch (IOException e) {
//             System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
//         }

//         scanner.close();
//     }
// }