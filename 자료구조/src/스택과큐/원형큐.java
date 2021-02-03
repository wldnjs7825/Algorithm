package ���ð�ť;

import java.util.*;

import ���ð�ť.���Ḯ��Ʈť.LinkedQueue;

/**
 * ����ť
 * @author wldnj
 * enqueue,dequeue
 * front,rear, dataCnt
 * �迭�� ó���� ���� ����Ǿ��ִٰ� ���� �ڷᱸ��
 * if���ǹ��� ������ �������� �ٲ� �� ����
 */

public class ����ť {
	static class CircleQueue{
		int[] que;
		int front;
		int rear;
		int dataCnt;
		
		public CircleQueue(int size) {
			que = new int[size];
			front = 0;
			rear = 0;
			dataCnt = 0;
		}
		
		private boolean isEmpty() {
			if(dataCnt == 0)
				return true;
			return false;
		}
		
		private boolean  isFull() {
			if(dataCnt == que.length)
				return true;
			return false;
		}
		
		private void enQue(int data) {
			if(isFull()) {
				System.out.println("ť ������");
			}else {
				que[rear] = data;
				dataCnt++;
				
				if(rear<que.length-1) {
					rear++;
				}else {
					rear = 0;
				}
				
			}
		}
		
		private int deQue() {
			if(isEmpty()) {
				System.out.println("ť �����");
				return -1;
			}
			int result = que[front];
			que[front] = 0;
			dataCnt--;
			
			if(front<que.length-1) {
				front++;
			}else {
				front=0;
			}
			
			return result;
		}
		
		private void print() {
			StringBuilder sb = new StringBuilder();
			int idx = front;
			int tmpCnt = dataCnt;
		
			while(tmpCnt>0) {
				sb.append(que[idx]+" ");
				idx++;
				tmpCnt--;
				if(idx == que.length) {
					idx = 0;
				}	
				
			}
			sb.append("\n");
			System.out.println(sb);	
		}
	}
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		CircleQueue que = new CircleQueue(size);
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
