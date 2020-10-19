package D4;

import java.util.ArrayList;
import java.util.Scanner;

//����

public class ���Ĺ�� {
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
			
			//1�� ���� ���� ����� (����)
			comb(0,list.size());
			
			//��� ���
			System.out.println("#"+tc+" "+min);
		}

	}
	
	private static void comb(int idx, int storeCnt) {
		if(idx == storeCnt) {
		
			//������ ������ �ּҺ�� ã��
			
			//���õ� ���谡 ������ ����� �ʿ� x
			boolean st = false;
			for(int i=0; i<list.size(); i++) {
				if(result[i])
					st = true;
			}
			
			if(st)
				calDist();
			
			return;
		}
		//idx ����
		result[idx] = true;
		comb(idx+1,storeCnt);
		//idx ���� x
		result[idx] = false;
		comb(idx+1,storeCnt);
		
	}

	private static void calDist() {
		int sum = 0;
	
		//���õ� ���� ��� ���ϱ�
		for(int i=0; i<list.size(); i++) {
			if(result[i]) {
				Store tmpStore = list.get(i);
				sum += tmpStore.price;			
			}
		}
		
		//�ݺ��� ���鼭 �Ÿ� ����ϱ�
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					map[r][c] = -1;
					
					int minDist = Integer.MAX_VALUE;
					boolean st = false;
					
					//���õ� ��� ���Կ� �Ÿ� ����ؼ� �ּڰ� �־��ֱ�
					for(int i=0; i<list.size(); i++) {
						//���õ� ������� �Ÿ��� ���
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


		//-1�� �ٽ� 1�� �ٲ��ָ� map �ʱ�ȭ
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == -1) 
					map[r][c] =1;
			}
		}
		
		// min�� ����
		min = Math.min(min, sum);
	
	}
}
