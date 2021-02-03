package 스택과큐;

import java.util.*;

import 스택과큐.연결리스트큐.LinkedQueue;

/**
 * 원형큐
 * @author wldnj
 * enqueue,dequeue
 * front,rear, dataCnt
 * 배열의 처음과 끝이 연결되어있다고 보는 자료구조
 * if조건문을 나머지 연산으로 바꿀 수 있음
 */

public class 원형큐 {
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
				System.out.println("큐 가득참");
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
				System.out.println("큐 비었음");
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
