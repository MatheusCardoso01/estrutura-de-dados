package stack;

import list.linked.list.Node;

public class LinkedStack {
    private Node topo;

    void push(int elemento) {
        Node novoNo = new Node();
        novoNo.setElemento(elemento);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha Vazia");
        }
        int elemento = topo.getElemento();
        topo = topo.getProximo();

        return elemento;
    }

    boolean isEmpty() {
        return topo == null;
    }

    public static void main(String[] args) {

        LinkedStack pilhaEncadeada = new LinkedStack();

        System.out.println("Pilha Vazia: " + pilhaEncadeada.isEmpty());

        pilhaEncadeada.push(850);
        pilhaEncadeada.push(489);
        pilhaEncadeada.push(500);

        System.out.println("Pilha Vazia: " + pilhaEncadeada.isEmpty());

        System.out.println("Elemento no topo: " + pilhaEncadeada.topo.getElemento());
        System.out.println("Valor atendido: " + pilhaEncadeada.pop());
        System.out.println("Valor atendido: " + pilhaEncadeada.pop());
        System.out.println("Valor atendido: " + pilhaEncadeada.pop());

        System.out.println("Pilha Vazia: " + pilhaEncadeada.isEmpty());

        pilhaEncadeada.push(9000);

        System.out.println("Elemento no topo: " + pilhaEncadeada.topo.getElemento());

    }
}
