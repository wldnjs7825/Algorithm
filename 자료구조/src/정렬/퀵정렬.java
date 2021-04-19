package ����;

import java.util.*;

/**
 * ������
 * 
 * @author wldnj �ǹ��� �������� ����(��������) �ǹ� ���ϴ� ���� �̻��� ������ front�� rear�� �������� stop
 *         �ݺ�(���) front,rear,pivot
 */

//�Ǻ��� ������ ���� �ִٰ� ����
public class ������ {
		
	static void quickSort(int[] arr, int left, int right) {
		
		if (left > right) {
			return;
		}
		
		int l = left;
		int r = right;
		int pivot = arr[right];
		
		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] >= pivot && l < r ) {
				r--;
			}
			swap(arr, arr[l],arr[r]);
		
		}
		arr[right] = arr[l];
		arr[l] = pivot;

		quickSort(arr, left, l - 1);
		quickSort(arr, l + 1, right);

	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int left = 0;
		int right = arr.length - 1;
		quickSort(arr, left, right);

		System.out.println(Arrays.toString(arr));
	}

}
