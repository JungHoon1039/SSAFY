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
		// ��Ŭ���� �ܼ� �Է��� �ޱ� ���� Scanner ����
		Scanner sc = new Scanner(System.in);
		// ���̵� �Է� �ޱ� ���� �ȳ� �޼��� ���
		System.out.println("�̸���(���̵�)�� �Է��ϼ���.");
		// �Է� �޴� ���� userId�� �ʱ�ȭ
		String userId = sc.next(); 
		// ��й�ȣ�� �Է� �ޱ� ���� �ȳ� �޼��� ���
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		// �Է� �޴� ���� userPw�� �ʱ�ȭ
		String userPw = sc.next();
		
		// ���� enter �Է��� ���� �ϱ� ���� �ڵ�
		sc.nextLine();
		System.out.println("���϶ǿ��� ���� ���� ������ �Է��ϼ���.");
		// message�� ����(�����̽���)�� ó�� �ϱ����� nextLine ���
		String message = sc.nextLine();
		
		// �̸��� �Է� �ޱ� ���� �ȳ� �޼��� ���
		System.out.println("������ ������ ������ �̸��� �Է��ϼ���.");
		// �Է� �޴� ���� userName�� �ʱ�ȭ
		String userName = sc.next();
		
		// �� �ο��� ������ ������ �����Ͽ� �迭 ����
		String[] students = {"������","�輼��","����ȯ","�����","�ڹξ�","������","������","�絿��","��â��","������","��ȣ��","������","�̱���","�̴��","�̺���","�̼���","�̽¿�","�̿���","������","���ֿ�","������","������","������","������","���ٿ�","�ֵ���","�ֽ���","������"};
		
		// ���� ���϶ǿ� ������ ������ ��� �� ������ ��ȣ ����
		Map<String, Object> hashMap = new HashMap();
		for (int i=1; i <= 28; i++) {
			hashMap.put(students[i-1], i);
		}
		
		// ���α׷��� �����ϴ� ������� ������ ��ȣ�� ����
		int userNum = (int)hashMap.get(userName);
		
		// ���ο��� ���� ������ ��Ȳ�� �����ϱ� ���� ���� ��ȣ�� ���ܽ�Ŵ. 1~27 ���� �� ���� ���� �� ���� ��ȣ���� ũ�ų� ������ +1
		int receiveNum = 1 + (int)(Math.random() * 27);
		if (userNum <= receiveNum) {
			receiveNum += 1;
		}
		
		// ũ�� ����̹�
		WebDriver driver = new ChromeDriver();
		
		// ������ ũ�� �ִ�� ���� (������ �������� ���� ���� �ӽ� �ذ��� ����..)
		driver.manage().window().maximize();

		// edu ssafy ����
		driver.get("https://edu.ssafy.com");
		
		// userId �Է�
		WebElement idInput = driver.findElement(By.cssSelector("#userId"));
		idInput.sendKeys(userId);
		
		// userPw �Է�
		WebElement pwInput = driver.findElement(By.cssSelector("#userPwd"));
		pwInput.sendKeys(userPw);
		
		// enter �Է����� �α���
		pwInput.sendKeys(Keys.ENTER);
		
		// �� ó�� ����� �˾� �ݱ�
		WebElement popupBtn = driver.findElement(By.cssSelector("#_POPUP_NTC > div.pop-foot > button.btn.btn-wide.btn-md.btn-primary.pop-event-close"));
		popupBtn.click();
		
		// navbar���� Ŀ�´�Ƽ �� Ŭ��
		WebElement comunityBtn = driver.findElement(By.cssSelector("#header > div.header-inner.tac.with-job.cols5 > div.column.tac.hidden-field > ul > li:nth-child(3) > a"));
		comunityBtn.click();
		
		// �츮�� ���� Ŭ��
		WebElement classBtn = driver.findElement(By.cssSelector("#wrap > form > div > div.content-header > div.center-inner > div > ul > li:nth-child(4) > a"));
		classBtn.click();
		
		// ������ �����ϰ� ������ ����� üũ�ڽ� �����͸� üũ
		WebElement chkBox = driver.findElement(By.cssSelector("#wrap > form > div > div.content > div > section > div > article > div.wrap-lst-student > ul > li:nth-child(" + receiveNum + ") > div > div.posrt > div > ins"));
		chkBox.click();
		
		// �˸� ������ ��ư Ŭ��
		WebElement manitoBtn = driver.findElement(By.cssSelector("#wrap > form > div > div.content > div > section > div > article > div.sort-list > div > div.search-select.align > a"));
		manitoBtn.click();		
		
		// �˸��� ���� �Է�
		String titleContent = "���϶ǿ��� ������ �����߽��ϴ�"; // ������ ���� �� �������� �ϵ��ڵ�
		WebElement titleInput = driver.findElement(By.cssSelector("#ntcnTit"));
		titleInput.sendKeys(titleContent);
		
		// �˸��� ���� �Է�
		WebElement messageInput = driver.findElement(By.cssSelector("#ntcnCont"));
		messageInput.sendKeys(message);
		
		// �˸� ������ Ŭ��
		WebElement sendBtn = driver.findElement(By.cssSelector("#sendFormPop > div.pop-content-wrap > form > div.pop-foot > div:nth-child(2) > div > button"));
		sendBtn.click();
		
		// ���� Ŭ��
		WebElement confirmBtn = driver.findElement(By.cssSelector("#defaultPop > div > div.pop-foot > div.column.tal.n2 > div > button"));
		confirmBtn.click();
		
	}
}
