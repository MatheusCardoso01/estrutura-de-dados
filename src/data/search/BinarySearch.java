package data.search;

import java.util.Scanner;

public class BinarySearch {

    int[] vet = new int[10_000];
    int numPesquisado;

    void gerarNumerosAleatoriosNaoRepetidos() {
        int valor;

        for (int i = 0; i < vet.length; i++) {
            do {
                valor = (int) (Math.random() * 10_000);
            } while (numeroRepetido(valor, i));
            vet[i] = valor;
        }
    }

    boolean numeroRepetido(int valor, int indicesPreenchidos) {
        //Verifica números iguais até onde o vetor foi preenchido
        for (int i = 0; i < indicesPreenchidos; i++) {
            if (vet[i] == valor) {
                return true;
            }
        }
        return false;
    }

    void ordenarValores() {
        int aux;

        // BUBBLESORT (OBRIGATÓRIO ORDENAR NA BUSCA BINÁRIA)
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
    }

    void buscarValores() {
        boolean achou = false;
        int inicio = 0;
        int fim = vet.length - 1;
        int meio = 0;
        int cont = 0; //quantas iterações foram necessárias

        // BUSCA BINÁRIA COMPLEXIDADE O(LOG N) (MUITO RÁPIDA)
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            cont++;
            if (vet[meio] == numPesquisado) {
                achou = true;
                break;
            } else if (vet[meio] < numPesquisado) {
                inicio = meio + 1;
            } else { //só pode ser maior
                fim = meio - 1;
            }
        }
        exibirResultadoDeBusca(achou, cont, meio);
    }

    void exibirResultadoDeBusca(boolean achou, int cont, int meio) {
        System.out.println("Número de iterações necessárias: " + cont);
        if (achou) {
            System.out.println("Achou o valor " + numPesquisado + " na posição " + meio + " do vetor");
        } else {
            System.out.println("Não achou o valor " + numPesquisado + " em nenhuma posição do vetor");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinarySearch buscaBinaria = new BinarySearch();

        buscaBinaria.gerarNumerosAleatoriosNaoRepetidos();
        buscaBinaria.ordenarValores();

        System.out.println("Qual o valor a ser encontrado? ");
        buscaBinaria.numPesquisado = sc.nextInt();

        buscaBinaria.buscarValores();

        sc.close();

    }

}
