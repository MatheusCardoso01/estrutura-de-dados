package list.linked.list;

public class SinglyLinkedList {

    private Node inicio;

    public SinglyLinkedList() {
        this.inicio = null;
    }

    boolean isEmpty() {
        return this.inicio == null;
    }

    void inserir(int elemento) {
        Node novoNo = new Node();
        novoNo.setElemento(elemento);
        novoNo.setProximo(null);

        if (isEmpty()) {
            this.inicio = novoNo;
        } else {
            Node aux;
            aux = inicio;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(novoNo);
        }
    }

    void inserirNoInicio(int elemento) {
        Node novoNo = new Node();
        novoNo.setElemento(elemento);
        novoNo.setProximo(this.inicio);
        this.inicio = novoNo;
    }

    int retirarPrimeiroElemento() {
        if (isEmpty()) {
            throw new RuntimeException("Nada a exibir. A lista está vazia.");
        } else {
            Node aux = this.inicio;
            int elemento = aux.getElemento();
            inicio = inicio.getProximo();
            return elemento;
        }
    }

    int retirarElementoEspecifico(int elementoARetirar) {
        if (isEmpty()) {
            throw new RuntimeException("Nada a exibir. A lista está vazia.");
        }

        Node aux = this.inicio;
        Node anterior = null;

        if (aux.getElemento() == elementoARetirar) {
            inicio = inicio.getProximo();
            return aux.getElemento();
        }
        while (aux != null && aux.getElemento() != elementoARetirar) {
            anterior = aux;
            aux = aux.getProximo();
        }
        if (aux != null) {
            anterior.setProximo(aux.getProximo());
            return aux.getElemento();
        } else {
            throw new RuntimeException("Elemento não encontrado na lista");
        }
    }

    void listarTodosOsElementos() {
        if (isEmpty()) {
            System.out.println("Não há elementos para exibir. Lista Vazia.");
        } else {
            int i = 1;
            Node aux = this.inicio;
            while (aux != null) {
                System.out.println(i + "o. Elemento da lista: " + aux.getElemento());
                aux = aux.getProximo();
                i++;
            }
        }
    }

    int verificarTamanhoDaLista() {
        Node aux = inicio;
        int cont = 0;

        while (aux != null) {
            cont++;
            aux = aux.getProximo();
        }

        return cont;
    }

}
