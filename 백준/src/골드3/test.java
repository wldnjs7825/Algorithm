package °ñµå3;

public class test {

	public static void main(String[] args) {
		int a = 10;
		int b = 11;
		
		swap(a,b);
		
		System.out.println(a+" "+b);
	}
	
	public static void swap(int a, int b) {
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}

}
