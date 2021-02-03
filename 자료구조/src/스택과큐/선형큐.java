package ���ð�ť;

import java.util.*;
/**
 * ����ť
 * @author wldnj
 * enqueue(����),dequeue(����)
 * front(��),rear(��)
 * ����ť�� ���� �� ��ҵ����� ������ ��ܾ� �Ѵ�.
 */
public class ����ť {
	public static class MyQueue{
		private int[] que;
		private int front;
		private int rear;
		
		public MyQueue(int size) {
			this.que = new int[size];
			this.front = -1;
			this.rear = -1;
		}
		
		private boolean isFull() {
			if(this.rear >= this.que.length-1) {
				System.out.println("ť ������");
				return false;
			}
			return true;
		}
		
		private int enQue(int data) {
			if(!isFull()) {
				return -1;
			}
			this.que[++rear] = data;
			return 1;
		}
		
		private boolean isEmpty() {
			if(this.front == rear) {
				System.out.println("ť �����");
				return false;
			}
			return true;
		}
		
		private int deQue() {
		
			if(!isEmpty()) {
				return -1;
			}
			int result = this.que[0];
			
			rear--;
			
			for(int i=0; i<=rear; i++) {
				this.que[i] = this.que[i+1];
			}
			
			return result;
		}
		
		private void print() {
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<=rear; i++) {
				sb.append(this.que[i]+" ");
			}
			sb.append("\n");
			System.out.println(sb);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		MyQueue que = new MyQueue(size);
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
