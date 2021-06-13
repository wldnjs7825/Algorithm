package 실버1;


import java.util.*;

public class 상어초등학교 {
	//1. 비어있는 자리중 좋아하는 학생이 인접한 칸에 가장 많은 칸
	//2. 1을 만족하는 칸이 여러 개이면, 인접한 칸중 비어있는 칸이 가장 많은 칸
	//3. 2를 만족한느 칸이 여러 개이면, 행의 번호가 가장 작은 칸으로, 열의 번호가 가장 작은 칸 
	static int N;
	static int[][] map, student;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		student = new int[N*N][5];
		
		for(int i=0; i<N*N; i++) {
			for(int j=0; j<5; j++) {
				student[i][j] = sc.nextInt();
			}
		}
		
		
	}
}
