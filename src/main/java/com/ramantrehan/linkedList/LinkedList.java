package com.ramantrehan.linkedList;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	
	private Node head;
	
	//O(n)
	public void insertAtEnd(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node temp = head;
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		temp.next = new Node(data);
	}
	
	//O(n)
	public void printList() {
		Node temp = head;
		
		while(temp!=null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		
		for(int i = 1; i<=10; i++) {
			obj.insertAtEnd(i);
		}
		
		obj.printList();
	}
}
