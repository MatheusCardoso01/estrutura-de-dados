package trees.avl;

public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public AVLTree(Node node) {
        this.root = node;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
        calculateBalance();
        isBalanced();
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
        calculateBalance();
        isBalanced();
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

    public void printAVLTree() {
        System.out.println(printAVLTree(this.root, 0));
    }

    private String printAVLTree(Node node, int level) {
        if (node == null) return "<<EMPTY TREE>>";

        String treePrint = "[" + node.getValue() + "] (" + node.getBalance() + ")\n";

        for (int i = 0; i < level; i++) {
            treePrint += "\t";
        }

        if (node.left != null) {
            treePrint += "+-LEFT: " + printAVLTree(node.left, level + 1);
        } else {
            treePrint += "+-LEFT: NULL";
        }
        treePrint += "\n";

        for (int i = 0; i < level; i++) {
            treePrint += "\t";
        }

        if (node.right != null) {
            treePrint += "+-RIGHT: " + printAVLTree(node.right, level + 1);
        } else {
            treePrint += "+-RIGHT: NULL";
        }
        treePrint += "\n";

        return treePrint;

    }

    public void getHeight() {
        int height = getHeight(this.root);

        System.out.println("Tree Height: " + height);
    }

    private int getHeight(Node node) {
        if (node == null) return -1;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private void calculateBalance() {
        calculateBalance(this.root);
    }

    private void calculateBalance(Node node) {
        if (node != null) {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            node.setBalance(leftHeight - rightHeight);

            calculateBalance(node.right);
            calculateBalance(node.left);
        }
    }

    private void isBalanced() {
        this.root = isBalanced(this.root);
        calculateBalance();
    }

    private Node isBalanced(Node node) {
        if (node == null) return null;

        if (node.getBalance() > 1) {
            if (node.left != null && node.left.getBalance() >= 0) {
                node = rotateRight(node);
            } else {
                node = rotateLeftRight(node);
            }
        } else if (node.getBalance() < -1) {
            if (node.right != null && node.right.getBalance() <= 0) {
                node = rotateLeft(node);
            } else {
                node = rotateRightLeft(node);
            }
        }

        calculateBalance(node);

        node.left = isBalanced(node.left);
        node.right = isBalanced(node.right);

        return node;
    }

    private Node rotateRight(Node node) {
        Node leftSon = node.left;
        Node grandSon = leftSon.right;

        leftSon.right = node;
        node.left = grandSon;

        return leftSon;
    }

    private Node rotateLeft(Node node) {
        Node rightSon = node.right;
        Node grandSon = rightSon.left;

        rightSon.left = node;
        node.right = grandSon;

        return rightSon;
    }

    private Node rotateRightLeft(Node node) {
        Node rightSon = node.right;
        Node grandSon = rightSon.left;

        rightSon.left = grandSon.right;
        grandSon.right = rightSon;
        node.right = grandSon;

        Node newRightSon = node.right;
        node.right = null;
        newRightSon.left = node;

        return newRightSon;
    }

    private Node rotateLeftRight(Node node) {
        Node leftSon = node.left;
        Node grandSon = leftSon.right;

        leftSon.right = grandSon.left;
        grandSon.left = leftSon;
        node.left = grandSon;

        Node newLeftSon = node.left;
        node.left = null;
        newLeftSon.right = node;

        return newLeftSon;
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
