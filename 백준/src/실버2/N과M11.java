package �ǹ�2;

import java.util.*;

public class N��M11 {
	static int N,M;
	static int[] num, result;
	static HashSet<String> resultSet;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//LinkedHashSet�� �Էµ� ������� �����͸� ����
		HashSet<Integer> numSet = new LinkedHashSet<>();
		result = new int[M];
		
		for(int i=0; i<N; i++) {
			numSet.add(sc.nextInt());
		}
		
		//�ߺ��� �� ���ŵ� num �迭 ����
		num = new int[numSet.size()];
		Iterator<Integer> numIt = numSet.iterator();
		int idx =0 ;
		while(numIt.hasNext()) {
			num[idx++] = (int)numIt.next();
		}
		Arrays.sort(num);
		
		resultSet = new LinkedHashSet<>();
		BackT(0);
		
		//���
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = resultSet.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		
		System.out.println(sb);
	}
	
	private static void BackT(int idx) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append('\n');
			resultSet.add(sb+"");
			return;
		}
		
		for(int i=0; i<num.length; i++) {
			result[idx] = num[i];
			BackT(idx+1);
		}
	}
}
