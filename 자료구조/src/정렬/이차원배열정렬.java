package ����;

import java.util.*;

public class �������迭���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[6][3];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] == o2[0]) { 	
					
					if(o1[1] == o2[1]) { 
						return Integer.compare(o2[2], o1[2]); //2���� ����(���������� �ڿ��� - �տ���)
					}
					
					return Integer.compare(o1[1], o2[1]); //1���� ����
				}
				else {
					return o1[0] - o2[0]; //0���� ����
				}
				
			}
		});

		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
//2 3 4 
//1 2 3 
//5 6 7
//5 4 3
//5 6 1
//5 6 8