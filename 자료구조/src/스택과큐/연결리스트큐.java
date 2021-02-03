package ���ð�ť;

import java.util.*;
/**
 * ���Ḯ��Ʈ�� ������ Queue
 * @author wldnj
 * Node
 * enqueue, deuqueue
 * front, rear
 * �糡���� ���԰� ������ �̷�����Ƿ� ���� ���Ḯ��Ʈ�� ����
 */
public class ���Ḯ��Ʈť {
	static class Node {
		int data;
		Node link;
		
		public Node(int data) {
			this.data = data;
			this.link = null;
		}
	}
	
	static class LinkedQueue{
		Node front;
		Node rear;
		
		public LinkedQueue() {
			this.front = null;
			this.rear = null;
		}
		
		private boolean isEmpty() {
			if(this.front == null)
				return false;
			return true;
		}
		
		private void enQue(int data) {
			Node node = new Node(data);
			
			if(!isEmpty()) {
				front = node;
				rear = node;
			}else {
				rear.link = node;
				rear = node;
			}	
		}
		
		private int deQue() {
			if(!isEmpty()) {
				System.out.println("ť �����");
			}else {
				int result = front.data;
				Node nextNode = front.link;
				front = nextNode;
				
				if(front == null) {
					rear = null;
				}
				return result;
			}
		
			return -1;
		}
		
		private void print() {
			StringBuffer sb = new StringBuffer();
			Node node = front;
			while(true) {

				if(node == null)
					break;
				sb.append(node.data+" ");
				node = node.link;				
			}
			sb.append("\n");
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LinkedQueue que = new LinkedQueue();
		boolean st = true;
		
		while(st) {
			System.out.println("1.���� 2.���� 3.��� 4.����");
			int menu = sc.nextInt();
			
			switch(menu){
			case 1:
				int data = sc.nextInt();
				que.enQue(data);
				break;
			case 2:
				data = que.deQue();
				System.out.println(data);
				break;
			case 3:
				que.print();
				break;
			default:
				st = false;
				break;	
			}
		}
	}
}
