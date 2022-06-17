package 기타;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 과제 {
	public static void main(String[] args) {
		
		int[][] arr = {{31,29,31,30,31, 30, 31, 31, 30, 31, 30, 31},
				{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
		
		SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM");
		String date = sdate.format(new Date());
		int year = Integer.parseInt(date.substring(0,4));
		int month = Integer.parseInt(date.substring(5));
		int idx = (year % 4) == 0 && (year% 100) != 0 || (year %400) == 0 ? 0:1;
		
		System.out.println(arr[idx][month] + "days for" + year + "-" + month);
	}
}
