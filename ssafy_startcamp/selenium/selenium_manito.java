package selenium_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_manito {    
	public static void main(String[] args) {
		// 이클립스 콘솔 입력을 받기 위해 Scanner 생성
		Scanner sc = new Scanner(System.in);
		// 아이디를 입력 받기 위한 안내 메세지 출력
		System.out.println("이메일(아이디)를 입력하세요.");
		// 입력 받는 값을 userId로 초기화
		String userId = sc.next(); 
		// 비밀번호를 입력 받기 위한 안내 메세지 출력
		System.out.println("비밀번호를 입력하세요.");
		// 입력 받는 값을 userPw로 초기화
		String userPw = sc.next();
		
		// 이전 enter 입력을 제거 하기 위한 코드
		sc.nextLine();
		System.out.println("마니또에게 보낼 편지 내용을 입력하세요.");
		// message는 공백(스페이스바)를 처리 하기위해 nextLine 사용
		String message = sc.nextLine();
		
		// 이름을 입력 받기 위한 안내 메세지 출력
		System.out.println("편지를 보내는 본인의 이름을 입력하세요.");
		// 입력 받는 값을 userName로 초기화
		String userName = sc.next();
		
		// 반 인원을 ㄱㄴㄷ 순으로 정렬하여 배열 생성
		String[] students = {"권재현","김세진","김지환","명소이","박민아","박은수","박정훈","양동근","우창진","유혜승","유호영","윤길재","이구범","이담비","이병수","이수지","이승연","이영현","이은지","이주원","이지은","전민정","전예은","정덕주","차다운","최동헌","최승준","한재훈"};
		
		// 추후 마니또에 편지를 보낼때 사용 할 셀렉터 번호 지정
		Map<String, Object> hashMap = new HashMap();
		for (int i=1; i <= 28; i++) {
			hashMap.put(students[i-1], i);
		}
		
		// 프로그램을 동작하는 사용자의 셀렉터 번호를 추출
		int userNum = (int)hashMap.get(userName);
		
		// 본인에게 쪽지 보내는 상황을 방지하기 위해 본인 번호를 제외시킴. 1~27 숫자 중 랜덤 추출 후 본인 번호보다 크거나 같으면 +1
		int receiveNum = 1 + (int)(Math.random() * 27);
		if (userNum <= receiveNum) {
			receiveNum += 1;
		}
		
		// 크롬 드라이버
		WebDriver driver = new ChromeDriver();
		
		// 브라우저 크기 최대로 설정 (반응형 웹페이지 대응 문제 임시 해결을 위해..)
		driver.manage().window().maximize();

		// edu ssafy 접속
		driver.get("https://edu.ssafy.com");
		
		// userId 입력
		WebElement idInput = driver.findElement(By.cssSelector("#userId"));
		idInput.sendKeys(userId);
		
		// userPw 입력
		WebElement pwInput = driver.findElement(By.cssSelector("#userPwd"));
		pwInput.sendKeys(userPw);
		
		// enter 입력으로 로그인
		pwInput.sendKeys(Keys.ENTER);
		
		// 맨 처음 생기는 팝업 닫기
		WebElement popupBtn = driver.findElement(By.cssSelector("#_POPUP_NTC > div.pop-foot > button.btn.btn-wide.btn-md.btn-primary.pop-event-close"));
		popupBtn.click();
		
		// navbar에서 커뮤니티 탭 클릭
		WebElement comunityBtn = driver.findElement(By.cssSelector("#header > div.header-inner.tac.with-job.cols5 > div.column.tac.hidden-field > ul > li:nth-child(3) > a"));
		comunityBtn.click();
		
		// 우리반 보기 클릭
		WebElement classBtn = driver.findElement(By.cssSelector("#wrap > form > div > div.content-header > div.center-inner > div > ul > li:nth-child(4) > a"));
		classBtn.click();
		
		// 위에서 랜덤하게 선정한 대상의 체크박스 셀렉터를 체크
		WebElement chkBox = driver.findElement(By.cssSelector("#wrap > form > div > div.content > div > section > div > article > div.wrap-lst-student > ul > li:nth-child(" + receiveNum + ") > div > div.posrt > div > ins"));
		chkBox.click();
		
		// 알림 보내기 버튼 클릭
		WebElement manitoBtn = driver.findElement(By.cssSelector("#wrap > form > div > div.content > div > section > div > article > div.sort-list > div > div.search-select.align > a"));
		manitoBtn.click();		
		
		// 알림의 제목 입력
		String titleContent = "마니또에게 편지가 도착했습니다"; // 제목은 통일 된 제목으로 하드코딩
		WebElement titleInput = driver.findElement(By.cssSelector("#ntcnTit"));
		titleInput.sendKeys(titleContent);
		
		// 알림의 내용 입력
		WebElement messageInput = driver.findElement(By.cssSelector("#ntcnCont"));
		messageInput.sendKeys(message);
		
		// 알림 보내기 클릭
		WebElement sendBtn = driver.findElement(By.cssSelector("#sendFormPop > div.pop-content-wrap > form > div.pop-foot > div:nth-child(2) > div > button"));
		sendBtn.click();
		
		// 전송 클릭
		WebElement confirmBtn = driver.findElement(By.cssSelector("#defaultPop > div > div.pop-foot > div.column.tal.n2 > div > button"));
		confirmBtn.click();
		
	}
}
