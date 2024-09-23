package hashing;

public class HashStruct {

    private int key;
    private String value;
    private HashStruct next;

    public HashStruct() {
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public HashStruct getNext() {
        return next;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(HashStruct next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Value: " + this.value + "\n" +
               "Key: " + this.key;
    }

}
