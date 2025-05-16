public class Descompactador {

  public String texto_compactado;
  public String texto_descompactado;

  public Descompactador(String texto_compactado) {
    this.texto_compactado = texto_compactado;
    this.texto_descompactado = "";
  } 
//classe usada para a operação inversa

  /*public void descompactar() {
    StringBuilder textoDescompactadoBuilder = new StringBuilder();
    int i = 0;
    while (i < texto_compactado.length()) {
      char letra = texto_compactado.charAt(i);
      i++; // Avança para o '('

      if (i < texto_compactado.length() && texto_compactado.charAt(i) == '(') {
        i++; // Avança para o primeiro dígito da quantidade
        int j = i;
        while (j < texto_compactado.length() && Character.isDigit(texto_compactado.charAt(j))) {
          j++;
        }

        if (j > i && j < texto_compactado.length() && texto_compactado.charAt(j) == ')') {
          int quantidade = Integer.parseInt(texto_compactado.substring(i, j));
          for (int k = 0; k < quantidade; k++) {
            textoDescompactadoBuilder.append(letra);
          }
          i = j + 2; // Avança para o próximo caractere após ') ' (se houver)
        } else {
          // Formato inválido, lida com o erro ou adiciona a letra sozinha
          textoDescompactadoBuilder.append(letra);
          // Pode ser necessário avançar 'i' de forma diferente dependendo do tratamento
          // de erro
          if (j < texto_compactado.length()) {
            i = j + 1;
          } else {
            break;
          }
        }
      } else {
        // Caso não encontre '(', adiciona a letra sozinha
        textoDescompactadoBuilder.append(letra);
        // Avança para o próximo caractere
        i++;
      }
    }
    this.texto_descompactado = textoDescompactadoBuilder.toString();
  } */

  /*public void descompactar(){
    String copy= texto_compactado;
    StringBuilder texto_final_builder = new StringBuilder();

    for(int i=0; i < copy.length(); i++){
      char q = copy.charAt(i);
      if (Character.isLetter(q)){
        int quantos = (int) copy.charAt(i+2);
        for (int o=0; o < quantos; o++){
          texto_final_builder.append(q);
        }
      }
    }
    this.texto_descompactado = texto_final_builder.toString();
  } */
 
  public void descompactar() {
  //para o caso de ser nulo
    if (texto_compactado == null || texto_compactado.isEmpty()) {
      this.texto_descompactado = "";
      return;
    }

    StringBuilder texto_final_builder = new StringBuilder();
    //percorrendo até o fim do texto compactado
    for (int i = 0; i < texto_compactado.length(); i++) {
      char currentChar = texto_compactado.charAt(i);
     //pega o caractere daquela posição
      if (Character.isLetter(currentChar)) {
        // Encontrou uma letra, agora precisa ler a quantidade
        int quantidadeInicio = texto_compactado.indexOf('(', i);
        int quantidadeFim = texto_compactado.indexOf(')', quantidadeInicio + 1);

        if (quantidadeInicio != -1 && quantidadeFim != -1 && quantidadeInicio > i) {
          try {
           //pega o numero entre "(" e ")"
            int quantos = Integer.parseInt(texto_compactado.substring(quantidadeInicio + 1, quantidadeFim));
       //realiza um for para realocar no texto_final naquela 
      //quantidade de vezes
            for (int o = 0; o < quantos; o++) {
              texto_final_builder.append(currentChar);
            }
            i = quantidadeFim; // Avança o índice para depois do ')'
          } catch (NumberFormatException e) {
            // Tratar caso a quantidade não seja um número válido
            System.err.println("Erro ao descompactar: Formato de quantidade inválido próximo a '" + currentChar + "'");
            // Pode adicionar uma lógica para interromper ou tentar continuar de outra forma
          } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Erro ao descompactar: Formato incompleto próximo a '" + currentChar + "'");
            // Tratar caso a string termine inesperadamente
          }
        } else {
          // Tratar caso o formato esperado não seja encontrado
          System.err.println("Erro ao descompactar: Formato esperado (quantidade) não encontrado após a letra '" + currentChar + "'");
          // Pode adicionar uma lógica para lidar com isso
        }
      }
    }  //cria o texto descompactado
    this.texto_descompactado = texto_final_builder.toString();
  }

  public String getTextoCompactado() {
    return texto_compactado;
  }

  public String getTextoDescompactado() {
    return texto_descompactado;
  }
}