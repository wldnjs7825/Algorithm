package 실버3;

import java.util.*;

public class N과M6 {
	static int N,M;
	static int[] num;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		result = new int[M];
		sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		//N개중 M개를 뽑는 경우의 수
		Comb(0,0);
		
		System.out.println(sb);
	}
	
	private static void Comb(int idx, int depth) {
		if(idx == M) {
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}else if(depth == N) {
			return;
		}
		
		result[idx] = num[depth];
		Comb(idx+1,depth+1);
		Comb(idx,depth+1);
		
	}
}
