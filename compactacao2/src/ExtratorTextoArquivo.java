import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtratorTextoArquivo {

    private String caminhoArquivo;

    public ExtratorTextoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public String extrairTexto() throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append(System.lineSeparator()); // Adiciona a quebra de linha original
            }
        }
        return conteudo.toString();
    }

    public String extrairTextoSemQuebras() throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
            }
        }
        return conteudo.toString();
    }

}