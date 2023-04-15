package manuProto;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManagement {
	ArrayList<Account> accounts = new ArrayList<Account>();
	Scanner input;
	
	AccountManagement(Scanner input) {
		this.input = input;
	}
	
	public void makeAccount() { // 계좌를 생성하는 메소드
		Account account = new Account();
		System.out.print("Account Number: ");
		account.accountNumber = input.nextInt();
		System.out.print("User Name: ");
		account.userName = input.next();
		System.out.print("Money: ");
		account.money = input.nextInt();
		accounts.add(account);
		System.out.println("계좌가 생성되었습니다. " + account.userName + "님");
	}
	
	public void deleteAccount() { // 계좌를 삭제하는 메소드
		System.out.print("Account Number: ");
		int inputNumber = input.nextInt();
		int index = -1;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).accountNumber == inputNumber) {
				index = i;
				break;
			}
		}
		
		if (index >= 0) {
			accounts.remove(index);
			System.out.println("계좌가 삭제되었습니다." + inputNumber);
		}
		else {
			System.out.println("계좌가 존재하지 않습니다.");
			return;
		}
	}
	
	public void editAccount() { // 계좌를 수정하는 메소드
		System.out.print("Account Number: ");
		int inputNumber = input.nextInt();
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.accountNumber == inputNumber) {
				int num = 0;
				while (num != 3) {
					System.out.println("** Account Info Edit Menu **");
					System.out.println("1. Edit Account Number");
					System.out.println("2. Edit User Name");
					System.out.println("3. Exit");
					System.out.println("Select one number between 1 - 6: ");
					num = input.nextInt();
					if (num == 1) {
						System.out.print("Account Number: ");
						account.accountNumber = input.nextInt();
					}
					else if ( num == 2) {
						System.out.print("User Name: ");
						account.userName = input.next();
					}
					else {
						continue;
					}
					System.out.println("계좌가 수정되었습니다." + inputNumber);
				} // while
				break;
			} // if
		}
	}
	
	public void inquire() { // 입출금 내역을 조회하는 메소드
		System.out.print("Account Number: ");
		int inputNumber = input.nextInt();
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.accountNumber == inputNumber) {
				account.printInfo();
				System.out.println("조회");
			}
		}
	}
	
	public void deposit() { // 입금하는 메소드
		System.out.print("Account Number: ");
		int accountNumber = input.nextInt();
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.accountNumber == accountNumber) {
				System.out.print("Amount of money to deposit: ");
				int moneyD = input.nextInt();
				System.out.println("입금");
			}
		}
	}

	public void withdraw() { // 출금하는 메소드
		System.out.print("Account Number: ");
		int accountNumber = input.nextInt();
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if (account.accountNumber == accountNumber) {
				System.out.print("Amount of money to withdraw: ");
				int moneyD = input.nextInt();
				System.out.println("출금");
			}
		}
	}
}
