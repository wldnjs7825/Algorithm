package ����;
import java.util.*;
/**
 * ������
 * @author wldnj
 * ���������� ������ �츮�� ������ ����
 * �׷캰�� ��� ���������� ����
 * 2ĭ�� ������ �����Ϳ� ���� 2-����(��ü �������� ���� �ѱ׷�)
 * 4ĭ�� ������ �����Ϳ� ���� 4-����(��ü �������� 1/4�� �ѱ׷�)
 * ū ���Ŀ�-> �������� ex) 4-���� �� 2-���� ���������� 1-����
 * ������ġ�� �ָ� �̵�Ƚ���� �������� ������ �����Ͽ� �ִ��� ���Ŀ� ����� ���·� ����� ������
 * 1. ���а� ã��
 * 2. ���а��� ��ŭ ��ġ�� �ε��� ���� ���� 
 * 3. ���а��� 1���� ���̸� 2���� �ݺ�
 */
public class ������ {
	static void SellSort(int[] arr, int gap) {
		
		while(gap>0) {
			
			for(int i=0; i<gap; i++) {
	
				InsertionSort(arr, i, gap);

			}
			gap /= 2;
		}
	}
	static void InsertionSort(int[] arr, int start, int gap) {
		for(int i=start+gap;i<arr.length; i += gap) {
			int j;
			int tmp = arr[i];
			for(j = i-gap; j>= start; j -= gap) {
		
				if(arr[j] <= tmp) {
					break;
				}
				arr[j+gap] = arr[j];
			}
	
			arr[j+gap] = tmp;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//���⼭�� n�� ������ �������� ���а����� ����
		SellSort(arr,n/2);
		
		System.out.println(Arrays.toString(arr));
	
	}
}
//10
//6 2 5 3 1 4 9 8 7 10