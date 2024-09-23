package queue;

import list.linked.list.Node;

public class LinkedQueue {

    private Node inicio;
    private Node fim;

    public LinkedQueue() {
        this.inicio = null;
        this.fim = null;
    }

    boolean isEmpty() {
        return this.inicio == null;
    }

    void inserir(int elemento) {
        Node novoNo = new Node();
        novoNo.setElemento(elemento);
        novoNo.setProximo(null);

        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            this.fim.setProximo(novoNo);
            this.fim = novoNo;
        }
    }

    Integer retirar() {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return null;
        }

        int elemento = inicio.getElemento();
        inicio = inicio.getProximo();

        if (this.inicio == null) {
            fim = null;
        }

        return elemento;
    }

    int verificarTamanhoDaFila() {
        int cont = 0;
        Node aux = inicio;

        while (aux != null) {
            aux = aux.getProximo();
            cont++;
        }

        return cont;
    }

    void listarElementosDaFila() {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return;
        }

        Node aux = inicio;
        int i = 1;

        while (aux != null) {
            System.out.println(i + " elemento da fila: " + aux.getElemento());
            aux = aux.getProximo();
            i++;
        }
    }

    public static void main(String[] args) {

        LinkedQueue fila = new LinkedQueue();

        fila.inserir(555);
        fila.inserir(29);
        fila.inserir(40);
        fila.inserir(260);
        fila.inserir(1000);
        fila.inserir(9);

        System.out.println("Tamanho da Fila: " + fila.verificarTamanhoDaFila());
        fila.listarElementosDaFila();
        System.out.println("Elemento Atendido: " + fila.retirar());
        System.out.println("Elemento Atendido: " + fila.retirar());
        System.out.println("Elemento Atendido: " + fila.retirar());
        fila.inserir(400);
        System.out.println("Tamanho da Fila: " + fila.verificarTamanhoDaFila());
        fila.listarElementosDaFila();

    }

}
