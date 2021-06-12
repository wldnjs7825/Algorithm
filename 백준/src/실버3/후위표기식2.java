package �ǹ�3;

import java.util.*;

public class ����ǥ���2 {
	static int N;
	static String str;
	static double[] num;
	static char[] expression; //���� ������ �迭
	static Stack<Double> stack; //�ǿ����ڸ� ������ ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		str = sc.next();
		expression = new char[str.length()];
		num = new double[N];
		stack = new Stack<>();
		
		// ������� �迭�� �����Ѵ�.
		// �迭�� �պ��� �д´�.
		// �ǿ������̸� stack�� �����Ѵ�.
		// �������̸� stack���� �ǿ����� 2���� ������ ����� ���� �ٽ� stack�� �־��ش�.
		// ���������� stack�� ����� ���� �����ָ� �ȴ�.
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);	
			expression[i] = c;
		}
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextDouble();
		}
		
		// A�� �ƽ�Ű�ڵ� 65 -> ���� - 65 �ϸ� data �迭�� �ε���
		for(int i=0; i<expression.length; i++) {
			char c = expression[i];
			
			if(c >= 'A' && c <= 'Z') {			
				stack.push(num[c-65]);
			}else { 
				double tmp1 = stack.pop();
				double tmp2 = stack.pop();
				double result = 0.0;
				
				switch(c) {
				case '+':
					result = tmp2+tmp1;
					break;
				case '-':
					result = tmp2-tmp1;
					break;
				case '*':
					result = tmp2 * tmp1;
					break;
				case '/':
					result = tmp2 / tmp1;
					break;
				}
				
				stack.push(result);
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));
	}
}
