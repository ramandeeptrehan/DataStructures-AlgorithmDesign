package com.ramantrehan.linkedList;

import java.util.Stack;

class ListNode {
	int value;
	ListNode next;
	ListNode jump;
	
	public ListNode() {
		this.value = -1; //unexplored
		this.next = null;
		this.jump = null;
	}
}

public class JumpListOrder {
	
	private ListNode prepareNodes() {
		//create empty nodes
		ListNode head = new ListNode();
		ListNode node2 = new ListNode();
		ListNode node3 = new ListNode();
		ListNode node4 = new ListNode();
		ListNode node5 = new ListNode();
		
		//add next connections
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		//add jump connections
		head.jump = node3;
		node3.jump = node2;
		node2.jump = node4;
		node4.jump = null;
		
		return head;
	}
	
	private void computeJumpOrderHelper(ListNode node, Integer orderCounter) {
		if(node == null || node.value != -1) {
			return;
		}
		
		//do the work on the node
		node.value = orderCounter;
		orderCounter++;
		
		//explore pointers
		computeJumpOrderHelper(node.jump, orderCounter);
		computeJumpOrderHelper(node.next, orderCounter);
	}
	
	public void computeJumpOrder(ListNode head) {
		Integer orderCounter = 1;
		computeJumpOrderHelper(head, orderCounter);
	}
	
	public void computeJumpOrderIterative(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		stack.push(head);
		
		ListNode stackNode;
		int orderCounter = 1;
		
		while(!stack.isEmpty()) {
			stackNode = stack.pop();
			
			if(stackNode != null && stackNode.value == -1) {
				//do the work
				stackNode.value = orderCounter;
				orderCounter++;
				
				//explore pointers
				stack.push(stackNode.next);
				stack.push(stackNode.jump);
			}
		}
	}
	
	public void printList(ListNode head) {
		ListNode temp = head;
		
		while(temp!=null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		JumpListOrder obj = new JumpListOrder();
		
		ListNode head = obj.prepareNodes();
		
		obj.computeJumpOrder(head);
		//obj.computeJumpOrderIterative(head);
		obj.printList(head); //expected: 1, 3, 2, 4, 5	
	}
}
