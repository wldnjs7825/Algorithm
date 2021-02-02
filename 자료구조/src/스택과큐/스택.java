package 스택과큐;

import java.util.*;
/**
 * @author wldnj
 * 후입선출
 * 1. push, push 못할 때(isFull)
 * 2. pop, pop 못할 때(isEmpty) 
 * 3. peak, peak 못할 때 //top에 있는 데이터 보기(pop하지 않음)
 * 4. 모든 데이터 출력
 */
public class 스택 {
	public static class MyStack {
		private int top; 
		private int[] myStack; 
		
		//생성자
		public MyStack(int stackSize) {
			this.top = -1;
			this.myStack = new int[stackSize];
		}
		
		public boolean IsFull() {
			if(this.myStack.length-1 <= this.top) {
				System.out.println("가득참");
				return false;
			}
			return true;
		}
		
		private int push(int data) {
			if(!IsFull()) {
				return -1;
			}
			this.top++;
			this.myStack[top] = data;
			
			return 1;
		}
		
		private boolean IsEmpty() {
			if(this.top <= -1) {
				System.out.println("비었음");
				return false;
			}
			return true;
		}
		
		private int pop() {
			if(!IsEmpty()) {
				return -1;
			}
			return this.myStack[top--];
		}
		
		private int peek() {
			if(!IsEmpty()) {
				return -1;
			}
			return this.myStack[top];
		}
		
		private void print() {
			for(int i=0; i <= this.top; i++) {
				System.out.print(this.myStack[i]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		MyStack mstack = new MyStack(size);
		boolean st = true;
		
		while(st) {
			System.out.println("1.push 2.pop 3.peak 4.print 5.종료");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				int data = sc.nextInt();
				mstack.push(data);
				break;
			case 2:
				mstack.pop();
				break;
			case 3:
				System.out.println(mstack.peek());
				break;
			case 4:
				mstack.print();
				break;
			default :
				st = false;
				break;
			}
		}
	}
}
