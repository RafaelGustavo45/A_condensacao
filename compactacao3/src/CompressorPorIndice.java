import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressorPorIndice {

    public static String comprimir(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }
 //utiliza um mapa contendo a letra (char) e uma lista de seus indices
        Map<Character, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);//pega a letra
            indices.computeIfAbsent(caractere, k -> new ArrayList<>()).add(i); //se não houver o a letra, adiciona a letra no hash com seu indice
        }

        StringBuilder resultado = new StringBuilder();
        boolean primeiro = true;
        for (Map.Entry<Character, List<Integer>> entry : indices.entrySet()) { //percorre o mapa buscando cada um
            if (!primeiro) {
                resultado.append(" "); //adiciona espaço caso seja novo
            } //adiciona "(" para inserir seus indices
            resultado.append(entry.getKey()).append("(");
          //adiciona a letra
            List<Integer> listaIndices = entry.getValue();
           //percorre a lista para ir adicionando os numeros
            for (int i = 0; i < listaIndices.size(); i++) {
                resultado.append(listaIndices.get(i));
                if (i < listaIndices.size() - 1) {
                    resultado.append(",");
                }
            }
            resultado.append(")");
            primeiro = false;
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        String entrada = "ABBCBCCCBA";
        String comprimido = comprimir(entrada);
        System.out.println("Entrada:    " + entrada);
        System.out.println("Comprimido: " + comprimido);
    }
}
