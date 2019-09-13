package com.kuldeep.tree;

public class BinaryTreeHeight {
	
	private Node root;

	public static void main(String[] args) {
		BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
		binaryTreeHeight.add(4);
		binaryTreeHeight.add(2);
		binaryTreeHeight.add(3);
		binaryTreeHeight.add(5);
		binaryTreeHeight.add(6);
		System.out.println("Binary Tree Height: "+ binaryTreeHeight.treeHeight(binaryTreeHeight.root));
		
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
    
	
	private int treeHeight(Node node) {
		if (node == null) {
			return 0;
		} 
		int leftHeight = 0;
		int rightHeight = 0;
		if(node.left != null) {
			leftHeight= treeHeight(node.left);
		}
		if(node.right != null) {
			rightHeight = treeHeight(node.right);
		}
		if(leftHeight > rightHeight) {
			return leftHeight+1;
		} else {
			return rightHeight+1;
		}
	}

}
