package com.kuldeep.tree;

public class PostorderTraversal {
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
		PostorderTraversal postorderTraversal = new PostorderTraversal();
		postorderTraversal.add(4);
		postorderTraversal.add(2);
		postorderTraversal.add(3);
		postorderTraversal.add(5);
		postorderTraversal.add(6);
		postorderTraversal.printPostorder(postorderTraversal.root);
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

	private void printPostorder(Node node) {
		if (node == null) {
			return;
		}
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.value);

	}
}
