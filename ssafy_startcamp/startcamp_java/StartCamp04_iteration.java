package startcamp_java;

public class StartCamp04_iteration {
	
	public static void main(String[] args) {
		
		// for (�ʱ��; ���ǽ�; ������) {}
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		// while (���ǽ�) {}
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
		 	�� ��� �ʱ���� int i = 0; �� �ȴ�
			*/
		}
		System.out.println(sum2);
		
	}

}
