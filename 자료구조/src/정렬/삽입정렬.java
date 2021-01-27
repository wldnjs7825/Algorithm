package 정렬;
import java.util.*;
// 6 4 1 7 3 9 8
public class 삽입정렬{
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[7];
		
		for(int i=0 ;i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<arr.length; i++) {
			int j;
			int tmp = arr[i];
			
			for(j=i-1; j>=0; j--) {			
				if(arr[j] <= tmp) {				
					break;
				}
				arr[j+1] = arr[j];
			}

			arr[j+1] = tmp;
		}
		
		System.out.println(Arrays.toString(arr));

	}
}
