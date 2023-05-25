package client;

import java.util.Scanner;

public class ElementarySchoolClient extends TeenageClient{
	protected ClientKind kind = ClientKind.ELEMENTARY;
	
	public ElementarySchoolClient(ClientKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner sc) {
		setClientParentPhonewithYN(sc);
		setClientSchoolName(sc);
		setClientPhoneTeacher(sc);
		setClientId(sc);
		setClientName(sc);
		setClientAccount(sc);
		
		System.out.println("정보 등록이 완료되었습니다.");
	}
	
	public void printInfo() {
		String ckind = getKindString();
		System.out.println("Name: " + name + ", ID: " + id + ", Account: " + account + ", Money: " + money + 
				", Kind : " + ckind + ", Parent Phone Number: " + phoneParents + ", School Name: " + schoolName + 
				", Teacher Phone Number: " + phoneTeacher);
	}
}