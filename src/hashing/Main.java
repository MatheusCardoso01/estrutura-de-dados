package hashing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashingMap valores = new HashingMap();

        System.out.println("Mapa vazio: " + valores.isEmpty());

        valores.putOnMap("Matheus");
        valores.putOnMap("Paula");
        valores.putOnMap("Kauã");
        valores.putOnMap("Lucas");
        valores.putOnMap("Júlia");
        valores.putOnMap("Ana");

        System.out.println("Mapa vazio: " + valores.isEmpty());
        valores.showHashMap();
        System.out.println("Quantidade de elementos no Mapa: " + valores.getContainedValues());

        System.out.println(valores.removeFromMap(valores.generateKey("Kauã")));
        System.out.println(valores.removeFromMap(valores.generateKey("Ana")));

        valores.showHashMap();
        System.out.println("Quantidade de elementos no Mapa: " + valores.getContainedValues());

        valores.getFromMap(valores.generateKey("Ana"));
        valores.getFromMap(valores.generateKey("Matheus"));

        sc.close();
    }

}
