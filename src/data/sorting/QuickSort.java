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

    int parcionarValores(int inicio, int fim) {
        int pivo = vet[inicio];
        int i = fim + 1;
        int aux;
        for (int j = fim; j > inicio; j--) {
            if (vet[j] >= pivo) {
                i--;
                aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
        int posiPivo = i - 1;
        aux = vet[posiPivo];
        vet[posiPivo] = vet[inicio];
        vet[inicio] = aux;

        return posiPivo;
    }

    // Complexidade O(n log n)

    void ordenarValores(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = parcionarValores(inicio, fim);
            ordenarValores(inicio, indicePivo - 1); //coloca valores menores a esquerda
            ordenarValores(indicePivo + 1, fim); // coloca valores maiores a direita
        }
    }

    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        quickSort.vet = new int[10_000];

        quickSort.gerarValoresAleatorios();

        long tempoInicial = System.currentTimeMillis();

        quickSort.ordenarValores(0, quickSort.vet.length - 1);

        long tempoFinal = System.currentTimeMillis();

        quickSort.imprimirVetor();

        System.out.println("\n\nTempo que leva para fazer a ordenação dos elementos: " +
                (tempoFinal - tempoInicial) + " milésimos de segundos (ms)");
    }
}
