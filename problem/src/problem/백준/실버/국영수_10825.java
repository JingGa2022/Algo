package problem.백준.실버;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 국영수_10825 {
	static class Student{
		String name;
		int korean;
		int english;
		int math;
		
		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		Student[] students = new Student[n];
		
		for(int i = 0; i<n; i++) {
			students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if(o1.korean < o2.korean)
					return 1;
				else if(o1.korean == o2.korean) {
					if(o1.english > o2.english){
						return 1;
					}else if(o1.english == o2.english) {
						if(o1.math < o2.math)
							return 1;
						else if(o1.math == o2.math) {
							return o1.name.compareTo(o2.name);
						}
					}
				}
				return -1;
			}
		};
		Arrays.sort(students, comp);
		for(int i = 0; i<n; i++) sb.append(students[i].name + "\n");
		
		System.out.println(sb);
	}
}
