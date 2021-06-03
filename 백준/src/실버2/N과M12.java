package 실버2;

import java.util.*;

public class N과M12 {
	static int N,M;
	static HashSet<Integer> numSet;
	static HashSet<String> resultSet;
	static int[] num, result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		sb = new StringBuilder();
		
		//중복이 제거된 정렬된 배열 만들기
		numSet = new LinkedHashSet<>();
		
		for(int i=0; i<N; i++) {
			numSet.add(sc.nextInt());
		}
		
		num = new int[numSet.size()];
		Iterator<Integer> it = numSet.iterator();
		int idx = 0;
		while(it.hasNext()) {
			num[idx++] = (int)it.next();
		}
		
		Arrays.sort(num);
		
		BackT(0,0);
		
		System.out.println(sb);
		
	}
	
	private static void BackT(int idx, int preIdx) {
		if(idx == M) {
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=preIdx; i<num.length; i++) {
			result[idx] = num[i];
			BackT(idx+1, i);
		}
	}
}
