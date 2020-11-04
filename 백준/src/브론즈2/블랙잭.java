package 브론즈2;

import java.util.Scanner;

public class 블랙잭 {
	static int N, target, max;
	static boolean st;
	static int[] card,result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		card = new int[N];
		
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		st = false; //target이랑 같으면 재귀를 종료할 변수
		result = new int[3];
		max = 0;
		comb(0,0,0);
		System.out.println(max);
	}
	private static void comb(int idx, int depth, int sum) {
		if(st)
			return;
		if(sum > target)
			return;
		if(idx == 3) {
			if(sum == target)
				st = true;
//			System.out.println(sum+" "+max);
			max = Math.max(max, sum);
			return;
		}
		if(depth == N) {
			return;
		}
		
		result[idx] = card[depth];
		sum += card[depth];
		comb(idx+1,depth+1,sum);
		sum -= card[depth];
		comb(idx,depth+1,sum);
		
	}

}
