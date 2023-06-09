package manuProto;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import client.ClientInput;
import client.ClientKind;
import client.ElementarySchoolClient;
import client.HighSchoolClient;
import client.MiddleSchoolClient;
import client.UniversityClient;

public class ClientManager implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2069244142315676937L;

	ArrayList<ClientInput> clients = new ArrayList<ClientInput>();
	
	transient Scanner sc;
	ClientManager(Scanner sc) {
		this.sc = sc;
	}
	
	// 고객을 추가하는 메소드
	public void addClient() {
		int kind = -1;
		ClientInput clientInput;
		while (kind < 1 || kind > 4) {
			try {
				System.out.println("1. 대학생");
				System.out.println("2. 고등학생");
				System.out.println("3. 중학생");
				System.out.println("4. 초등학생");
				System.out.print("1 ~ 4 중 등록할 고객의 유형을 선택해주세요.: ");
				kind = sc.nextInt();
				switch(kind) {
				case 1:
					clientInput = new UniversityClient(ClientKind.UNIVERSITY);
					clientInput.getUserInput(sc);
					clients.add(clientInput);
					break;
				case 2:
					clientInput = new HighSchoolClient(ClientKind.HIGHSCHOOL);
					clientInput.getUserInput(sc);
					clients.add(clientInput);
					break;
				case 3:
					clientInput = new MiddleSchoolClient(ClientKind.MIDDLESCHOOL);
					clientInput.getUserInput(sc);
					clients.add(clientInput);
					break;
				case 4:
					clientInput = new ElementarySchoolClient(ClientKind.ELEMENTARY);
					clientInput.getUserInput(sc);
					clients.add(clientInput);
					break;
				}
				
				
				
				
			}
			catch(InputMismatchException e) {
				System.out.println("Please put a integer between 1 and 4!");
				if (sc.hasNext()) {
					sc.next();
				}
				kind = -1;
			}
		}
	}
	
	// 고객을 삭제하는 메소드
	public void deleteClient() {
		System.out.print("삭제할 고객의 id를 입력하세요.: ");
		int clientId = sc.nextInt();
		int index = findIndex(clientId);
		removefromClients(index, clientId);
	}
	
	public int findIndex(int clientId) {
		int index = -1;
		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getId() == clientId) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public int removefromClients(int index, int clientId) {
		if(index >= 0) {
			clients.remove(index);
			System.out.println(clientId + " 고객이 삭제되었습니다.");
			return 1;
		}
		else {
			System.out.println(clientId + " 고객이 존재하지 않습니다.");
			return -1;}
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
	
	public int size() {
		return clients.size();
	}
	
	public ClientInput get(int index) {
		return clients.get(index);
	}
	
	// 고객 정보를 수정하는 메소드
	public void edit() {
		System.out.print("수정할 고객의 id를 입력하세요.: ");
		int clientId = sc.nextInt();
		for(int i = 0; i < clients.size(); i++) {
			ClientInput client = clients.get(i);
			if (client.getId() == clientId) {
				int num = -1;
				while (num != 5) {
					showEditMenu();
					num = sc.nextInt();
					switch(num) {
					case 1:
						client.setClientId(sc);
						break;
					case 2:
						client.setClientName(sc);
						break;
					case 3:
						client.setClientAccount(sc);
						break;
					case 4:
						client.setClientMoney(sc);
						break;
					default:
						continue;
					}
				}
				break;
			}
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
	

	public void showEditMenu() {
		System.out.println("Client Info Edit Menu");
		System.out.println("1. Edit ID");
		System.out.println("2. Edit Name");
		System.out.println("3. Edit Account");
		System.out.println("4. Edit Money");
		System.out.println("5. Exit");
		System.out.println("Select one number between 1 ~ 5");
	}
		
}