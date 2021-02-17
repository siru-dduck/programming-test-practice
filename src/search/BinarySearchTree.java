package search;

import java.util.Arrays;

public class BinarySearchTree {
    Node root;

    public Integer search(int key) {
        Node result = search(root, key);
        return result == null ? null : result.data;
    }

    private Node search(Node node, int key) {
        if (node == null || node.data == key) {
            return node;
        } else if (node.data < key) {
            return search(node.right, key);
        } else {
            return search(node.left, key);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else if (node.data < data) {
            node.right = insert(node.right, data);
        } else if (node.data > data) {
            node.left = insert(node.left, data);
        }
        return node;
    }

    private static class Node {
        Integer data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        // when
        int[] arr = {5, 2, 3, 7, 1, 10, 9, 8, 4};
        int key = 10;
        Integer expected = 10;
        BinarySearchTree bst = new BinarySearchTree();
        Arrays.stream(arr).forEach(bst::insert);

        // given
        Integer result = bst.search(key);

        // then
        System.out.println(expected.equals(result));

    }

}
