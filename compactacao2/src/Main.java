import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // Print a message to the console
        System.out.println("Procedimento no arquivo2.txt \n");
        ExtratorTextoArquivo extrair = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo2.txt");


        String inputText = extrair.extrairTexto();
        System.out.println("Texto original: " + inputText);
        Huffman HF = new Huffman();

        HuffmanNode huffmanTreeRoot = HF.buildHuffmanTree(inputText);
        Map<Character, String> huffmanCodes = HF.generateHuffmanCodes(huffmanTreeRoot);

        System.out.println("\nCódigos de Huffman:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String compressedText = HF.compress(inputText, huffmanCodes);
        System.out.println("\nTexto codificado: " + compressedText);

        String decompressedText = HF.decompress(compressedText, huffmanTreeRoot);
        System.out.println("\nTexto decodificado: " + decompressedText);

        if (inputText.equals(decompressedText)) {
            System.out.println("\nDescompactação bem-sucedida!");
        } else {
            System.out.println("\nErro na descompactação.");
        }

        System.out.println("criando o arquivo comprimido");
        StringParaArquivo guardar = new StringParaArquivo();
        guardar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo2Comp.txt",compressedText);
        guardar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo2Desc.txt",decompressedText);

        System.out.println("Procedimento no arquivo1.txt \n");

        ExtratorTextoArquivo extrair2 = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo1.txt");


        String inputText2 = extrair2.extrairTexto();
        System.out.println("Texto original: " + inputText2);
        Huffman HF2 = new Huffman();

        HuffmanNode huffmanTreeRoot2 = HF2.buildHuffmanTree(inputText2);
        Map<Character, String> huffmanCodes2 = HF2.generateHuffmanCodes(huffmanTreeRoot2);

        System.out.println("\nCódigos de Huffman:");
        for (Map.Entry<Character, String> entry : huffmanCodes2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String compressedText2 = HF2.compress(inputText2, huffmanCodes2);
        System.out.println("\nTexto codificado: " + compressedText2);

        String decompressedText2 = HF2.decompress(compressedText2, huffmanTreeRoot2);
        System.out.println("\nTexto decodificado: " + decompressedText2);

        if (inputText2.equals(decompressedText2)) {
            System.out.println("\nDescompactação bem-sucedida!");
        } else {
            System.out.println("\nErro na descompactação.");
        }

        System.out.println("criando o arquivo comprimido");
        StringParaArquivo guardar2 = new StringParaArquivo();
        guardar2.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo1Comp.txt",compressedText);
        guardar2.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao2\\src\\arquivo1Desc.txt",decompressedText);



    }
}


