import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Com o arquivo1.txt");

        ExtratorTextoArquivo extrair = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo1.txt");

        //String conteudo = extrair.extrairTexto();
        //apenas o com huffman está funcionando adequadamente para extração do arquivo completo
        //pensei que fosse por usar a classe Quantitatório mas até com o
        //Hash e Map ocorre este problema menos aqui
        String conteudo = extrair.extrairPrimeiraLinha();

        CompressorPorIndice comp= new CompressorPorIndice();

        String comprimido = comp.comprimir(conteudo);

        System.out.println("Entrada:    " + conteudo);
        System.out.println("Comprimido: " + comprimido);

        StringParaArquivo criar = new StringParaArquivo();
        criar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo1Comp.txt",comprimido);

        System.out.println("Descomprimindo");

        DescompressorPorIndice descomp = new DescompressorPorIndice();

        String descomprimido = descomp.descomprimir(comprimido);

        System.out.println("Comprimido:    " + comprimido);
        criar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo1DesComp.txt",descomprimido);
        System.out.println("Descomprimido: " + descomprimido);

        System.out.println("Com o arquivo2.txt");

        ExtratorTextoArquivo extrair2 = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo2.txt");
        String conteudo2 = extrair2.extrairPrimeiraLinha();
        CompressorPorIndice comp2 = new CompressorPorIndice();
        String comprimido2 = comp2.comprimir(conteudo2);
        System.out.println("Entrada:    " + conteudo2);
        System.out.println("Comprimido: " + comprimido2);

        StringParaArquivo criar2 = new StringParaArquivo();
        criar2.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo2Comp.txt",comprimido2);

        System.out.println("Descomprimindo");

        DescompressorPorIndice descomp2 = new DescompressorPorIndice();

        String descomprimido2 = descomp2.descomprimir(comprimido2);

        System.out.println("Comprimido:    " + comprimido2);
        criar2.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao3\\src\\arquivo2DesComp.txt",descomprimido2);
        System.out.println("Descomprimido: " + descomprimido2);



    }
}