package 연산;
import java.util.*;

public class 난수생성 {
	
	//0부터 n미만 까지의 수 중 랜덤해서 return
	//Math.random()함수는 double형 0.0 이상 1.0미만의 난수 생성
	//현재시간을 seed로 사용
	private static int MathRandom(int n) {
		return (int)(Math.random()*n);
	}
	
	
	//Random객체 생성후 n미만의 난수 생성해서 return
	private static int MakeRandom(int n) {
		//random객체 생성후 seed로 현재 시간을 넣어줌
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		
		return rand.nextInt(n);
	}
	public static void main(String[] args) {
		int n = 0;
		while(n<100) {
			n++;
			System.out.println(MathRandom(10)+" "+MakeRandom(10));
		}
	}
}
