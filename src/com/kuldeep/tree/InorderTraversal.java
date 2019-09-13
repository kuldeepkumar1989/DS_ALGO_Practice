package com.kuldeep.tree;

public class InorderTraversal {

	Node root;

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}
		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		}

		return current;
	}

	public void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.println(node.value);
		printInorder(node.right);
	}

	public static void main(String args[]) {
		InorderTraversal inorderTraversal = new InorderTraversal();
		inorderTraversal.add(4);
		inorderTraversal.add(2);
		inorderTraversal.add(3);
		inorderTraversal.add(6);
		inorderTraversal.add(5);
		inorderTraversal.printInorder(inorderTraversal.root);

	}

}

class Node {
	int value;
	Node left;
	Node right;

	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
