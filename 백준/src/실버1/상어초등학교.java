package �ǹ�1;


import java.util.*;

public class ����ʵ��б� {
	//1. ����ִ� �ڸ��� �����ϴ� �л��� ������ ĭ�� ���� ���� ĭ
	//2. 1�� �����ϴ� ĭ�� ���� ���̸�, ������ ĭ�� ����ִ� ĭ�� ���� ���� ĭ
	//3. 2�� �����Ѵ� ĭ�� ���� ���̸�, ���� ��ȣ�� ���� ���� ĭ����, ���� ��ȣ�� ���� ���� ĭ 
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
