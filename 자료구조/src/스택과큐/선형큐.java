package 스택과큐;

import java.util.*;
/**
 * 선형큐
 * @author wldnj
 * enqueue(삽입),dequeue(삭제)
 * front(앞),rear(뒤)
 * 선형큐는 삭제 후 요소들으르 앞으로 당겨야 한다.
 */
public class 선형큐 {
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
				System.out.println("큐 가득참");
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
				System.out.println("큐 비었음");
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
