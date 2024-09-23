package hashing;

import java.util.Objects;

public class HashingMap {

    private static int hashTableSize;
    private int containedValues;
    private final HashStruct[] hashMap;


    public HashingMap() {
        hashTableSize = 100_003;
        containedValues = 0;
        this.hashMap = new HashStruct[hashTableSize];
    }

    public int getContainedValues() {
        return containedValues;
    }

    public boolean isEmpty() {
        return containedValues == 0;
    }

    public int generateKey(String value) {

        return Math.abs(Objects.hash(value));
    }

    private int getHashCode(int key) {
        int prime = 9973;
        long hash = ((long) key * prime) % hashTableSize;

        return (int) hash;
    }

    public void putOnMap(String value) {
        int key = generateKey(value);
        int hash = getHashCode(key);
        HashStruct newEntry = new HashStruct();

        newEntry.setValue(value);
        newEntry.setKey(key);

        if (hashMap[hash] == null) {
            hashMap[hash] = newEntry;
        } else {
            HashStruct scrollList = hashMap[hash];

            while (scrollList.getNext() != null) {
                scrollList = scrollList.getNext();
            }
            scrollList.setNext(newEntry);
        }
        containedValues++;
    }

    public void getFromMap(int key) {
        int hash = getHashCode(key);
        HashStruct scrollForValue = hashMap[hash];

        while (scrollForValue != null) {
            if (scrollForValue.getKey() == key) {
                System.out.println("Valor " + scrollForValue);
                return;
            }
            scrollForValue = scrollForValue.getNext();
        }
        System.out.println("Valor não encontrado no mapa");
    }

    public HashStruct removeFromMap(int key) {
        int hash = getHashCode(key);
        HashStruct scrollForValue = hashMap[hash];

        if (scrollForValue.getKey() == key) {
            hashMap[hash] = hashMap[hash].getNext();
            containedValues--;

            return scrollForValue;
        }

        while (scrollForValue != null) {
            HashStruct aux = scrollForValue;
            scrollForValue = scrollForValue.getNext();

            if (scrollForValue != null && scrollForValue.getKey() == key) {
                aux.setNext(scrollForValue.getNext());
                containedValues--;

                return scrollForValue;
            }
        }
        System.out.println("Valor não encontrado no mapa");

        return null;
    }

    public void showHashMap() {
        if (isEmpty()) {
            System.out.println("Mapa Hash está vazio");
            return;
        }

        for (int i = 0; i < hashMap.length; i++) {
            HashStruct scrollList = hashMap[i];

            while (scrollList != null) {
                System.out.println(scrollList);
                scrollList = scrollList.getNext();
            }
        }
    }

}
