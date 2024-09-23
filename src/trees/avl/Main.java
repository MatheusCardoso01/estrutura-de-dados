package trees.avl;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Random random = new Random();

        // Testando inserções
        System.out.println("Inserindo valores:");
        for (int i = 0; i < 200; i++) {
            int value = random.nextInt(1000); // Valores aleatórios entre 0 e 999
            tree.insert(value);
            System.out.println("Inserido: " + value);
            tree.printAVLTree();
        }

        // Testando buscas
        System.out.println("Buscando valores:");
        int[] searchValues = {50, 30, 100, 110, 5, 1};
        for (int value : searchValues) {
            System.out.println("Busca " + value + ": " + tree.search(value));
        }

        // Testando remoções
        System.out.println("Removendo valores:");
        for (int i = 0; i < 50; i++) {
            int value = random.nextInt(1000); // Valores aleatórios entre 0 e 999
            System.out.println("Removendo " + value + ":");
            tree.remove(value);
            tree.printAVLTree();
        }

        System.out.println("\n\n==================================================\n");
        tree.printAVLTree();
    }
}
