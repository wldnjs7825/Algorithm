package D4;

import java.util.ArrayList;
import java.util.Scanner;

//조합

public class 음식배달 {
	static int N,min;
	static int[][] map;
	static boolean[] result;
	static ArrayList<Store> list;
	static class Store{
		int r;
		int c;
		int price;
		public Store(int r, int c, int price) {
			this.r = r;
			this.c = c;
			this.price = price;
		}
	}
		
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			list = new ArrayList<>();
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
					if(map[r][c] >= 2) {
						list.add(new Store(r,c,map[r][c]));
					}
				}
			}
				
			result = new boolean[list.size()];
			min = Integer.MAX_VALUE;
			
			//1번 가게 조합 만들기 (조합)
			comb(0,list.size());
			
			//결과 출력
			System.out.println("#"+tc+" "+min);
		}

	}
	
	private static void comb(int idx, int storeCnt) {
		if(idx == storeCnt) {
		
			//선택한 집으로 최소비용 찾기
			
			//선택된 가계가 없으면 계산할 필요 x
			boolean st = false;
			for(int i=0; i<list.size(); i++) {
				if(result[i])
					st = true;
			}
			
			if(st)
				calDist();
			
			return;
		}
		//idx 선택
		result[idx] = true;
		comb(idx+1,storeCnt);
		//idx 선택 x
		result[idx] = false;
		comb(idx+1,storeCnt);
		
	}

	private static void calDist() {
		int sum = 0;
	
		//선택된 가게 비용 더하기
		for(int i=0; i<list.size(); i++) {
			if(result[i]) {
				Store tmpStore = list.get(i);
				sum += tmpStore.price;			
			}
		}
		
		//반복문 돌면서 거리 계산하기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					map[r][c] = -1;
					
					int minDist = Integer.MAX_VALUE;
					boolean st = false;
					
					//선택된 모든 가게와 거리 계산해서 최솟값 넣어주기
					for(int i=0; i<list.size(); i++) {
						//선택된 가계면은 거리를 계산
						if(result[i]) {
							st = true;
							int dist = Math.abs(list.get(i).r - r)+Math.abs(list.get(i).c - c);
							minDist = Math.min(minDist, dist);
						}
					}
					if (st) {
						sum += minDist;
					}
				}
			}
		}


		//-1을 다시 1로 바꿔주며 map 초기화
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == -1) 
					map[r][c] =1;
			}
		}
		
		// min값 수정
		min = Math.min(min, sum);
	
	}
}
