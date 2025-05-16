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

    public String extrairPrimeiraLinha() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            return br.readLine(); // Lê apenas a primeira linha e retorna
        }
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

    // Outros métodos relacionados à extração podem ser adicionados aqui,
    // como extrair linhas específicas, etc.

    public static void main(String[] args) {
        // Este método main é apenas para demonstração e não faz parte
        // da classe principal conforme solicitado.

        String caminho = "exemplo.txt"; // Substitua pelo caminho do seu arquivo

        // Crie um arquivo de exemplo para testar
        java.io.File arquivo = new java.io.File(caminho);
        try (java.io.PrintWriter pw = new java.io.PrintWriter(arquivo)) {
            pw.println("Esta é a primeira linha.");
            pw.println("Esta é a segunda linha.");
            pw.println("E esta é a terceira.");
        } catch (java.io.IOException e) {
            System.err.println("Erro ao criar arquivo de exemplo: " + e.getMessage());
        }

        ExtratorTextoArquivo extrator = new ExtratorTextoArquivo(caminho);
        try {
            String textoCompleto = extrator.extrairTexto();
            System.out.println("Texto completo do arquivo:\n" + textoCompleto);

            String textoSemQuebras = extrator.extrairTextoSemQuebras();
            System.out.println("\nTexto completo do arquivo (sem quebras de linha):\n" + textoSemQuebras);

        } catch (IOException e) {
            System.err.println("Erro ao extrair texto do arquivo: " + e.getMessage());
        } finally {
            // Opcional: Apagar o arquivo de exemplo após o teste
            arquivo.delete();
        }
    }
}