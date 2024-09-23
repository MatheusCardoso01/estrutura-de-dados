package data.sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int[] vet = new int[10_000];
        int aux;
        int j;

        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 10_001);
            System.out.print(vet[i] + " ");
        }

        long inicio = System.currentTimeMillis();

        // INSERTION SORT COMPLEXIDADE O(N^2)
        for (int i = 1; i < vet.length; i++) {
            aux = vet[i];
            j = i - 1;
            while (j >= 0 && vet[j] > aux) {
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = aux;
        }

        long fim = System.currentTimeMillis();

        System.out.println("\n\nVETOR ORDENADO");
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }

        System.out.println("\n\nTempo que leva para fazer a ordenação dos elementos: " +
                (fim - inicio) + " milésimos de segundos (ms)");

    }

}
