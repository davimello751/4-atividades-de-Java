// Importa a classe Scanner, que permite ler dados digitados pelo usuário
import java.util.Scanner;

// Classe principal que testa o funcionamento da Agenda
public class TesteAgenda {
    public static void main(String[] args) {

        // Cria um objeto da classe Agenda para armazenar os contatinhos
        Agenda agenda = new Agenda();

        // Cria um Scanner para ler entradas do teclado
        Scanner scanner = new Scanner(System.in);

        int opcao;  // Variável que vai guardar a opção escolhida pelo usuário no menu

        // Estrutura de repetição que exibe o menu até o usuário escolher sair (opção 0)
        do {
            // Exibe o menu de opções
            System.out.println("\n1 - Adicionar contatinho");
            System.out.println("2 - Buscar contatinho por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Lê a opção digitada pelo usuário
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o caractere de nova linha (\n) que sobra após o nextInt()

            // Executa uma ação com base na opção escolhida
            switch (opcao) {

                case 1:
                    // Adicionar um novo contatinho
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    // Cria um novo objeto Contatinho com os dados digitados e adiciona à agenda
                    agenda.addContatinho(new Contatinho(nome, email, telefone, categoria));

                    System.out.println("Contatinho adicionado!");
                    break;

                case 2:
                    // Buscar um contatinho pelo nome
                    System.out.print("Digite o nome do contatinho que deseja buscar: ");
                    String nomeBusca = scanner.nextLine();

                    // Antes de buscar, salva a lista atual em um arquivo chamado "agenda.txt"
                    agenda.salvarLista("agenda.txt");

                    // Busca o contatinho no arquivo
                    Contatinho resultado = agenda.buscarContatinhoPorNome(nomeBusca, "agenda.txt");

                    // Verifica se encontrou o contatinho
                    if (resultado != null) {
                        System.out.println("Contatinho encontrado:");
                        System.out.println("Nome: " + resultado.getNome());
                        System.out.println("Email: " + resultado.getEmail());
                        System.out.println("Telefone: " + resultado.getTelefone());
                        System.out.println("Categoria: " + resultado.getCategoria());
                    } else {
                        System.out.println("Contatinho não encontrado!");
                    }
                    break;

                case 0:
                    // Encerra o programa
                    System.out.println("Saindo...");
                    break;

                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);  // Repete o menu enquanto a opção for diferente de 0

        // Fecha o Scanner para liberar os recursos do sistema
        scanner.close();
    }
}
