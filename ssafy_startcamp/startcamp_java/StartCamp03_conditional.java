package startcamp_java;

public class StartCamp03_conditional {

	public static void main(String[] args) {
		int int_var = 32;
		if (int_var % 2 == 0) {
			System.out.println("Â¦¼ö");
		} else {
			System.out.println("È¦¼ö");
			// sysout ÀÔ·Â ÈÄ ctrl + spacebar => ÀÚµ¿ ¿Ï¼º
		}
		
		char char_var = 'B';
		switch (char_var) {
		case 'A' :
			System.out.println("Apple");
		case 'B' :
			System.out.println("Banana");
		case 'C' :
			System.out.println("Coconut");
		default :
			System.out.println("¾È ¸Ô¾î");
		}
		
	}

}
