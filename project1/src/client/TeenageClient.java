package client;

import java.util.Scanner;

import exceptions.ParentPhoneFormatException;

public abstract class TeenageClient extends Client {
	protected String phoneParents = "";
	protected String schoolName;
	protected String phoneTeacher;

	
	public String getPhoneParents() {
		return phoneParents;
	}


	public void setPhoneParents(String phoneParents) throws ParentPhoneFormatException{
		if(!phoneParents.contains("-")) {
			throw new ParentPhoneFormatException();
		}
		this.phoneParents = phoneParents;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getPhoneTeacher() {
		return phoneTeacher;
	}


	public void setPhoneTeacher(String phoneTeacher) {
		this.phoneTeacher = phoneTeacher;
	}

	public TeenageClient(ClientKind kind) {
		super(kind);
	}
	
	public abstract void getUserInput(Scanner sc);
	public abstract void printInfo();
	
	public void setClientParentPhonewithYN(Scanner sc) {
		char answer = 'x';
		while (answer != 'Y' && answer != 'y' && answer != 'N' && answer != 'n') {
			System.out.print("부모님 전화번호가 있나요? (Y/N): ");
			answer = sc.next().charAt(0);
			if(answer == 'y' || answer == 'Y') {
				String phone = "";
				while(!phoneParents.contains("-")) { // 필드인 phoneParent 값이 초기화되지 않아서 NullPointException 오류날 수 있음
					System.out.print("부모님의 전화번호를 '-'기호를 넣고 입력해주세요.: ");
					phone = sc.next();
					try {
						this.setPhoneParents(phone);
					} catch (ParentPhoneFormatException e) {
						System.out.println("'-'기호를 넣어서 입력해주세요!");
					}
				}
				break;
			}
			else if(answer == 'N' || answer == 'n') {
				try {
					this.setPhoneParents("없음");
				} catch (ParentPhoneFormatException e) {
					this.phoneParents = "없음";
				}


				break;
			}
			else {
			}
		}
	}
	
	public void setClientSchoolName(Scanner sc) {
		System.out.print("등록할 고객이 재학 중인 학교를 입력하세요.: ");
		String schoolName = sc.next();
		this.setSchoolName(schoolName);
	}
	
	public void setClientPhoneTeacher(Scanner sc) {
		System.out.print("등록할 고객의 선생님 전화번호를 입력하세요.: ");
		String phoneTeacher = sc.next();
		this.setPhoneTeacher(phoneTeacher);
	}
}