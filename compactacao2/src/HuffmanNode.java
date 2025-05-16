import java.util.*;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

// HuffmanNode.java
class HuffmanNode implements Comparable<HuffmanNode> {
    int frequency;  //quantas vezes aparece
    char data; // a letra respectiva
    HuffmanNode left; //filhos direito e esquerdo
    HuffmanNode right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    @Override //comparação para a fila de prioridade, menor frequencia gera maior prioridade
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}