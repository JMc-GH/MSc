package Algorithms;

public class BinarySearchTree {
    private Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public void remove(int value) {
        root = remove(root, value);
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.value) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int minValue = findMinValue(node.right);
                node.value = minValue;
                node.right = remove(node.right, minValue);
                return node;
            }
        } else if (value < node.value) {
            node.left = remove(node.left, value);
            return node;
        } else {
            node.right = remove(node.right, value);
            return node;
        }
    }

    private int findMinValue(Node node) {
        if (node.left == null) {
            return node.value;
        } else {
            return findMinValue(node.left);
        }
    }
}

