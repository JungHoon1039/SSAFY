package startcamp_java;

public class StartCamp04_iteration {
	
	public static void main(String[] args) {
		
		// for (초기식; 조건식; 증감식) {}
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// while (조건식) {}
		int sum2 = 0;
		int i = 1;
		while (i <= 100) {
			/*
			sum2 += i;
			i++;
			*/
			sum2 += i++;
			/*
			sum2 += ++i;
		 	인 경우 초기식이 int i = 0; 이 된다
			*/
		}
		System.out.println(sum2);
		
	}

}
