import java.util.ArrayList;

public class Quantitatorio {
    ArrayList<Character> letra = new ArrayList<Character>();

    ArrayList<Integer> quantidade = new ArrayList<Integer>();

   //o quantitatorio possui a quantidade da letra e a propria letra
//em duas listas distintas
    public Quantitatorio(){
        this.quantidade = new ArrayList<Integer>();
        this.letra = new ArrayList<Character>();
    }

    public void adicionarLetra(char l){
        letra.add(l);
        quantidade.add(1);
//adiciona a letra com quantidade 1
    }

    public void adicionarUm(char l){
        int index = letra.indexOf(l);
        int n = 1 + quantidade.get(index);
        quantidade.set(index,n);
//adiciona mais 1 de quantidade
    }

    public void adicionarUm(int index){
        int n = 1 + quantidade.get(index);
        quantidade.set(index,n);
    }

    public boolean contemLetra(char l){
        return letra.contains(l);
    }

    public int buscarIndexLetra(char l){
        return letra.indexOf(l);
    }

    @Override
    public String toString(){
        return letra.toString() +"\n" + quantidade.toString();
    }



}
