import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Agenda {
    private List<Contatinho> contatinhos;

    public Agenda() {
        contatinhos = new ArrayList<>();
    }

    public void addContatinho(Contatinho c) {
        contatinhos.add(c);
    }

    public void ordenarLista() {
        Collections.sort(contatinhos, Comparator.comparing(Contatinho::getNome));
    }

    public void salvarLista(String nomeArquivo) {
        ordenarLista();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Contatinho c : contatinhos) {
                String linha = c.getNome() + "#" + c.getEmail() + "#" + c.getTelefone() + "#" + c.getCategoria();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Lista ordenada salva em: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista: " + e.getMessage());
        }
    }

    public List<Contatinho> getContatinhos() {
        return contatinhos;
    }

    //  MÉTODO DE BUSCA NO ARQUIVO:
    public Contatinho buscarContatinhoPorNome(String nomeBusca, String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split("#");
                if (dados.length == 4 && dados[0].equalsIgnoreCase(nomeBusca)) {
                    return new Contatinho(dados[0], dados[1], dados[2], dados[3]);
                }
            }
        } catch (IOException e) {
            System.err.println("Falha ao ler arquivo: " + e.getMessage());
        }
        return null;
    }
}