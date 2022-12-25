package problem.백준;

public class 정수N개의합_15596 {
	long sum(int[] a) {
		long sum = 0;
		
		for(int i : a) {
			sum += i;
		}
		
		return sum;
	}
}
