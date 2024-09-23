package trees.binary.search;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.left = insert(node.left, value);
        } else if (value > node.getValue()) {
            node.right = insert(node.right, value);
        }
        
        return node;
    }

    public boolean search(int value) {
        return search(this.root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.getValue()) {
            return true;
        } else if (value < node.getValue()) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
    
    public void remove(int value) {
        this.root = remove(this.root, value);
    }
    
    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.getValue()) {
            node.left = remove(node.left, value);
        } else if (value > node.getValue()) {
            node.right = remove(node.right, value);
        } else if (value == node.getValue()) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = node.right;

                while (successor.left != null) {
                    successor = successor.left;
                }

                node.setValue(successor.getValue());
                node.right = remove(node.right, successor.getValue());
            }
        }

        return node;
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (!(node == null)) {
            if (node.left != null) {
                inOrder(node.left);
            }

            System.out.print(node.getValue() + " ");

            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (!(node == null)) {
            System.out.print(node.getValue() + " ");

            if (node.left != null) {
                preOrder(node.left);
            }

            if (node.right != null) {
                preOrder(node.right);
            }
        }
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (!(node == null)) {
            if (node.left != null) {
                postOrder(node.left);
            }

            if (node.right != null) {
                postOrder(node.right);
            }

            System.out.print(node.getValue() + " ");
        }
    }

}
