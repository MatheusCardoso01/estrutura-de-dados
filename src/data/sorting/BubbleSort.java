package data.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] vet = new int[10_000];
        int aux;

        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 10_001);
            System.out.print(vet[i] + " ");
        }

        long inicio = System.currentTimeMillis();

        //BUBBLE SORT COMPLEXIDADE O(N^2) (MAIS LENTO)
        for (int i = 0; i < vet.length - 1; i++) { //O(N)
            for (int j = i + 1; j < vet.length; j++) { //O(N)
                if (vet[i] > vet[j]) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }
        }

        long fim = System.currentTimeMillis();

        System.out.println("\n\n-----> APÓS ORDENAÇÃO");
        for (int valor : vet) {
            System.out.print(valor + " ");
        }

        System.out.println("\n\nTempo que leva para fazer a ordenação dos elementos: " +
                (fim - inicio) + " milésimos de segundos (ms)");

    }

}
