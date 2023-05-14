package client;

import java.util.Scanner;

public class HighSchoolClient extends Client implements ClientInput {
	
	protected ClientKind kind = ClientKind.HIGHSCHOOL;
	protected String phoneParents;

	public HighSchoolClient(ClientKind kind) {
		super(kind);
	}
	
	public String getPhoneParents() {
		return phoneParents;
	}

	public void setPhoneParents(String phoneParents) {
		this.phoneParents = phoneParents;
	}


	public void getUserInput(Scanner sc) {
		char answer = 'x';
		while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n') {
			System.out.print("부모님 전화번호가 있나요? (Y/N): ");
			answer = sc.next().charAt(0);
			if(answer == 'y' || answer == 'Y') {
				System.out.print("부모님의 전화번호를 '-'기호 없이 입력해주세요.: ");
				String phone = sc.next();
				this.setPhoneParents(phone);
				break;
			}
			else if(answer == 'N' || answer == 'n') {
				this.setPhoneParents("없음");
				break;
			}
			else {
			}
		}
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
		System.out.println("Name: " + name + ", ID: " + id + ", Account: " + account + ", Money: " + money + ", Kind : " + ckind + ", Parent Phone Number: " + phoneParents);
	}
	
}
