package 정렬;
import java.util.*;
/**
 * 셸정렬
 * @author wldnj
 * 삽입정렬의 장점은 살리고 단점은 보완
 * 그룹별로 묶어서 삽입정렬을 실행
 * 2칸씩 떨어진 데이터와 정렬 2-정렬(전체 데이터의 반이 한그룹)
 * 4칸씩 떨어진 데이터와 정렬 4-정렬(전체 데이터의 1/4가 한그룹)
 * 큰 정렬에-> 작은정렬 ex) 4-정렬 후 2-정렬 마지막으로 1-정렬
 * 삽입위치가 멀면 이동횟수가 많아지는 단점을 보완하여 최대한 정렬에 가까운 형태로 만들고 정렬함
 * 1. 증분값 찾기
 * 2. 증분값차 만큼 위치한 인덱스 끼리 정렬 
 * 3. 증분값을 1까지 줄이며 2번을 반복
 */
public class 셸정렬 {
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
		
		//여기서는 n을 반으로 나눈것을 증분값으로 선택
		SellSort(arr,n/2);
		
		System.out.println(Arrays.toString(arr));
	
	}
}
//10
//6 2 5 3 1 4 9 8 7 10