package startcamp_java;

public class StartCamp02_variable {
	
	public static void main(String[] args) {
		int int_var;
		int_var = 321;
		
		long long_var;
		long_var = 1234567891234L;
		
		boolean bool_var = true;
		bool_var = false;
		
		char char_var = 'A';
		char_var = '0';
		char_var = '%';
		// 문자열 "" 문자 ''
		
		float float_var = (float)123.123; // 명시적 형변환 (값 앞에 괄호안에 타입 기재) <-> 묵시적 형변환 (컴파일러가 자동 타입변환 실행)
		double double_var = 42148912.213891230;
		
		// int 100won; (변수명은 숫자로 시작 불가)
		// int long; (변수명은 자바 키워드 사용 불가)
	}
	
}
