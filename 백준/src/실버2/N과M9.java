package ½Ç¹ö2;

import java.util.*;

public class N°úM9 {
	static int N,M;
	static int[] num,result;
	static boolean[] visited;
	static LinkedHashSet<String> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		result = new int[M];
		visited = new boolean[N];
		set = new LinkedHashSet<>();
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		Perm(0);
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		
//		List list = new ArrayList(set);
//		Collections.sort(list);
//		StringBuilder sb = new StringBuilder();
//		for(int i=0; i<list.size(); i++) {
//			sb.append(list.get(i));
//		}
//		System.out.println(sb);
	}
	
	private static void Perm(int idx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			boolean st = set.add(sb.toString());

			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = num[i];
				Perm(idx+1);
				visited[i] = false;
			}
		}
	}
}
