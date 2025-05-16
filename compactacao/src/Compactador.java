import java.util.HashMap;

public class Compactador {
  public String texto_inicial;
  public String texto_final;

  public Quantitatorio quais;
  //HashMap<Character, Integer> caracter_quantidade = new HashMap<Character, Integer>();

  public Compactador(String texto) {
    this.texto_inicial = texto;
    //cria um objeto Quantitatorio e inicia o texto final vazio
    //this.caracter_quantidade = new HashMap<Character, Integer>();
    quais = new Quantitatorio();
    this.texto_final = "";
  }

  public String compactar() {
   //caso não tenha cada, cria-se nulo
    if (texto_inicial == null || texto_inicial.isEmpty()) {
      return "";
    }
   //percorrendo, se já houve a letra aumenta+1
    for (char caractere : texto_inicial.toCharArray()) {
      if (quais.contemLetra(caractere)) {
        quais.adicionarUm(caractere);
      } else { // adiciona essa letra na listagem com quantidade de 1
        quais.adicionarLetra(caractere);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < quais.letra.size(); i++) {
  //percorre e adicionar no StringBuilder o formado
  //compactado A(vezes) B(vezes)
      sb.append(quais.letra.get(i));
      sb.append("(");
      sb.append(quais.quantidade.get(i));
      sb.append(")");
      if (i < quais.letra.size() - 1) {
       //adiciona um espaço
        sb.append(" ");
      }
    }
    this.texto_final = sb.toString();
    return this.texto_final;
//retorna o texto final criado pelo toString()
  }

  /*public void compactar(){
    String copia = this.texto_inicial;

    for(int i =0; i < copia.length(); i++){
      char caractere = copia.charAt(i);
      boolean existe = quais.contemLetra(caractere);
      if(existe){
        int index = quais.buscarIndexLetra(caractere);
        quais.adicionarUm(index);
      } else{
        quais.adicionarLetra(caractere);
      }

    }
    codificar();


  }

  public void codificar(){
    StringBuilder texto_final_builder = new StringBuilder();
    for(int i=0; i< quais.letra.size();i++){
      texto_final_builder.append(quais.letra.get(i));
      texto_final_builder.append("(");
      texto_final_builder.append(quais.quantidade.get(i));
      texto_final_builder.append(")");
      texto_final_builder.append(" ");
    }
    this.texto_final = texto_final_builder.toString().trim();

  }
  */


  public String getTextoInicial() {
    return texto_inicial;
  }

  public String getTextoFinal() {
    return texto_final;
  }


}