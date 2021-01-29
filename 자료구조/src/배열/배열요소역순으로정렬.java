package 배열;
import java.util.*;

public class 배열요소역순으로정렬 {
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
	
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr.length/2; i++) {
			//i와 arr.length-1-i와 swap
			swap(arr,i,arr.length-1-i);
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
