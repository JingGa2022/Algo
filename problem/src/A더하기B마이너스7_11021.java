import java.util.Scanner;

public class A더하기B마이너스7_11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.printf("Case #%d: %d\n", i, a+b);
		}	
	}
}
