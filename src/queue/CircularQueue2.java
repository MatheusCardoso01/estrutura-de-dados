package queue;

import java.util.Scanner;

public class CircularQueue2 {

    int inicio;
    int fim;
    int total;
    int[] fila;

    public CircularQueue2(Scanner sc) {
        inicio = 0;
        fim = 0;
        total = 0;
        fila = new int[sc.nextInt()];
    }

    boolean isEmpty() {
        return (total == 0);
    }

    boolean isFull() {
        return (total == fila.length);
    }

    void inserirElementoNaFila(int elemento) throws Exception {
        if (isFull() ) {
            throw new Exception("A fila está cheia. Não há espaço para inserir novos elementos agora");
        } else if (fim == fila.length) {
            fim = 0; //Não usa módulo, mas zera fim no momento certo
        }
        fila[fim] = elemento;
        fim++;
        total++;
    }

    int retirarElementoDaFila() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia. Não há elementos para serem atendidos");
        } else if (inicio == fila.length) {
            inicio = 0;
        }
        int elemento = fila[inicio];
        inicio++;
        total--;
        return elemento;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        CircularQueue F = new CircularQueue(sc);

        System.out.println("Fila Vazia: " + F.isEmpty());

        F.inserirElementoNaFila(100);
        F.inserirElementoNaFila(10);
        F.inserirElementoNaFila(25);
        F.inserirElementoNaFila(1);

        System.out.println("Fila Cheia: " + F.isFull());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Fila Vazia: " + F.isEmpty());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Fila Vazia: " + F.isEmpty());

        F.inserirElementoNaFila(25);
        F.inserirElementoNaFila(14);
        F.inserirElementoNaFila(27);
        F.inserirElementoNaFila(33);
        F.inserirElementoNaFila(2);
        F.inserirElementoNaFila(5);
        F.inserirElementoNaFila(88);
        F.inserirElementoNaFila(99);
        F.inserirElementoNaFila(50);
        F.inserirElementoNaFila(49);
        System.out.println("Total: " + F.total);


        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Elemento a ser atendido: " + F.retirarElementoDaFila());
        System.out.println("Total: " + F.total);

        sc.close();
    }

}