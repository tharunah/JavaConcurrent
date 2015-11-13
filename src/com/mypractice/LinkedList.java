package com.mypractice;

public class LinkedList {

	private Node head;
	private Node tail;
	private int count = 0;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public void addNode(String data) {
		Node node = new Node(data);
		if (head == null) {
			this.head = node;
			this.tail = node;
			count++;
		} else {

			tail.next = node;
			tail = node;
			count++;
		}
	}

	
	public Node removeNode(Node node) {
		if (node != null) {
			Node p = head;
			if (node.data.equals(p.next.data)) {
				head = head.next;
				if (count == 1) {
					tail = head;
				}
			
				count--;
				return p;
			}

			while (p.next != null) {
				if (node.data.equals(p.next.data)) {
					Node temp = p.next;
					p.next = p.next.next;
					count--;
					return temp;
				} else {
					p = p.next;
				}
			}
		}
		return null;
	}
    
	public int size() {
		return count;
	}

	public static class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
			this.next = null;
		}

		public Node getNext() {
			return next;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;

		}
		public String toString() {
			return data;
		}

		public boolean equals(Object node) {
			if (node instanceof Node) {
				return this.data.equals(((Node) node).getData());
			}
			return false;
		}

	}

}
