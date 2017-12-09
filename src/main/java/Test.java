public class Test {
	public static void main(String args[]) {
		int x = 100;
		int a, b, c;
		while (x <= 999) {
			a = x % 10;
			b = (x % 100 - a) / 10;
			c = (x - x % 100) / 100;
			if (a * a * a + b * b * b + c * c * c == x) {
				System.out.println(x);
			}
			x += 1;
		}
	}
}