package 정렬;

import java.util.*;


public class 버블정렬 {
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
		
		System.out.println("정렬 전 : "+Arrays.toString(arr));
	
		//전체 사이클 수(배열 크기 -1번 반복)
		for(int i=0; i<arr.length-1; i++) {
			
			//교환이 한번도 일어나지 않으면 종료 변수
			boolean st = false;
			
			//한 사이클에서 스왑 횟수(배열크기-1에서 한사이클씩 배열크기 줄여가면서...)
			for(int j=0; j<arr.length-1-i; j++) {
				//j가 더 클때만 스왑
				if(arr[j] > arr[j+1]) {
					st = true;
					swap(j,j+1);
				}
			}
			if(!st) {
				break;
			}
		}
		
		System.out.println("정렬 후 : "+Arrays.toString(arr));
	}


}