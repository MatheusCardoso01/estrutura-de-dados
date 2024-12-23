package data.sorting;

public class QuickSort {

    private int[] vet;

    void gerarValoresAleatorios() {
        for (int i = 0; i < vet.length; i++) {
            do {
                vet[i] = (int) (Math.random() * (vet.length + 1));
            } while (valoresRepetidos(i));
        }
    }

    boolean valoresRepetidos(int indicesPreenchidos) {
        int valor = vet[indicesPreenchidos];

        for (int i = 0; i < indicesPreenchidos; i++) {
            if (vet[i] == valor) {
                return true;
            }
        }
        return false;
    }

    void imprimirVetor() {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
    }

    // Complexidade O(n log n)
    void quickSort(int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }

        int indicePivo = parcionarValores(inicio, fim);
        quickSort(inicio, indicePivo - 1); //coloca valores menores a esquerda
        quickSort(indicePivo + 1, fim); // coloca valores maiores a direita
    }

    int parcionarValores(int inicio, int fim) {
        int pivo = vet[inicio];
        int pivoPos = inicio;
        int aux;
        for (int i = inicio + 1; i <= fim; i++) {
            if (pivo >= vet[i]) {
                pivoPos++;
                aux = vet[i];
                vet[i] = vet[pivoPos];
                vet[pivoPos] = aux;
            }
        }
        aux = vet[pivoPos];
        vet[pivoPos] = pivo;
        vet[inicio] = aux;
        return pivoPos;
    }

    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        quickSort.vet = new int[10_000];

        quickSort.gerarValoresAleatorios();

//        quickSort.vet = new int[]{3,0,1,2,4,5};

        long tempoInicial = System.currentTimeMillis();

        quickSort.quickSort(0, quickSort.vet.length - 1);

        long tempoFinal = System.currentTimeMillis();

        quickSort.imprimirVetor();

        System.out.println("\n\nTempo que leva para fazer a ordenação dos elementos: " +
                (tempoFinal - tempoInicial) + " milésimos de segundos (ms)");
    }
}
