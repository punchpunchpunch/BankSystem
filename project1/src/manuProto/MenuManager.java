package manuProto;

import java.util.Scanner;
/**
 *메뉴 화면임을 알리고, 수행할 선택지들을 보여주기 위한 class이다.
 */
public class MenuManager {
	public static void main(String[] args) {
		int num =0;
		Scanner sc = new Scanner(System.in);
		ClientManager ClientManager = new ClientManager(sc);
		// 반복문을 통해 6.Exit가 아닐 경우, 선택지에서의 활동 후에 메뉴가 다시 출력되도록함.
		while(num != 6) {
			System.out.println("Menu");
			System.out.println("\t1.New Account");
			System.out.println("\t2.Delete Acoount");
			System.out.println("\t3.infomation");
			System.out.println("\t4.Deposit/Withdrawal");
			System.out.println("\t5.Client Editor");
			System.out.println("\t6.Exit");
			System.out.println("Select one number between 1 ~ 6");
			num = sc.nextInt(); //선택지 선택을 위한 스캐너
			
			/*
			 * switch문을 통해, 위 번호 중 하나를 선택했을 때를 case로 나누어서 활동을 가능하게 하고
			 * 활동이 끝나면 break를 통해 switch문을 끝내고 메뉴가 출력가능하도록 함.
			 * 각 switch문은 각 메소드를 통해 작동한다.
			 */
			switch(num) {
			case 1:
				ClientManager.addClient();
				break;
			case 2:
				ClientManager.deleteClient();
				break;
			case 3:
				ClientManager.viewClient();
				break;
			case 4:
				ClientManager.dwFunction();
				break;
			case 5:
				ClientManager.edit();
				break;
			}
		}
		System.out.print("프로그램이 정상적으로 종료되었습니다.");//메뉴에서 6번을 입력했을 경우, 종료를 알리는 출력문
		sc.close();
	}

}