package problem.백준.class4;

import java.util.Scanner;

class Node {
	char data;
	Node right;
	Node left;

	public Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	public void createNode(char data, char left, char right) {
		if (root == null) {
			
			if(data != '.') root = new Node(data);
			if (left != '.')
				root.left = new Node(left);
			if (right != '.')
				root.right = new Node(right);
		} else
			searchNode(root, data, left, right);
	}

	private void searchNode(Node root, char data, char left, char right) {
		if (root == null) {
			return;
		} else if (root.data == data) {

			if (left != '.')
				root.left = new Node(left);
			if (right != '.')
				root.right = new Node(right);
		} else {
			searchNode(root.left, data, left, right);
			searchNode(root.right, data, left, right);
		}
	}
	
	public void preorder(Node root) {
		System.out.print(root.data);
		if(root.left !=null) preorder(root.left);
		if(root.right !=null) preorder(root.right);
	}
	
	public void inorder(Node root) {
		if(root.left !=null) inorder(root.left);
		System.out.print(root.data);
		if(root.right !=null) inorder(root.right);
	}
	
	public void postorder(Node root) {
		if(root.left !=null) postorder(root.left);
		if(root.right !=null) postorder(root.right);
		System.out.print(root.data);
	}
}

public class 트리순회_1991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		Tree tree = new Tree();
		
		for(int i = 0; i < N ;i++) {
			tree.createNode(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
		}
		
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		
	}
}
