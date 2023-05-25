package client;

import java.util.Scanner;

public class UniversityClient extends Client{
	
	public UniversityClient(ClientKind kind) {
		super(kind);
	}
	
	public void printInfo() {
		String ckind = getKindString();
		System.out.println("Name: " + name + ", ID: " + id + ", Account: " + account + ", Money: " + money + ", Kind : " + ckind);
	}

	public void getUserInput(Scanner sc) {
		setClientId(sc);
		setClientName(sc);
		setClientAccount(sc);
		
		System.out.println("정보 등록이 완료되었습니다.");
		
	}
	
}