import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StringParaArquivo {

    public static void criarArquivo(String caminhoArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write(conteudo);
            writer.flush();
            System.out.println("Arquivo '" + caminhoArquivo + "' criado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo '" + caminhoArquivo + "': " + e.getMessage());
        }
    }
}