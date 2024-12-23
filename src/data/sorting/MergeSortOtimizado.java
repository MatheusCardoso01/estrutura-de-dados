package data.sorting;

public class MergeSortOtimizado {

    public static void mergeSort(int[] array) {
        int[] auxiliar = new int[array.length];
        mergeSort(array, auxiliar, 0, array.length - 1);
    }

    public static int[] gerarValoresAleatorios(int size) {
        int[] vet = new int[size];
        for (int i = 0; i < vet.length; i++) {
            do {
                vet[i] = (int) (Math.random() * (vet.length + 1));
            } while (valoresRepetidos(vet, i));
        }

        return vet;
    }

    public static boolean valoresRepetidos(int[] vet, int indicesPreenchidos) {
        int valor = vet[indicesPreenchidos];

        for (int i = 0; i < indicesPreenchidos; i++) {
            if (vet[i] == valor) {
                return true;
            }
        }
        return false;
    }

    private static void mergeSort(int[] array, int[] auxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            // Ordena a primeira metade
            mergeSort(array, auxiliar, inicio, meio);

            // Ordena a segunda metade
            mergeSort(array, auxiliar, meio + 1, fim);

            // Mescla as duas metades
            merge(array, auxiliar, inicio, meio, fim);
        }
    }

    private static void merge(int[] array, int[] auxiliar, int inicio, int meio, int fim) {
        // Copia os elementos para o array auxiliar
        for (int i = inicio; i <= fim; i++) {
            auxiliar[i] = array[i];
        }

        int i = inicio; // Ponteiro da metade esquerda
        int j = meio + 1; // Ponteiro da metade direita
        int k = inicio; // Ponteiro do array original

        // Combina os elementos das duas metades
        while (i <= meio && j <= fim) {
            if (auxiliar[i] <= auxiliar[j]) {
                array[k] = auxiliar[i];
                i++;
            } else {
                array[k] = auxiliar[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da metade esquerda (se houver)
        while (i <= meio) {
            array[k] = auxiliar[i];
            i++;
            k++;
        }

        // A metade direita já está no lugar, não precisa de cópia adicional
    }

    public static void main(String[] args) {
        int[] array = gerarValoresAleatorios(10_000);
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        mergeSort(array);

        System.out.println("\n\nArray ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}