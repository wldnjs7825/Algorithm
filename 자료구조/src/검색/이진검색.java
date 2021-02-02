package �˻�;

import java.util.*;
/**
 * �����˻�
 * 1. ����
 * 2. �ݾ� ���̸� ��
*/
public class �����˻� {
	private static boolean BinarySearch(int[] arr, int target) {
		int bs = 0;
		int bf = arr.length-1;
		int bc = (bs+bf)/2;
		while(true) {
	
			if(target == arr[bc]) {
				return true;
			}else if(target < arr[bc]) {
				bf = bc-1;
			}else {
				bs = bc+1;
			}
			bc = (bs+bf)/2;
			
			if(bs > bf)
				break;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	
		int target = sc.nextInt();
		
		Boolean result = BinarySearch(arr,target);
		
		System.out.println(result?"o":"x");
	}
}