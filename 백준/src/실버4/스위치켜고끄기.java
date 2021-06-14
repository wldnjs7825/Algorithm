package 실버4;

import java.util.*;

public class 스위치켜고끄기 {
	static int N,P;
	static int[] sw;
	static int[][] peo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //스위치 개수
		sw = new int[N+1]; //스위치 상태
		
		for(int i=1; i<=N; i++) {
			sw[i] = sc.nextInt();
		}
		
		P = sc.nextInt(); //사람 수
		peo = new int[P][2]; //성별(남:1, 여:2), 수
		for(int r=0; r<P; r++) {
			peo[r][0] = sc.nextInt();
			peo[r][1] = sc.nextInt();
		}

		//P만큼 반복
		for(int i=0; i<P; i++) {
			if(peo[i][0] == 1) {
				//남자면 자기 배수에 상태 바꾸기
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
				//여자면 번후 중심 대칭상태가 같은데 까지 상태 바꾸기
				int t=1;
				int idx = peo[i][1];
				
				//자기자신 바꾸기
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
