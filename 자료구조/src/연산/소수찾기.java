package ����;
import java.util.*;

public class �Ҽ�ã�� {
	/**
	 * ����� ���̴� 2���� ���
	 * ���0. ����� Ȧ����(2����)
	 * ���1. n���� ���� � �Ҽ��ε� ������ �������� �ʴ´�.
	 * ���2(���). n�� ������ ������ � �Ҽ��ε� ������ �������� ������ �Ҽ��̴�.
	 * @param list
	 * @param n
	 */
	private static void FindPrimeNumber(ArrayList<Integer> list, int n) {
		for(int i=5; i<=n; i = i+2) { 
			boolean st = false;
			
			for(int idx=0; idx<list.size(); idx++) {
				
				if(list.get(idx)*list.get(idx) > i)
					break;
			
				if(i%list.get(idx)==0) {
					st = true;
					break;
				}
			}
			
			if(!st) {
				list.add(i);
			}
			
		}
	}
	
	/**
	 * �⺻���(�Ҽ��� 1�� �ڱ��ڽŸ����� ������ ��������)���� ���� 
	 * @param list
	 * @param n
	 */
	private static void FindPirmeBasic(ArrayList<Integer> list, int n) {
		for(int i=4; i<=n; i++) {
			boolean st = false;
			
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					st = true;
					break;
				}
			}
			if(!st) {
				list.add(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(2);
		list.add(3);
		
		FindPrimeNumber(list,n);
		System.out.println(list.toString());
		
	}
}
