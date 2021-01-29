package ����;
import java.util.*;

public class �������� {
	
	//0���� n�̸� ������ �� �� �����ؼ� return
	//Math.random()�Լ��� double�� 0.0 �̻� 1.0�̸��� ���� ����
	//����ð��� seed�� ���
	private static int MathRandom(int n) {
		return (int)(Math.random()*n);
	}
	
	
	//Random��ü ������ n�̸��� ���� �����ؼ� return
	private static int MakeRandom(int n) {
		//random��ü ������ seed�� ���� �ð��� �־���
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
