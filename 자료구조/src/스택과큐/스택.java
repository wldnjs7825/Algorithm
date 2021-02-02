package ���ð�ť;

import java.util.*;
/**
 * @author wldnj
 * ���Լ���
 * 1. push, push ���� ��(isFull)
 * 2. pop, pop ���� ��(isEmpty) 
 * 3. peak, peak ���� �� //top�� �ִ� ������ ����(pop���� ����)
 * 4. ��� ������ ���
 */
public class ���� {
	public static class MyStack {
		private int top; 
		private int[] myStack; 
		
		//������
		public MyStack(int stackSize) {
			this.top = -1;
			this.myStack = new int[stackSize];
		}
		
		public boolean IsFull() {
			if(this.myStack.length-1 <= this.top) {
				System.out.println("������");
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
				System.out.println("�����");
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
			System.out.println("1.push 2.pop 3.peak 4.print 5.����");
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
