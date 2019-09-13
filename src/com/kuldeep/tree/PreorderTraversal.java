package com.kuldeep.tree;

public class PreorderTraversal {
	private Node root;
	
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

	public static void main(String[] args) {
		PreorderTraversal preorderTraversal = new PreorderTraversal();
		preorderTraversal.add(4);
		preorderTraversal.add(2);
		preorderTraversal.add(3);
		preorderTraversal.add(5);
		preorderTraversal.add(6);
		preorderTraversal.printPreorder(preorderTraversal.root);
	}

	public void add(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null)
			return new Node(value);
		if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else if (value < current.value) {
			current.left = addRecursive(current.left, value);
		}
		return current;
	}

	private void printPreorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value);
		printPreorder(node.left);
		printPreorder(node.right);

	}

}
