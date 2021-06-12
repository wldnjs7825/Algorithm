package 실버3;

import java.util.*;

public class 후위표기식2 {
	static int N;
	static String str;
	static double[] num;
	static char[] expression; //식을 저장할 배열
	static Stack<Double> stack; //피연산자를 저장할 스택
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		str = sc.next();
		expression = new char[str.length()];
		num = new double[N];
		stack = new Stack<>();
		
		// 연산식을 배열에 저장한다.
		// 배열의 앞부터 읽는다.
		// 피연산자이면 stack에 저자한다.
		// 연산자이면 stack에서 피연산자 2개를 꺼낸후 계산한 값을 다시 stack에 넣어준다.
		// 마지막으로 stack에 저장된 값을 꺼내주면 된다.
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);	
			expression[i] = c;
		}
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextDouble();
		}
		
		// A는 아스키코드 65 -> 문자 - 65 하면 data 배열의 인덱스
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
