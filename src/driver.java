import java.io.IOException;
import java.util.Scanner;

public class driver {
	Scanner sc;
	SubwayBuild subBuild;// 데이터 생성 객체.
	SubwayController controller;// 컨트롤러 선언.
	//driver 생성자 메서드.
	public driver() throws IOException {
		sc = new Scanner(System.in);
		subBuild = new SubwayBuild();// 데이터 생성 요청.
	}
	//driver 동작 메서드.
	public void go() {
		// 사용자와 컨택 시작.
		System.out.println("길찾기 프로그램이 시작 되었습니다. \n우선 탐색 항목을 설정(입력) 해주세요.");
		System.out.println("거리(Km) - 1, 시간(분) - 2, 비용(원) - 3\n:");
		// 우선 탐색 항목 및 출발역과 도착역 입력받기.
		int value = sc.nextInt();
		System.out.println("출발역을 입력해주세요 : ");
		String start = sc.next();
		System.out.println("도착역을 입력해주세요 : ");
		String end = sc.next();
		
		controller = new SubwayController(start, end, subBuild);// 입력된 정보를 바탕으로 컨트롤러 생성.
		
		switch (value) {
		case 1:// 거리 우선 탐색 시작.
			controller.findMeter();
			controller.showAll();
			break;
		case 2:// 시간 우선 탐색 시작.
			controller.findTime();
			controller.showAll();
			break;
		case 3:// 비용 우선 탐색 시작.
			controller.findMoney();
			controller.showAll();
			break;
		default:
			System.out.println("탐색 옵션을 잘못 선택하셨습니다. \n 프로그램을 종료합니다.");
			return;// 프로그램 종료.
		}
	}
	//메인 런처.
	public static void main(String[] args) throws IOException {
		driver lun = new driver();
		lun.go();		
	}

}
