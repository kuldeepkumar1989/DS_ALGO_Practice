package com.kuldeep.tree;

public class IsBinarySearchTree {
private Node root;
	public static void main(String[] args) {
		IsBinarySearchTree tree = new IsBinarySearchTree(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
  
        if (tree.isBST()) 
            System.out.println("IS Binary Search Tree"); 
        else
            System.out.println("Not a Binary Search Tree"); 
	}
	private boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, 
                Integer.MAX_VALUE); 
	}
	private boolean isBSTUtil(Node node, int minValue, int maxValue) {
		if(node == null) {
			return true;
		}
		
		if(node.value < minValue || node.value > maxValue)
			return false;
		
		return (isBSTUtil(node.left, minValue, node.value-1) && isBSTUtil(node.right, node.value+1, maxValue));
	}

}
