package �ǹ�3;
import java.util.*;

public class N��M2 {
	static int N,M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[N];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		Comb(0,1);
		
		System.out.println(sb);
	}
	
	private static void Comb(int idx, int depth) {
		if(idx == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		if(depth > N) {
			return;
		}
		
		//����idx�� �����ϴ� ���
		result[idx] = depth;
		Comb(idx+1, depth+1);
		//����idx�� �������� �ʴ� ���
		Comb(idx, depth+1);
		
	}
}
