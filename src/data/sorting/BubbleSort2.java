package data.sorting;

public class BubbleSort2 {

    public static void main(String[] args) {

        int[] vet = {25, 57, 48, 37, 12, 92, 33}; // 7 posições
        int aux;

        System.out.printf("Vetor nas posições iniciais\n");
        for (int v : vet) {
            System.out.print(v + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j + 1];
                    vet[j + 1] = vet[j];
                    vet[j] = aux;
                }
                System.out.println(j + 1);
            }
            // O maior valor borbulha para o fim do vetor
            System.out.println("------> " + (i + 1) + "a iteração");
            for (int value : vet) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.printf("\nRESULTADO FINAL\n");

        for (int valor : vet) {
            System.out.print(valor + " ");
        }

    }

}
