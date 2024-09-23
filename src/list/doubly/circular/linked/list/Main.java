package list.doubly.circular.linked.list;

public class Main {

    public static void main(String[] args) {

        DoublyCircularLinkedList listaCircularDupla = new DoublyCircularLinkedList();

        System.out.println("Lista Vazia: " + listaCircularDupla.isEmpty());
        listaCircularDupla.inserirElemento("Matheus");
        listaCircularDupla.inserirElemento("Carla");
        listaCircularDupla.inserirElemento("Júlia");
        listaCircularDupla.inserirElemento("Lucas");

        listaCircularDupla.exibirTodosOsElementos();
        listaCircularDupla.exibirTodosOsElementosEmOrdemInversa();

        listaCircularDupla.remover();
        listaCircularDupla.exibirTodosOsElementos();
        System.out.println("==================");
        listaCircularDupla.removerElementoEspecifico("Júlia");
        listaCircularDupla.exibirTodosOsElementos();

    }

}
