package manuProto;

public class Account {
	// 필드
	int accountNumber;
	String userName;
	int money;
	
	// 생성자 오버로딩
	public void Account() {
	}
	
	public void Account(int accountNumber, String userName) {
		this.accountNumber = accountNumber;
		this.userName = userName;
	}
	
	public void Account(int accountNumber, String userName, int money) {
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.money = money;
	}
	
	// 메소드
	public int returnAccountNumber() {
		return accountNumber;
	}
	
	public int returnMoney() {
		return money;
	}
	
	public void printInfo() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("User Name: " + userName);
		System.out.println("Money: " + money);
	}
}
