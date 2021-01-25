package 정렬;
import java.util.*;

public class 선택정렬{
	static int[] arr;
	
	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		arr = new int[7];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//배열의 원소의 갯수 만큼 반복
		for(int i=0; i<arr.length; i++) {
			
			int min_idx = i;
			
			for(int j=i; j<arr.length; j++) {
				if(arr[j] < arr[min_idx]) {
					min_idx = j;
				}					
			}
			
			swap(i,min_idx);
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
