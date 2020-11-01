package 실버3;

import java.util.Scanner;

public class 피보나치함수 {
	static int N,zeroCnt,oneCnt;
	static int[] dpZero;
	static int[] dpOne;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N =sc.nextInt();
			zeroCnt = 0;
			oneCnt = 0;
			dpZero = new int[N+1];
			dpOne = new int[N+1];
			reset(dpZero);
			reset(dpOne);
			System.out.println(fiboZero(N)+" "+fiboOne(N));
		}

	}

	private static void reset(int[] dp) {
		for(int i=0; i<N+1; i++) {
			dp[i] = -1;
		}	
	}
	
	private static int fiboOne(int n) {
		if(n == 0) {
			return 0;
		}else if(n == 1) {
			return 1;
		}else if(dpOne[n] != -1) {
			return dpOne[n];
		}
		dpOne[n] = fiboOne(n-1)+fiboOne(n-2);
		
		return dpOne[n];
	}


	private static int fiboZero(int n) {
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return 0;
		}else if(dpZero[n] != -1) {
			return dpZero[n];
		}
		dpZero[n] = fiboZero(n-1) + fiboZero(n-2);
		return dpZero[n];
	}

}
