package problem.백준.class4;

import java.util.Scanner;

public class 이진검색트리_5639 {
    static class Node{
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n){
            if(n < this.num){
                if(this.left == null){
                    this.left = new Node(n);
                }else{
                    this.left.insert(n);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(n);
                }else{
                    this.right.insert(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node tree = new Node(sc.nextInt());

        while(true){
            if(!sc.hasNext()) break;

            tree.insert(sc.nextInt());
        }
        postOrder(tree);
    }

    private static void postOrder(Node tree) {
        if(tree == null) return;

        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.num);
    }
}

