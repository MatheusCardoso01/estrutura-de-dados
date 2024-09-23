package list.linked.list;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList listaEncadeada = new SinglyLinkedList();

        System.out.println("Lista Vazia:" + listaEncadeada.isEmpty());
        listaEncadeada.inserir(1);
        listaEncadeada.inserir(25);
        listaEncadeada.inserir(117);
        listaEncadeada.inserir(1_451);
        listaEncadeada.inserir(10_000);
        listaEncadeada.inserir(552_351);
        listaEncadeada.inserir(9_999_999);

        listaEncadeada.listarTodosOsElementos();
        System.out.println("\nNúmero de elementos na lista: " + listaEncadeada.verificarTamanhoDaLista());

        //Retirar um elemento
        System.out.println("\nElemento removido: " + listaEncadeada.retirarPrimeiroElemento());

        System.out.println("Lista Vazia:" + listaEncadeada.isEmpty());

        //Inserir no início da lista
        listaEncadeada.inserirNoInicio(457_963_222);
        System.out.println("\nNúmero de elementos na lista após nova inserção: " + listaEncadeada.verificarTamanhoDaLista());

        //Retirar elemento específico
        System.out.println("\nElemento Específico removido: " + listaEncadeada.retirarElementoEspecifico(1451));
        System.out.println("Elemento Específico removido: " + listaEncadeada.retirarElementoEspecifico(552351));

        System.out.printf("\nNúmero de elementos na lista: %d\n\n", listaEncadeada.verificarTamanhoDaLista());

        //Retirar todos os elementos
        while (!listaEncadeada.isEmpty()) {
            System.out.println("Elemento removido: " + listaEncadeada.retirarPrimeiroElemento());
        }

        System.out.println("Lista Vazia:" + listaEncadeada.isEmpty());
        System.out.println("\nNúmero de elementos na lista após nova inserção: " + listaEncadeada.verificarTamanhoDaLista());

    }

}
