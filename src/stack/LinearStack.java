package stack;

import java.util.Scanner;

public class LinearStack {

    int topo;
    int[] pilha;

    void createStack(Scanner sc) {
        topo = -1;
        pilha = new int[sc.nextInt()];
    }

    //Empilhar
    void push(int value) throws Exception {
        if (isFull()) {
            throw new Exception("Pilha Cheia");
        }
        topo++;
        pilha[topo] = value;
    }

    //Desempilhar
    int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha Vazia");
        }
        int elemento = pilha[topo];
        topo--;
        return elemento;
    }

    //Pilha Vazia
    boolean isEmpty() {
        return (topo == -1);
    }

    //Pilha Cheia
    boolean isFull() {
        return (topo == (pilha.length - 1));
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        LinearStack P = new LinearStack();
        P.createStack(sc);

        System.out.println("Pilha Vazia:" + P.isEmpty());

        P.push(175);
        P.push(25);
        P.push(48);

        System.out.println("Topo: " + P.pop());
        System.out.println("Topo: " + P.pop());
        System.out.println("Topo: " + P.pop());

        System.out.println("Pilha Vazia:" + P.isEmpty());

        P.push(100);
        P.push(12);
        P.push(10);
        P.push(37);
        P.push(5);

        System.out.println("Pilha Cheia:" + P.isFull());

        sc.close();
    }

}
