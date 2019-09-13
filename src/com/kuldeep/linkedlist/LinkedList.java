package com.kuldeep.linkedlist;


class LinkedList { 
    Node head;
  
    class Node { 
        int value; 
        Node next; 
 
        Node(int d) { 
        	this.value = d; 
        	this.next = null;
        } 
    } 
    
    public Node insertNode(Node head, int value) {
    	Node new_Node = new Node(value);
    	if(head == null) {
    		head = new_Node;
    	} else {
    		Node last = head;
    		while(last.next !=null) {
    			last= last.next;
    		}
    		last.next = new_Node;
    	}
    	return head;
    }
    
    public void printList(LinkedList list) {
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

	int i =0;
	
	//count no of nodes involved in loop
	while(ptr1.next != ptr2) {
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

	public Node reverseList(Node node) {
    	Node prev = null;
    	Node curr = node;
    	Node next = null;
    	
    	while(curr !=null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	node = prev;
    	return node;
    	
    }
    
    public static void main(String args[]) {
    	LinkedList list = new LinkedList(); 
        list.head = list.insertNode(list.head, 1); 
        list.head = list.insertNode(list.head, 2); 
        list.head = list.insertNode(list.head, 3); 
        list.head = list.insertNode(list.head, 4); 
        list.head = list.insertNode(list.head, 5); 
        list.printList(list);
        list.head = list.reverseList(list.head);
        list.printList(list);
    }
}
