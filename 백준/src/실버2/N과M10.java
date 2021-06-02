package ½Ç¹ö2;

import java.util.*;

public class N°úM10 {
	static int N,M;
	static int[] num, result;
	static HashSet<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		set = new LinkedHashSet<>();
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		Perm(0,0);
		
		Iterator it = set.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		
		System.out.println(sb);
	}
	
	private static void Perm(int idx, int preIdx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			set.add(sb+"");
			return;
		}
		
		for(int i=preIdx; i<N; i++) {
			result[idx] = num[i];
			Perm(idx+1, i+1);
		}
	}
}
