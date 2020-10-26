import java.util.Scanner;

public class �ǹ�5 {
	static int N,target;
	static int[][] map;
	//�̵����� ������ �� �� �� ��
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		
		map = new int[N][N];
		//������ �ι� �ٲ� �� ���� �̵�ĭ�� +1
	

		int nr = N/2;
		int nc = N/2;
		map[nr][nc] = 1;
		int d = 0;
		int dist = 1;
		int n = 1;
		
		test : while(true) {
			
			if(d==2 || d==4) {
				dist++;
				d %= 4;
			}
			
			for(int i=1 ; i<=dist; i++) {
				if(n >= N*N)
					break test;
				nr = nr+dr[d];
				nc = nc+dc[d];
				n++;
				map[nr][nc] = n;
			}
			d++;
		}
		
		print();
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		int resultR =0;
		int resultC =0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(map[r][c]+" ");
				if(map[r][c] == target) {
					resultR = r+1;
					resultC = c+1;
				}
			}
			sb.append("\n");
		}
		sb.append(resultR+" "+resultC+"\n");
		System.out.println(sb);
	}

}
