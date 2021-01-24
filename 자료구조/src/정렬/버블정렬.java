package ����;

import java.util.*;


public class �������� {
	static int[] arr;
	
	private static void swap(int pre, int next) {
		int tmp = arr[pre];
		arr[pre] = arr[next];
		arr[next] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("���� �� : "+Arrays.toString(arr));
	
		//��ü ����Ŭ ��(�迭 ũ�� -1�� �ݺ�)
		for(int i=0; i<arr.length-1; i++) {
			
			//��ȯ�� �ѹ��� �Ͼ�� ������ ���� ����
			boolean st = false;
			
			//�� ����Ŭ���� ���� Ƚ��(�迭ũ��-1���� �ѻ���Ŭ�� �迭ũ�� �ٿ����鼭...)
			for(int j=0; j<arr.length-1-i; j++) {
				//j�� �� Ŭ���� ����
				if(arr[j] > arr[j+1]) {
					st = true;
					swap(j,j+1);
				}
			}
			if(!st) {
				break;
			}
		}
		
		System.out.println("���� �� : "+Arrays.toString(arr));
	}


}