package data.sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int[] vet = new int[10_000];
        int aux;
        int i_menor;

        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 10_001);
            System.out.print(vet[i] + " ");
        }

        long inicio = System.currentTimeMillis();

        // SELECTION SORT COMPLEXIDADE O(N^2)
        for (int i = 0; i < vet.length - 1; i++) { //O(N)
            i_menor = i;
            for (int j = i + 1; j < vet.length; j++) { //O(N)
                if (vet[i_menor] > vet[j]) {
                    i_menor = j;
                }
            }
            aux = vet[i];
            vet[i] = vet[i_menor];
            vet[i_menor] = aux;
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
