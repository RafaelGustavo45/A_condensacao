import java.util.*;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

// Classe para representar um nó na árvore de Huffman
// Huffman.java
import java.util.*;

public class Huffman {
    //cria um mapa com o char e a sua frequencia que aparece
    public static HuffmanNode buildHuffmanTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();  //percorre com char na String
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
   // 2. Criar uma fila de prioridade (min-heap) para armazenar os nós da árvore
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
// constroi uma arvore combinando os nós pela menor frequencia
        while (priorityQueue.size() > 1) {
  //a menor frequencia é a maior prioridade
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
     //criando um pai com a soma das frequencias dos filhos
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
    //adiciona o nó pai a fila de prioridade
            priorityQueue.offer(parent);
        }
  // 
        return priorityQueue.poll();
    }
//metodo que gera codigos para cara caractere usando a arvore
    public static Map<Character, String> generateHuffmanCodes(HuffmanNode root) {
        Map<Character, String> huffmanCodes = new HashMap<>();  // mapa que armazena os codigos gerados
        generateCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }
  //recursividade que gera os codigos 
    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        if (node.data != '\0') { 
    //se o nó é uma folha (contem um caractere), armazena o codigo no mapa
            huffmanCodes.put(node.data, code);
            return;
        }
   // chamadas recursivas para os filhos esquerdo e direito
        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }
    //compacta usando a arvore
    public static String compress(String text, Map<Character, String> huffmanCodes) {
        StringBuilder compressedText = new StringBuilder();
        for (char c : text.toCharArray()) { //troca cada caractere pelo seu codigo binário
            compressedText.append(huffmanCodes.get(c));
        }
        return compressedText.toString(); //retorna o texto compactado como string de bits
    }
  //descompactar usando a arvore
    public static String decompress(String compressedText, HuffmanNode root) {
        StringBuilder decompressedText = new StringBuilder();
        HuffmanNode current = root; //inicia na raiz
        for (char bit : compressedText.toCharArray()) {
            if (bit == '0') {
                current = current.left; //se o filho é 0, vai ao filho esquerdo
            } else if (bit == '1') {
                current = current.right; //se 1, ao direito
            }
//se chegou a uma folha, logo encontrou um caractere
            if (current.left == null && current.right == null) {
                decompressedText.append(current.data); //adiciona ao construtor do texto descompactado
                current = root; //volta para a raiz para decodificar o proximo caractere
            }
        }
        return decompressedText.toString();
    }

    public static void main(String[] args) {
        String inputText = "BABAABAAAACCDDDAA";
        System.out.println("Texto original: " + inputText);

        HuffmanNode huffmanTreeRoot = buildHuffmanTree(inputText);
        Map<Character, String> huffmanCodes = generateHuffmanCodes(huffmanTreeRoot);

        System.out.println("\nCódigos de Huffman:");//percorre para mostrar cada codigo e seu valor associado
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String compressedText = compress(inputText, huffmanCodes);
        System.out.println("\nTexto codificado: " + compressedText);

        String decompressedText = decompress(compressedText, huffmanTreeRoot);
        System.out.println("\nTexto decodificado: " + decompressedText);

        if (inputText.equals(decompressedText)) {
            System.out.println("\nDescompactação bem-sucedida!");
        } else {
            System.out.println("\nErro na descompactação.");
        }
    }
}