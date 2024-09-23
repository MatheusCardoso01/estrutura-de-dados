package data.search;

import java.util.Scanner;

public class LinearSearch {

    private int numPesquisado;

    static int[] vet = new int[100];

    int gerarNumerosAleatoriosNaoRepetidos() {
        int valor;
        do {
            valor = (int) (Math.random() * 101);
        } while (numeroRepetido(valor));
        return valor;
    }

    boolean numeroRepetido(int valor) {
        for (int valorNoIndice : vet) {
            if (valorNoIndice == valor) {
                return true;
            }
        }
        return false;
    }

    void buscarValor() {
        boolean achou = false;

        // BUSCA LINEAR COMPLEXIDADE O(N) (MAIS LENTA)
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] == numPesquisado) {
                achou = true;
                System.out.println("Achou  o valor " + numPesquisado + " na posição " + i);
                break;
            }
        }
        if (!achou) {
            System.out.println("Não achou o valor digitado");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinearSearch buscaLinear = new LinearSearch();

        for (int i = 0; i < vet.length; i++) {
            vet[i] = buscaLinear.gerarNumerosAleatoriosNaoRepetidos();
            System.out.print(vet[i] + " ");
        }

        System.out.println("\nQual o número que você busca? ");
        buscaLinear.numPesquisado = sc.nextInt();

        buscaLinear.buscarValor();

        sc.close();

    }

}
