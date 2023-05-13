package client;

import java.util.Scanner;

public class UniversityClient extends Client implements ClientInput {
	
	public UniversityClient(ClientKind kind) {
		super(kind);
	}
	
	public void printInfo() {
		String ckind ="none";
		switch (this.kind) {
		case UNIVERSITY :
			ckind = "대학생";
			break;
		case HIGHSCHOOL :
			ckind = "고등학생";
			break;
		case MIDDLESCHOOL :
			ckind = "중학생";
			break;
		case ELEMENTARY :
			ckind = "초등학생";
			break;
		default:
		}
		System.out.println("Name: " + name + ", ID: " + id + ", Account: " + account + ", Money: " + money + ", Kind : " + ckind);
	}

	public void getUserInput(Scanner sc) {
		System.out.print("등록할 고객의 id를 입력해주세요.: ");
		int id = sc.nextInt();
		this.setId(id); 
		
		System.out.print("등록할 고객의 이름을 입력해주세요.: ");
		String name = sc.next();
		this.setName(name);
		
		System.out.print("등록할 고객의 계좌번호를 입력해주세요.: ");
		int account = sc.nextInt();
		this.setAccount(account);
		
		System.out.println("정보 등록이 완료되었습니다.");
		
	}
	
}
