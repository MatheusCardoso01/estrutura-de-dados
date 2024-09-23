package trees.binary.search;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserir valores na árvore
        System.out.println("Inserindo valores:");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);
        bst.insert(45);
        bst.insert(55);
        bst.insert(65);
        bst.insert(75);
        bst.insert(85);

        // Percursos
        System.out.println("Percurso em ordem:");
        bst.inOrder(); // Deve imprimir: 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85
        System.out.println();

        System.out.println("Percurso em pré-ordem:");
        bst.preOrder(); // Deve imprimir: 50 30 20 15 25 40 35 45 70 60 55 65 80 75 85
        System.out.println();

        System.out.println("Percurso em pós-ordem:");
        bst.postOrder(); // Deve imprimir: 15 25 20 35 45 40 30 55 65 60 75 85 80 70 50
        System.out.println();

        // Testando buscas
        System.out.println("Buscando valores:");
        System.out.println("Busca 50: " + bst.search(50)); // Deve retornar true
        System.out.println("Busca 30: " + bst.search(30)); // Deve retornar true
        System.out.println("Busca 100: " + bst.search(100)); // Deve retornar false
        System.out.println();

        // Testando remoções
        System.out.println("Removendo valores:");

        // Remover um nó sem filhos
        System.out.println("Removendo 15 (nó sem filhos):");
        bst.remove(15);
        bst.inOrder(); // Deve imprimir: 20 25 30 35 40 45 50 55 60 65 70 75 80 85
        System.out.println();

        // Remover um nó com um filho
        System.out.println("Removendo 25 (nó com um filho):");
        bst.remove(25);
        bst.inOrder(); // Deve imprimir: 20 30 35 40 45 50 55 60 65 70 75 80 85
        System.out.println();

        // Remover um nó com dois filhos
        System.out.println("Removendo 30 (nó com dois filhos):");
        bst.remove(30);
        bst.inOrder(); // Deve imprimir: 20 35 40 45 50 55 60 65 70 75 80 85
        System.out.println();

        // Remover um nó que é a raiz e tem dois filhos
        System.out.println("Removendo 50 (nó que se torna a nova raiz):");
        bst.remove(50);
        bst.inOrder(); // Deve imprimir: 20 35 40 45 55 60 65 70 75 80 85
        System.out.println();

        // Remover um nó com dois filhos (teste de árvore mais complexa)
        System.out.println("Removendo 70 (nó com dois filhos):");
        bst.remove(70);
        bst.inOrder(); // Deve imprimir: 20 35 40 45 55 60 65 75 80 85
        System.out.println();

        // Testar remoções em árvore vazia
        System.out.println("Removendo 80 (nó com um filho):");
        bst.remove(80);
        bst.inOrder(); // Deve imprimir: 20 35 40 45 55 60 65 75 85
        System.out.println();

        System.out.println("Removendo 40 (nó com nenhum filho):");
        bst.remove(40);
        bst.inOrder(); // Deve imprimir: 20 35 45 55 60 65 75 85
        System.out.println();
    }
}
