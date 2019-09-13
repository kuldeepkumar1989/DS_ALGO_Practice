package com.kuldeep.linkedlist;

public class LinkedListLoopRemoval {
 
	    Node head;
	  
	    class Node { 
	        int value; 
	        Node next; 
	 
	        Node(int d) { 
	        	this.value = d; 
	        	this.next = null;
	        } 
	    } 
	    
	    
	    public void printList(LinkedListLoopRemoval list) {
	    	Node curr_node = list.head;
	    	while(curr_node != null) {
	    		System.out.println(curr_node.value);
	    		curr_node= curr_node.next;
	    	}
	    }
	    
	    public boolean detectAndRemoveLoop(Node head) 
	    { 
	        Node slow = head, fast = head; 
	        while (slow != null && fast != null && fast.next != null) { 
	            slow = slow.next; 
	            fast = fast.next.next; 
	  
	            if (slow == fast) { 
	                removeLoop(slow, head); 
	                return true; 
	            } 
	        } 
	        return false; 
	    } 
	    
	    private void removeLoop(Node loop, Node head) {
		Node ptr1= loop;
		Node ptr2 = loop;

		int i =1;
		
		//count no of nodes involved in loop
		while(ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			i++;
		}
		
		// set one pointer to beginning and other one at ith node
		ptr1 = head;
		ptr2 = head;
		
		for (int j =0 ; j<i; j++) {
			ptr2 = ptr2.next;
		}
		
		//move both pointer with same pace to find loop starting point
		while(ptr2 != ptr1) {
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		
		// Get pointer to the last node 
	    while (ptr2.next != ptr1) { 
	        ptr2 = ptr2.next; 
	    } 

	    /* Set the next node of the loop ending node 
	     to fix the loop */
	    ptr2.next = null; 
			
		}
	    
	    public static void main(String args[]) {
	    	LinkedListLoopRemoval list = new LinkedListLoopRemoval(); 
	    	 list.head = list.new Node(50); 
	         list.head.next = list.new Node(20); 
	         list.head.next.next = list.new Node(15); 
	         list.head.next.next.next = list.new Node(4); 
	         list.head.next.next.next.next = list.new Node(10); 
	   
	         // Creating a loop for testing 
	         list.head.next.next.next.next.next = list.head.next.next; 
	         
	        //list.printList(list);
	        System.out.println("Loop : "+list.detectAndRemoveLoop(list.head));
	        list.printList(list);
	    }
	}
