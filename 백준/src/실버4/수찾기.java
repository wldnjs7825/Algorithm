package 실버4;

import java.util.*;

public class 수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer> set = new LinkedHashSet<>();
		for(int i=0; i<N; i++) {
			set.add(sc.nextInt());
		}
		
		int resultN = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<resultN; i++) {
			if(set.contains(sc.nextInt())) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb);
	}
}
