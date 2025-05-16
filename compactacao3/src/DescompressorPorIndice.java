import java.util.HashMap;
import java.util.Map;

public class DescompressorPorIndice {

    public static String descomprimir(String textoComprimido) {
        if (textoComprimido == null || textoComprimido.isEmpty()) {
            return "";
        }
    //mapa contendo cada letra com seu indice
        Map<Integer, Character> mapaDescompressao = new HashMap<>();
        String[] partes = textoComprimido.split(" ");
        //sepração pelo espaço para trabalhar com "Letra(lista de indices)"
        for (String parte : partes) {
            if (parte.length() >= 3 && Character.isLetter(parte.charAt(0)) && parte.charAt(1) == '(' && parte.charAt(parte.length() - 1) == ')') {
                char letra = parte.charAt(0);
                String indicesStr = parte.substring(2, parte.length() - 1);
                String[] indicesArray = indicesStr.split(",");
                for (String indiceStr : indicesArray) {
                    try {
                        int indice = Integer.parseInt(indiceStr.trim());
                        mapaDescompressao.put(indice, letra);
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao descompactar: Índice inválido em '" + parte + "'");
                        return null; // Ou outra forma de tratamento de erro
                    }
                }
            } else if (!parte.isEmpty()) {
                System.err.println("Erro ao descompactar: Formato inválido na parte '" + parte + "'");
                return null; // Ou outra forma de tratamento de erro
            }
        }

        if (mapaDescompressao.isEmpty()) {
            return "";
        }

        int tamanhoOriginal = -1;
        for (int indice : mapaDescompressao.keySet()) {
            tamanhoOriginal = Math.max(tamanhoOriginal, indice);
        }
        tamanhoOriginal++; // O índice é baseado em 0

        char[] textoOriginal = new char[tamanhoOriginal];
        for (int i = 0; i < tamanhoOriginal; i++) {
            textoOriginal[i] = mapaDescompressao.getOrDefault(i, '\0'); // Use um caractere padrão se o índice não existir (erro)
        }

        return new String(textoOriginal);
    }

    public static void main(String[] args) {
        String comprimido = "A(0,9) B(1,2,8) C(3,4,5,6,7)";
        String descomprimido = descomprimir(comprimido);
        System.out.println("Comprimido:  " + comprimido);
        System.out.println("Descomprimido: " + descomprimido);

        String comprimidoExemploAnterior = "A(0,9,4) B(1,2,8) C(3,7,6,5)";
        String descomprimidoExemploAnterior = descomprimir(comprimidoExemploAnterior);
        System.out.println("\nComprimido (exemplo anterior):  " + comprimidoExemploAnterior);
        System.out.println("Descomprimido (exemplo anterior): " + descomprimidoExemploAnterior);

        String comprimidoErro = "A(0,a) B(1)"; // Erro no formato do índice
        String descomprimidoErro = descomprimir(comprimidoErro);
        System.out.println("\nComprimido (erro): " + comprimidoErro);
        System.out.println("Descomprimido (erro): " + descomprimidoErro);
    }
}