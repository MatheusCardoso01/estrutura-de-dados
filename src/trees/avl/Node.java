package trees.avl;

public class Node {

    private int value;
    private int balance;
    protected Node left;
    protected Node right;

    public Node(int value) {
        this.value = value;
        this.balance = 0;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.balance = 0;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
