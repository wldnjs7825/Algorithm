package �ǹ�4;

import java.util.*;

public class ����ġ�Ѱ���� {
	static int N,P;
	static int[] sw;
	static int[][] peo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //����ġ ����
		sw = new int[N+1]; //����ġ ����
		
		for(int i=1; i<=N; i++) {
			sw[i] = sc.nextInt();
		}
		
		P = sc.nextInt(); //��� ��
		peo = new int[P][2]; //����(��:1, ��:2), ��
		for(int r=0; r<P; r++) {
			peo[r][0] = sc.nextInt();
			peo[r][1] = sc.nextInt();
		}

		//P��ŭ �ݺ�
		for(int i=0; i<P; i++) {
			if(peo[i][0] == 1) {
				//���ڸ� �ڱ� ����� ���� �ٲٱ�
				int t = 1;
				for(int j=peo[i][1]; j<sw.length; j=peo[i][1]*t) {
					if(sw[j] == 1) {
						sw[j] = 0;
					}else {
						sw[j] = 1;
					}
					t++;
				}
				
			}else {
				//���ڸ� ���� �߽� ��Ī���°� ������ ���� ���� �ٲٱ�
				int t=1;
				int idx = peo[i][1];
				
				//�ڱ��ڽ� �ٲٱ�
				if(sw[idx] == 1) {
					sw[idx] = 0;
				}else {
					sw[idx] = 1;
				}
				
				while(true) {
					
					if(idx-t < 1 || idx+t > N || (sw[idx-t] != sw[idx+t])) {
						break;
					}
					
					if(sw[idx+t] == 1) {
						sw[idx+t] = 0;
						sw[idx-t] = 0;
					}else {
						sw[idx+t] = 1;
						sw[idx-t] = 1;
					}
					
					t++;
				}
			}
			
		}
		
		Print();
		
	}
	
	private static void Print() {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<sw.length; i++) {
			sb.append(sw[i]+" ");
			
			if(i%20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
