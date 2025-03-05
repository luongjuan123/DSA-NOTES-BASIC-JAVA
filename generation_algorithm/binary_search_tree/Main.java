package binary_search_tree;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class NodeManage {
    public static Node insert(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (root.data > x) {
            root.left = insert(root.left, x);
        }
        else if (root.data < x) {
            root.right = insert(root.right, x);
        }
        return root;
    }
    public static void preorder(Node root) {
        if(root != null){
            preorder(root.left);
            System.out.print(root.data +  " ");
            preorder(root.right);
        }
    }
    public static boolean nodeSearch(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        else {
            if (x < root.data) {
                return nodeSearch(root.left, x);
            }
            else {
                return nodeSearch(root.right, x);
            }
        }
    }
    public static Node minNode(Node root) {
        Node tmp = root;
        while (tmp != null && tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp;
    }
    public static Node nodeDelete(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (x < root.data) {
            root.left =  nodeDelete(root.left, x);
        }
        else if(x > root.data) {
            root.right = nodeDelete(root.right, x);
        }
        else {
            if (root.left == null || root.right == null) {
                return root.right;
            }
            else {
                Node tmp = minNode(root);
                root.data = tmp.data;
                root.right = nodeDelete(root.right, tmp.data);
            }
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        int n;
        Node root = null;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i ++) {
            int tmp;
            tmp = sc.nextInt();
            root = NodeManage.insert(root, tmp);
        }
        NodeManage.preorder(root);
        boolean check = NodeManage.nodeSearch(root, 2);
        System.out.println(check);
    }
}
