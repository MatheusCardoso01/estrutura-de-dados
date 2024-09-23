package list.doubly.circular.linked.list;

public class Node {

    private String elemento;
    private Node next;
    private Node prev;

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getElemento() {
        return this.elemento;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return this.prev;
    }

}
