package ����;

import java.util.*;

public class ���������ߺ����� {
	//�ݺ����� �̿��Ͽ� �� ����� �ߺ��� ���� �ִ��� ���ϸ� �˻�
	private static void UseWhile(int[] arr) {
		int cnt = 0;
		while(cnt< arr.length) {
			int rand = (int)(Math.random()*arr.length)+1;
			arr[cnt] = rand;
	
			for(int i=0; i<cnt; i++) {
				if(arr[i] == rand) {
					cnt--;
					break;
				}
			}
			cnt++;
		}
	}
	
	//set�ڷᱸ���� �̿�
	private static void UseSet(int[] arr) {
		Set<Integer> set = new HashSet<>();
		
		while(set.size() < arr.length) {
			int rand = (int)(Math.random()*arr.length*10)+1;
			set.add(rand);
		}
		
		Iterator<Integer> iter = set.iterator();
		int i = 0;
		while(iter.hasNext()) {
			arr[i++] = iter.next();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
//		UseWhile(arr);
		UseSet(arr);
		System.out.println(Arrays.toString(arr));
	}
}
