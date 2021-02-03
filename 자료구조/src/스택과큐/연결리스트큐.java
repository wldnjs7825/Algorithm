package 스택과큐;

import java.util.*;
/**
 * 연결리스트로 구현한 Queue
 * @author wldnj
 * Node
 * enqueue, deuqueue
 * front, rear
 * 양끝에서 삽입과 삭제가 이루어지므로 단일 연결리스트로 구현
 */
public class 연결리스트큐 {
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
				System.out.println("큐 비었음");
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
			System.out.println("1.삽입 2.삭제 3.출력 4.종료");
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
