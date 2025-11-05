// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Scanner;
// import java.io.File;

// public class LeTabuadaDeArquivo {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Digite o número cuja tabuada você deseja ler: ");
//         int numero = scanner.nextInt();

//         String nomeArquivo = "tabuada_" + numero + ".txt";
//         File arquivo = new File(nomeArquivo);

//         if (!arquivo.exists()) {
//             System.out.println("O arquivo " + nomeArquivo + " não existe.");
//         } else {
//             try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
//                 String linha;
//                 System.out.println("Conteúdo da tabuada:");
//                 while ((linha = reader.readLine()) != null) {
//                     System.out.println(linha);
//                 }
//             } catch (IOException e) {
//                 System.err.println("Erro ao ler o arquivo: " + e.getMessage());
//             }
//         }

//         scanner.close();
//     }
// }