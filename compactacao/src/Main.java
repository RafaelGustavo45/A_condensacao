import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
       //por alguma razão não funciona com o texto do arquivo
     //original, tive que reduzir, não faço a minima ideia
   //do motivo
        //correção, está funcionando, o arquivo gera o modelo compactado Letra(quantidade)
        //porem não mostra no print

        //obrigado professor, sua ajuda conseguiu ajeitar o compactado da forma certa, era só um
        //pequeno detalhe
        //este projeto só trabalha com o arquivo1
        ExtratorTextoArquivo extract = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao\\src\\arquivo1.txt");
        String texto = extract.extrairTexto();
        Compactador compactador = new Compactador(texto);
        compactador.compactar();
        String textoCompactado = compactador.getTextoFinal();
        //System.out.println("Texto inicial: " + texto);
        System.out.println("Texto compactado: " + textoCompactado);

        StringParaArquivo gerar = new StringParaArquivo();

        gerar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao\\src\\arquivo1Comp.txt",textoCompactado);

        ExtratorTextoArquivo extract2 = new ExtratorTextoArquivo("C:\\Users\\User\\IdeaProjects\\compactacao\\src\\arquivo1Comp.txt");
        String compactado2 = extract2.extrairPrimeiraLinha();

        Descompactador des = new Descompactador(compactado2);

        des.descompactar();

        String desfeito =des.getTextoDescompactado();

        gerar.criarArquivo("C:\\Users\\User\\IdeaProjects\\compactacao\\src\\arquivo1DesComp.txt",desfeito);

        System.out.println("descompactado");


    }

}

