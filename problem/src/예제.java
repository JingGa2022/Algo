
public class 예제 {
	public static void main(String[] args) {
		int c = 100;
		
		int[][] arr = new int[10][10];
		
		for(int i = 0 ; i<10; i++) {
			for(int j = 0 ; j<10; j++) {
				int tmp = arr[i][j] + c;
				arr[i][j] = arr[j][i];
				arr[j][i] = tmp - c;
			}
		}
		for(int i = 0 ; i<10; i++) {
			for(int j = 0 ; j<10; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
