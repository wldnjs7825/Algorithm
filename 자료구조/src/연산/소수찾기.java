package 연산;
import java.util.*;

public class 소수찾기 {
	/**
	 * 계산을 줄이는 2가지 방법
	 * 방법0. 대상은 홀수만(2제외)
	 * 방법1. n보다 작은 어떤 소수로도 나누어 떨어지지 않는다.
	 * 방법2(결론). n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않으면 소수이다.
	 * @param list
	 * @param n
	 */
	private static void FindPrimeNumber(ArrayList<Integer> list, int n) {
		for(int i=5; i<=n; i = i+2) { 
			boolean st = false;
			
			for(int idx=0; idx<list.size(); idx++) {
				
				if(list.get(idx)*list.get(idx) > i)
					break;
			
				if(i%list.get(idx)==0) {
					st = true;
					break;
				}
			}
			
			if(!st) {
				list.add(i);
			}
			
		}
	}
	
	/**
	 * 기본방법(소수는 1과 자기자신만으로 나누어 떨어진다)으로 구현 
	 * @param list
	 * @param n
	 */
	private static void FindPirmeBasic(ArrayList<Integer> list, int n) {
		for(int i=4; i<=n; i++) {
			boolean st = false;
			
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					st = true;
					break;
				}
			}
			if(!st) {
				list.add(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(2);
		list.add(3);
		
		FindPrimeNumber(list,n);
		System.out.println(list.toString());
		
	}
}
