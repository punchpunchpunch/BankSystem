package manuProto;

import java.util.Scanner;

public class ManuManagement {

	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		AccountManagement accountManagement = new AccountManagement(input);
		
		while (num != 7) { // while문을 사용하여 num 변수가 5가 아닌 경우 메뉴 출력을 반복
			System.out.println("Menu");
			// 메뉴 화면임을 알려주는 출력이다.
			System.out.println("\t1. New Account");
			// 계좌를 생성하는 메뉴이다.
			System.out.println("\t2. Delete Account");
			// 계좌를 삭제하는 메뉴이다.
			System.out.println("\t3. Edit Account");
			// 계좌를 수정하는 메뉴이다.
			System.out.println("\t4. Deposit/Withdraw Inquiry");
			// 입출금 내역을 조회하는 메뉴이다.
			System.out.println("\t5. Deposit");
			// 입금하는 메뉴이다.
			System.out.println("\t6. Withdraw");
			// 출금하는 메뉴이다.
			System.out.println("\t7. Exit");
			// 화면에서 나가게 하는 메뉴이다.
			System.out.printf("Select one number between 1~7: ");
			
			num = input.nextInt();
			
			// if, else if, else문을 사용하여 num 변수에 따라 각각 다른 작업을 수행한다.
			if (num == 1) {
				accountManagement.makeAccount();
			}
		
			else if (num == 2) {
				accountManagement.deleteAccount();
			}
			
			else if (num == 3) {
				accountManagement.editAccount();
			}
			
			else if (num == 4) {
				accountManagement.inquire();
			}
			
			else if (num == 5) {
				accountManagement.deposit();
			}
			else if (num == 6) {
				accountManagement.withdraw();
			}
		}
		System.out.println("End the program");
	}

}
