package com.kuldeep.tree;

import java.util.LinkedList;
import java.util.Queue;


public class LevelorderTraversal {
	
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
		LevelorderTraversal levelorderTraversal = new LevelorderTraversal();
		levelorderTraversal.add(4);
		levelorderTraversal.add(2);
		levelorderTraversal.add(3);
		levelorderTraversal.add(5);
		levelorderTraversal.add(6);
		levelorderTraversal.printLevelorder(levelorderTraversal.root);

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
	public void printLevelorder(Node current) {
		if(current == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(current);
		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.println(" "+node.value);
			
			if(node.left != null) {
				nodes.add(node.left);
			}
			if(node.right != null) {
				nodes.add(node.right);
			}
		}
	}

}
