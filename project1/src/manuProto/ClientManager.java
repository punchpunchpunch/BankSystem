package manuProto;

import java.util.ArrayList;
import java.util.Scanner;

import client.Client;
import client.ClientInput;
import client.ClientKind;
import client.ElementarySchoolClient;
import client.HighSchoolClient;
import client.MiddleSchoolClient;
import client.UniversityClient;

public class ClientManager {
	
	ArrayList<ClientInput> clients = new ArrayList<ClientInput>();
	
	Scanner sc;
	ClientManager(Scanner sc) {
		this.sc = sc;
	}
	
	// 고객을 추가하는 메소드
	public void addClient() {
		int kind = 0;
		ClientInput clientInput;
		while (kind != 1 && kind != 2) {
			System.out.println("1. 대학생");
			System.out.println("2. 고등학생");
			System.out.println("3. 중학생");
			System.out.println("4. 초등학생");
			System.out.print("1 ~ 4 중 등록할 고객의 유형을 선택해주세요.: ");
			kind = sc.nextInt();
			if (kind == 1) {
				clientInput = new UniversityClient(ClientKind.UNIVERSITY);
				clientInput.getUserInput(sc);
				clients.add(clientInput);
				break;
			}
			else if (kind == 2) {
				clientInput = new HighSchoolClient(ClientKind.HIGHSCHOOL);
				clientInput.getUserInput(sc);
				clients.add(clientInput);
				break;
			}
			else if (kind == 3) {
				clientInput = new MiddleSchoolClient(ClientKind.MIDDLESCHOOL);
				clientInput.getUserInput(sc);
				clients.add(clientInput);
				break;
			}
			else if (kind == 4) {
				clientInput = new ElementarySchoolClient(ClientKind.ELEMENTARY);
				clientInput.getUserInput(sc);
				clients.add(clientInput);
				break;
			}
			else {
				System.out.print("1 ~ 4 중 등록할 고객의 유형을 선택해주세요.: ");
			}
		}
	}
	
	// 고객을 삭제하는 메소드
	public void deleteClient() {
		System.out.print("삭제할 고객의 id를 입력하세요.: ");
		int clientId = sc.nextInt();
		int index = -1;
		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getId() == clientId) {
				index = i;
				break;
			}
		}
		if(index >= 0) {
			clients.remove(index);
			System.out.println(clientId + " 고객이 삭제되었습니다.");
		}
		else {
			System.out.println(clientId + " 고객이 존재하지 않습니다.");
			return;}
	}
	
	// 고객 정보를 조회하는 메소드
	public void viewClient() {
		if(clients.isEmpty()) {
			System.out.println("등록된 고객이 없습니다.");
		}
		System.out.println("등록된 고객의 수: " + clients.size());
		for(int i = 0; i < clients.size(); i++) {
			clients.get(i).printInfo();
		}
	}
	
	// 고객 정보를 수정하는 메소드
	public void edit() {
		System.out.print("수정할 고객의 id를 입력하세요.: ");
		int clientId = sc.nextInt();
		for(int i = 0; i < clients.size(); i++) {
			ClientInput clientInput = clients.get(i);
			if (clientInput.getId() == clientId) {
				int num = -1;
				while (num != 5) {
					System.out.println("Client Info Edit Menu");
					System.out.println("1. Edit ID");
					System.out.println("2. Edit Name");
					System.out.println("3. Edit Account");
					System.out.println("4. Edit Money");
					System.out.println("5. Exit");
					System.out.println("Select one number between 1 ~ 5");
					num = sc.nextInt();
					if( num == 1) {
						System.out.print("Client ID : ");
						int id = sc.nextInt();
						clientInput.setId(id);
					}
					else if ( num == 2) {
						System.out.print("Client Name : ");
						String name = sc.next();
						clientInput.setName(name);
					}
					else if (num == 3) {
						System.out.print("Client Account : ");
						int account = sc.nextInt();
						clientInput.setAccount(account);
					}
					else if(num == 4) {
						System.out.print("Client Money: ");
						int money = sc.nextInt();
						clientInput.setMoney(money);
					}
					else continue;
				}
			}
			break;
		}
	}
	
	// 인출 입금 메소드
	public void dwFunction() {
		System.out.print("고객의 id를 입력하세요.: ");
		int clientId = sc.nextInt();
		int index = -1;
		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getId() == clientId) {
			index = i;
			}
		}
		System.out.println("1. 인출");
		System.out.println("2. 입금");
		System.out.print("1 ~ 2 중 선택해주세요.: ");
		int moneySelect = sc.nextInt();
		
		//조건문을 통해 입력된 번호가 1이면 인출을, 2면 입금을 수행하고 그 외의 번호는 잘못된 번호라고 출력한다.
		if(moneySelect == 1) {
			System.out.print("인출할 금액을 입력하세요 : ");
			int outMoney = sc.nextInt();
			
			if(clients.get(index).getMoney() <= outMoney) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			else {
				clients.get(index).outMoney(outMoney);
				System.out.println("인출이 완료되었습니다. 현재 금액: " + clients.get(index).getMoney());
			}
		}
		else if(moneySelect == 2) {
			System.out.print("입금할 금액을 입력하세요 : ");
			int inMoney = sc.nextInt();
			clients.get(index).inMoney(inMoney);
			System.out.println("입금이 완료되었습니다. 현재 금액: " + clients.get(index).getMoney());
		}
		else {
			System.out.println("잘못된 번호입니다.");
		}
		
	}
}