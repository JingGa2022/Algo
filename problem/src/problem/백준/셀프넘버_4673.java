package problem.백준;

public class 셀프넘버_4673 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] selfNum = new boolean[10001];
		
		for(int i = 1; i<=10000; i++) {
			String s = Integer.toString(i);
			int sum = i;
			
			for(int j = 0; j<s.length(); j++) {
				sum += s.charAt(j) - '0';
			}
			if(sum > 10000) continue;
			selfNum[sum] = true;
		}
		
		for(int i = 1; i<=10000; i++) {
			if(!selfNum[i]) sb.append(i + "\n");
		}
		System.out.println(sb);
	}
}
