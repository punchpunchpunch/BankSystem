package client;

import java.util.Scanner;

public class HighSchoolClient extends TeenageClient{
	
	protected ClientKind kind = ClientKind.HIGHSCHOOL;
	protected String phoneParents;

	public HighSchoolClient(ClientKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner sc) {
		setClientParentPhonewithYN(sc);
		setClientId(sc);
		setClientName(sc);
		setClientAccount(sc);
		
		System.out.println("정보 등록이 완료되었습니다.");
	}
	
	public void printInfo() {
		String ckind = getKindString();
		System.out.println("Name: " + name + ", ID: " + id + ", Account: " + account + ", Money: " + money + ", Kind : " + ckind + ", Parent Phone Number: " + phoneParents);
	}
	
}