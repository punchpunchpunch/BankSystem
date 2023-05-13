package manuProto;

import java.util.Scanner;

/**
 *학생 은행 프로그램의 메뉴 화면
 */
public class MenuManager {
	
	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		ClientManager clientManager = new ClientManager(sc);
		
		// while문을 통해 6.Exit가 아닐 경우, 선택지에서의 활동 후에 메뉴 출력 반복
		while(num != 6) {
			System.out.println("Menu");
			System.out.println("\t1. New Account");
			System.out.println("\t2. Delete Acoount");
			System.out.println("\t3. Infomation");
			System.out.println("\t4. Deposit/Withdrawal");
			System.out.println("\t5. Client Editor");
			System.out.println("\t6. Exit");
			System.out.print("Select one number between 1 ~ 6: ");
			
			num = sc.nextInt();
			
			// switch문을 사용하여 num 변수에 따라 각각 다른 메소드 수행
			switch(num) {
			case 1:
				clientManager.addClient();
				break;
			case 2:
				clientManager.deleteClient();
				break;
			case 3:
				clientManager.viewClient();
				break;
			case 4:
				clientManager.dwFunction();
				break;
			case 5:
				clientManager.edit();
				break;
			}
		}
		System.out.println("End the program");
	}

}