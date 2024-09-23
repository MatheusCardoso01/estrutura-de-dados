package list.doubly.circular.linked.list;

import java.util.Objects;

public class DoublyCircularLinkedList {

    private Node inicio;

    public DoublyCircularLinkedList() {
        inicio = null;
    }

    boolean isEmpty() {
        return inicio == null;
    }

    void inserirElemento(String elemento) {
        Node novoNo = new Node();
        novoNo.setElemento(elemento);

        if (isEmpty()) {
            inicio = novoNo;
            inicio.setNext(inicio);
            inicio.setPrev(inicio);
        } else {
            novoNo.setPrev(inicio.getPrev());
            inicio.getPrev().setNext(novoNo);
            novoNo.setNext(inicio);
            inicio.setPrev(novoNo);
        }
    }

    String remover() {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return null;
        }

        String elemento = inicio.getElemento();

        if (inicio.getNext() == inicio) {
            inicio = null;
        } else {
            inicio.getPrev().setNext(inicio.getNext());
            inicio.getNext().setPrev(inicio.getPrev());
            inicio = inicio.getNext();
        }
        return elemento;
    }

    String removerElementoEspecifico(String elemento) {
        boolean achou = procurarElementoNaLista(elemento);

        if (achou) {
            Node aux = inicio;

            while (!Objects.equals(aux.getElemento(), elemento)) {
                aux = aux.getNext();
            }
            if (aux.getNext() == aux) {
                inicio = null;
            } else {
                aux.getNext().setPrev(aux.getPrev());
                aux.getPrev().setNext(aux.getNext());
                if (aux == inicio) {
                    inicio = inicio.getNext();
                }
            }
            return aux.getElemento();
        }

        return null;
    }

    boolean procurarElementoNaLista(String elemento) {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return false;
        }

        Node busca = inicio;

        while (!Objects.equals(busca.getElemento(), elemento)) {
            if (busca.getNext() == inicio) {
                System.out.println("Elemento não encontrado");
                return false;
            }
            busca = busca.getNext();
        }

        return true;
    }

    void exibirTodosOsElementos() {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return;
        }

        int i = 1;
        Node aux = inicio;

        do {
            System.out.println(i + "o elemento: " + aux.getElemento());
            i++;
            aux = aux.getNext();
        } while (aux != inicio);
    }

    void exibirTodosOsElementosEmOrdemInversa() {
        if (isEmpty()) {
            System.out.println("Lista Vazia");
            return;
        }

        Node aux = inicio;

        do {
            System.out.println("Elemento: " + aux.getElemento());
            aux = aux.getPrev();
        } while (aux != inicio);
    }

}

